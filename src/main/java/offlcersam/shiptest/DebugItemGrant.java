package offlcersam.shiptest;

import game.Player;
import mods.ModLogger;

import static offlcersam.shiptest.MarketRegistrar.*;

public final class DebugItemGrant {
    // Set to true to automatically deposit the ship when loading your character
    //Maybe make into config option if a config manager is made.
    private static final boolean ENABLE_DEBUG_GRANT = true;
    private static final String DEBUG_CHARACTER_NAME = "STEST";

    private DebugItemGrant() { }

    public static void grantShipsToDebugCharacter() {
        if (!ENABLE_DEBUG_GRANT) {
            return;
        }
        if (!DEBUG_CHARACTER_NAME.equalsIgnoreCase(Player.currentName)) {
            return;
        }
        if (Player.ship == null || Player.ship.cargo == null) {
            ModLogger.log("[ShipTest] Could not grant Ships: player cargo is not loaded.");
            return;
        }
        /*
        // Doesn't actually work but whatever
        if (Player.ship.cargo.exists(targetItemId)) {
            ModLogger.log("[ShipTest] STEST already has Arrowhead in cargo.");
            return;
        }
        */
        int[] ships = ShipRegistrar.getShipDatabaseIDs();
        for (int shipID : ships) {Player.ship.cargo.add(shipID, 1);}
        ModLogger.log(
                "[ShipTest] Granted "
                        + ships.length
                        + " ships to STEST cargo hold successfully."
        );
    }
}
