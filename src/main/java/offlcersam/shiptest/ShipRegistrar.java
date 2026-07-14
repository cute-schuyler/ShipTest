package offlcersam.shiptest;

import illuminatus.core.graphics.Color;
import items.TypeTag;
import items.lists.ShipList;
import game.weapons.WeaponSlotLayoutList;
import game.weapons.WeaponTurretPlacement;
import mods.ModLogger;

public final class ShipRegistrar {

    // Until dynamic IDs are a thing, check the vanilla ShipList to make sure you don't have any number conflicts.
    // If another mod uses similar IDs, you will overwrite each other.
    // Render Index is automatically made from ship_base_###, ensure your images follow same format.
    // Render Index might have a limit, which the dev said they would up at some point to allow for more ship modding.

    public static final int ARROWHEAD_ID = 350;
    public static final int ARROWHEAD_RENDER_INDEX = 350;
    //public static int ARROWHEAD_CUSTOM_LAYOUT_ID;

    public static final int FOUNDRY_ID = 40;
    public static final int FOUNDRY_PLUS_ID = 41;
    public static final int FOUNDRY_RENDER_INDEX = 349;

    private static boolean registered;

    private ShipRegistrar() { }

    public static void registerShips() {
        if (registered) { return; }
        registered = true;

        /*
        // For reference on how to make a custom layout and position.
        WeaponTurretPlacement arrowheadLayout = new WeaponTurretPlacement();

        arrowheadLayout.addSlot(-66.0, 21.0);
        arrowheadLayout.addSlot(66.0, 21.0);
        arrowheadLayout.addSlot(-55.0, 16.0);
        arrowheadLayout.addSlot(55.0, 16.0);
        ARROWHEAD_CUSTOM_LAYOUT_ID = WeaponSlotLayoutList.layouts.add(arrowheadLayout);
        */

        // Uses default cargoMod from ShipList.
        float cargoMod = 0.75F;
        float integ = 200.0F;
        float carg = 75.0F * cargoMod;

        ShipList.write(
                ARROWHEAD_ID,
                30,                        // Int: Icon, sets icon x and y size. Unsure if this means sprite size or what.
                Color.AZURE,                    // Color: Color, unsure what exactly this affects.
                "Arrowhead",                    // String: Display name
                "Maybe one day you could be a real arrow.", // String: Display description
                0,                              // Int: Tier, affects spawning and what level its usable at.
                TypeTag.UNCOMMON,               // TypeTag, Affects spawning and loot drop, I think.
                ARROWHEAD_RENDER_INDEX,         // Int: Render Index, I have made them variables for no real reason.
                37,                             // Int: Engine Position glow in pixels
                integ * 1.50F,                  // Float: Hull HP (integ * multiplier), somewhat based off ShipList style of doing it.
                carg * 1.10F,                   // Float: Cargo (carg * multiplier), also based off ShipList style of doing it.
                WeaponSlotLayoutList.S_2_V,     // WeaponSlotLayoutList: Weapon Layout, see WeaponSlotLayoutList for full list.
                2,                              // Int: Energy slots, unsure what the UI limit for slots are but base game doesn't go above 8 currently.
                1,                              // Int: Armor slots
                1,                              // Int: Shield slots
                0,                              // Int: Device slots
                1,                              // Int: Module slots
                1                               // Int: Engine slots
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
                64,
                integ2 * 1.20F,
                carg2 * 1.3F,
                WeaponSlotLayoutList.S_6_V,
                6,
                5,
                4,
                2,
                5,
                4
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
                64,
                integ2 * 1.5F,
                carg2 * 1.5F,
                WeaponSlotLayoutList.S_7_V,
                6,
                6,
                5,
                3,
                6,
                5
        );


        ShipList.loadShipStatsFromItems(_database.ItemDatabase.itemDataFile);
        ModLogger.log("[ShipTest] Registered ship: Arrowhead with ID of: " + ARROWHEAD_ID);
        ModLogger.log("[ShipTest] Registered ship: Foundry with ID of: " + FOUNDRY_ID);
        ModLogger.log("[ShipTest] Registered ship: Foundry with ID of: " + FOUNDRY_PLUS_ID);
    }
}
