package offlcersam.shiptest;

import game.markets.Market;
import game.markets.MarketDatabase;
import game.markets.MarketItem;
import items.Item;
import illuminatus.core.datastructures.List;
import mods.ModLogger;
import java.lang.reflect.Field;

public final class MarketRegistrar {
    // Too lazy to make it work for tiers lol
    public static final int ARROWHEAD_ITEM_ID = 100000 + ShipRegistrar.ARROWHEAD_ID;
    public static final int FOUNDRY_ITEM_ID = 100000 + ShipRegistrar.FOUNDRY_ID;
    public static final int FOUNDRY_PLUS_ITEM_ID = 100000 + ShipRegistrar.FOUNDRY_PLUS_ID;
    private static final int[] SHIP_ITEM_IDS = {
            ARROWHEAD_ITEM_ID,
            FOUNDRY_ITEM_ID,
            FOUNDRY_PLUS_ITEM_ID
    };


    private static boolean registered;

    private MarketRegistrar() { }

    public static void registerMarkets() {
        if (registered) { return; }
        registered = true;

        int updatedMarkets = 0;
        List<Market> markets = getMarkets();

        if (markets != null) {
            for (int marketIndex = 0; marketIndex < markets.size(); marketIndex++) {
                Market market = markets.getChecked(marketIndex);
                if (market == null) { continue; }

                if (market.stationMatches(501) || market.stationMatches(511)) {
                    for (int itemId : SHIP_ITEM_IDS) {
                        MarketItem listing = new MarketItem(
                                itemId,
                                MarketItem.BUY_AND_SELL_ALWAYS
                        );
                        if (listing.item != null) {
                            Item.markAsMarketItem(listing.item);
                        }
                        market.addChecked(listing);
                    }

                    MarketDatabase.setMarket(marketIndex, market);
                    updatedMarkets++;
                }
            }
        }
        ModLogger.log("[ShipTest] Added " + SHIP_ITEM_IDS.length + " custom ship listings to " + updatedMarkets + " markets");
    }

    @SuppressWarnings("unchecked")
    private static List<Market> getMarkets() {
        try {
            Field field = MarketDatabase.class.getDeclaredField("markets");
            field.setAccessible(true);
            return (List<Market>) field.get(null);
        } catch (ReflectiveOperationException exception) {
            return null;
        }
    }
}
