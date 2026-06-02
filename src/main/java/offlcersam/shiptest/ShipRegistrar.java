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

    public static int ARROWHEAD_CUSTOM_LAYOUT_ID;

    private static boolean registered;

    private ShipRegistrar() { }

    public static void registerShips() {
        if (registered) { return; }
        registered = true;

        WeaponTurretPlacement arrowheadLayout = new WeaponTurretPlacement();

        arrowheadLayout.addSlot(-55.0, 16.0);
        arrowheadLayout.addSlot(55.0, 16.0);
        ARROWHEAD_CUSTOM_LAYOUT_ID = WeaponSlotLayoutList.layouts.add(arrowheadLayout);

        float cargoMod = 0.75F;
        float integ = 200.0F;
        float carg = 75.0F * cargoMod;

        ShipList.write(
                ARROWHEAD_ID,
                30,
                Color.AZURE,
                "Arrowhead",
                "A militarized shuttlecraft in the shape of an arrowhead.",
                0,
                TypeTag.UNCOMMON,
                ARROWHEAD_RENDER_INDEX,
                27,              // Engine glow in pixels
                integ * 1.50F,                   // Hull HP 200 x 1.5 = 300
                carg * 1.10F,                    // Cargo 75 * 1.10 = 61.87
                ARROWHEAD_CUSTOM_LAYOUT_ID,      // Custom Layout
                2,                               // Energy slots
                1,                               // Armor slots
                1,                               // Shield slots
                0,                               // Device slots
                1,                               // Module slots
                1                                // Engine slots
        );


        ShipList.loadShipStatsFromItems(_database.ItemDatabase.itemDataFile);
        ModLogger.log("[ShipTest] Registered ship: Arrowhead with ID of: " + ARROWHEAD_ID);
    }
}
