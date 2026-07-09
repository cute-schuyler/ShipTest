package offlcersam.shiptest;

import illuminatus.core.graphics.Color;
import items.TypeTag;
import items.lists.ShipList;
import game.weapons.WeaponSlotLayoutList;
import game.weapons.WeaponTurretPlacement;
import mods.ModLogger;

public final class ShipRegistrar {

    // Probably shouldn't go above 9999, but I am entirely unsure.
    // Render Index should be above the built-in game ones, but it might max out.
    // No idea if the game would even like having more than 1 ship in this file.
    public static final int ARROWHEAD_ID = 350;
    public static final int ARROWHEAD_RENDER_INDEX = 350;

    public static final int FOUNDRY_ID = 40;
    public static final int FOUNDRY_PLUS_ID = 41;
    public static final int FOUNDRY_RENDER_INDEX = 349;

    private static boolean registered;

    private ShipRegistrar() { }

    public static void registerShips() {
        if (registered) { return; }
        registered = true;

        float cargoMod = 0.75F;
        float integ = 200.0F;
        float carg = 75.0F * cargoMod;

        ShipList.write(
                ARROWHEAD_ID,
                30,
                Color.AZURE,
                "Arrowhead",
                "A militarized shuttlecraft with a pointed frontend, maybe one day you could be a real arrow.",
                0,
                TypeTag.UNCOMMON,
                ARROWHEAD_RENDER_INDEX,
                37,              // Engine Position glow in pixels
                integ * 1.50F,                   // Hull HP
                carg * 1.10F,                    // Cargo
                WeaponSlotLayoutList.S_2_V,      // Weapon Layout
                2,                               // Energy slots
                1,                               // Armor slots
                1,                               // Shield slots
                0,                               // Device slots
                1,                               // Module slots
                1                                // Engine slots
        );

        float integ2 = 200;
        float carg2 = 350.0F * cargoMod * 2.0F;

        ShipList.write(
                FOUNDRY_ID,
                158,
                Color.WHITE,
                "Foundry",
                "Build an even bigger megastructure.",
                4,
                TypeTag.RARE,
                FOUNDRY_RENDER_INDEX,
                64,             // Engine Position glow in pixels
                integ2 * 1.20F,                  // Hull HP
                carg2 * 1.3F,                   // Cargo
                WeaponSlotLayoutList.S_6_V,      // Weapon Layout
                6,                               // Energy slots
                5,                               // Armor slots
                4,                               // Shield slots
                2,                               // Device slots
                5,                               // Module slots
                4                                // Engine slots
        );

        ShipList.write(
                FOUNDRY_PLUS_ID,
                216,
                Color.PURPLE,
                "Foundry+",
                "Build an even bigger megastructure+.",
                5,
                TypeTag.EXOTIC,
                FOUNDRY_RENDER_INDEX,
                64,              // Engine Position glow in pixels
                integ2 * 1.5F,                   // Hull HP
                carg2 * 1.5F,                    // Cargo
                WeaponSlotLayoutList.S_7_V,      // Weapon Layout
                6,                               // Energy slots
                6,                               // Armor slots
                5,                               // Shield slots
                3,                               // Device slots
                6,                               // Module slots
                5                                // Engine slots
        );


        ShipList.loadShipStatsFromItems(_database.ItemDatabase.itemDataFile);
        ModLogger.log("[ShipTest] Registered ship: Arrowhead with ID of: " + ARROWHEAD_ID);
        ModLogger.log("[ShipTest] Registered ship: Foundry with ID of: " + FOUNDRY_ID);
        ModLogger.log("[ShipTest] Registered ship: Foundry with ID of: " + FOUNDRY_PLUS_ID);
    }
}
