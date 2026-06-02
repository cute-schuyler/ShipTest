package offlcersam.shiptest;

import game.markets.Market;
import game.markets.MarketDatabase;
import game.markets.MarketItem;
import items.Item;
import illuminatus.core.datastructures.List;
import mods.ModLogger;
import java.lang.reflect.Field;

public final class MarketRegistrar {
    public static final int ARROWHEAD_ITEM_ID = 100000 + ShipRegistrar.ARROWHEAD_ID;
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

                    MarketItem arrowheadListing = new MarketItem(ARROWHEAD_ITEM_ID, MarketItem.BUY_AND_SELL_ALWAYS);

                    if (arrowheadListing.item != null) {
                        Item.markAsMarketItem(arrowheadListing.item);
                    }

                    market.addChecked(arrowheadListing);

                    MarketDatabase.setMarket(marketIndex, market);
                    updatedMarkets++;
                }
            }
        }
        ModLogger.log("[ShipTest] Arrowhead added to " + updatedMarkets);
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
