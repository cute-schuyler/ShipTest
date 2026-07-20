package garmillas;

import game.markets.Market;
import game.markets.MarketDatabase;
import game.markets.MarketItem;
import items.Item;
import illuminatus.core.datastructures.List;
import items.ItemTypeConstantsInterface;
import mods.ModLogger;
import java.lang.reflect.Field;

public final class MarketRegistrar {
private static boolean registered;
private MarketRegistrar() { }
public static void registerMarkets() {
if (registered) { return; }
registered = true;
int updatedMarkets = 0;
int addedShips = 0;
int[] ships = ShipRegistrar.getShipDatabaseIDs();
List<Market> markets = getMarkets();
if (markets != null) {
for (int marketIndex = 0; marketIndex < markets.size(); marketIndex++) {
Market market = markets.getChecked(marketIndex);
if (market == null) {continue;}
if (market.stationMatches(501) || market.stationMatches(511)) {
for (int shipID : ships) {MarketItem listing = new MarketItem(shipID,MarketItem.BUY_AND_SELL_ALWAYS);
if (listing.item != null){Item.markAsMarketItem(listing.item);}market.addChecked(listing);addedShips++;}
MarketDatabase.setMarket(marketIndex, market);
updatedMarkets++;
}}}

//     dP""b8 88      dP"Yb  88""Yb Yb  dP     888888  dP"Yb      8888b.  888888 .dP"Y8 .dP"Y8 88     888888 88""Yb 
//    dP   `" 88     dP   Yb 88__dP  YbdP        88   dP   Yb      8I  Yb 88__   `Ybo." `Ybo." 88     88__   88__dP 
//    Yb  "88 88  .o Yb   dP 88"Yb    8P         88   Yb   dP      8I  dY 88""   o.`Y8b o.`Y8b 88  .o 88""   88"Yb  
//     YboodP 88ood8  YbodP  88  Yb  dP          88    YbodP      8888Y"  888888 8bodP' 8bodP' 88ood8 888888 88  Yb 
        
ModLogger.log("[Gam] Added " + addedShips + " custom ship listings to " + updatedMarkets + " markets");}

@SuppressWarnings("unchecked")
private static List<Market> getMarkets() {
try {
Field field = MarketDatabase.class.getDeclaredField("markets");
field.setAccessible(true);
return (List<Market>) field.get(null);
} catch (ReflectiveOperationException exception) {
return null;
}}}
