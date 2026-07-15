package offlcersam.shiptest;

import illuminatus.core.graphics.Color;
import items.ItemTypeConstantsInterface;
import items.TypeTag;
import items.lists.ShipList;
import game.weapons.WeaponSlotLayoutList;
import game.weapons.WeaponTurretPlacement;
import mods.ModLogger;

import java.util.ArrayList;
import java.util.List;

public final class ShipRegistrar {
    private static boolean registered;

    // Stores the base IDs of every weapon we add
    private static final List<Integer> REGISTERED_SHIP_IDS = new ArrayList<>();

    private ShipRegistrar() { }

    // Registers a ship ID and remembers it for later use.
    private static int registerShipID(int id) {
        REGISTERED_SHIP_IDS.add(id);
        ModLogger.log("[ShipTest] Added ship ID to registry: " + id);
        return id;
    }

    // Returns database ID for all ships.
    public static int[] getShipDatabaseIDs() {
        int[] ids = new int[REGISTERED_SHIP_IDS.size()];

        for (int i = 0; i < REGISTERED_SHIP_IDS.size(); i++) {
            ids[i] = ItemTypeConstantsInterface.SHIP * 10000 + REGISTERED_SHIP_IDS.get(i);
        }
        return ids;
    }

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
                registerShipID(350),
                30,                        // Int: Icon, sets Icon according to sprite sheet.
                Color.AZURE,                    // Color: Color, unsure what exactly this affects.
                "Arrowhead",                    // String: Display name
                "Maybe one day you could be a real arrow.", // String: Display description
                0,                              // Int: Tier, affects spawning and what level it's usable at.
                TypeTag.UNCOMMON,               // TypeTag, Affects spawning and loot drop, I think.
                350,                            // Int: Render Index, the ship's sprite
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
                registerShipID(40),
                158,
                Color.WHITE,
                "Foundry",
                "Build an even bigger megastructure.",
                4,
                TypeTag.RARE,
                349,
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
                registerShipID(41),
                216,
                Color.PURPLE,
                "Foundry+",
                "Build an even bigger megastructure+.",
                5,
                TypeTag.EXOTIC,
                349,
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
        ModLogger.log("[ShipTest] Registered " + REGISTERED_SHIP_IDS.size() + " ships");
    }
}
