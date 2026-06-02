package offlcersam.shiptest;

import game.Player;
import mods.ModLogger;

import static offlcersam.shiptest.MarketRegistrar.ARROWHEAD_ITEM_ID;

public final class DebugItemGrant {
    // Set to true to automatically deposit the ship when loading your character
    private static final boolean ENABLE_DEBUG_GRANT = true;
    private static final String DEBUG_CHARACTER_NAME = "STEST";

    private DebugItemGrant() { }

    public static void grantArrowheadToDebugCharacter() {
        if (!ENABLE_DEBUG_GRANT) {
            return;
        }
        if (!DEBUG_CHARACTER_NAME.equalsIgnoreCase(Player.currentName)) {
            return;
        }
        if (Player.ship == null || Player.ship.cargo == null) {
            ModLogger.log("[ShipTest] Could not grant Arrowhead: player cargo is not loaded.");
            return;
        }

        int targetItemId = ARROWHEAD_ITEM_ID;

        // Doesn't actually work but whatever
        if (Player.ship.cargo.exists(targetItemId)) {
            ModLogger.log("[ShipTest] STEST already has Arrowhead in cargo.");
            return;
        }

        Player.ship.cargo.add(targetItemId, 1);
        ModLogger.log("[ShipTest] Granted Arrowhead to STEST cargo hold successfully.");
    }
}
