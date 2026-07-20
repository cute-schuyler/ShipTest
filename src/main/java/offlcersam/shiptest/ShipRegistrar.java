package garmillas;

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

        //ShipList.write(
        //        registerShipID(350),
        //        30,                         Int: Icon, sets Icon according to sprite sheet.
        //        Color.AZURE,                     Color: Color, unsure what exactly this affects.
        //        "Arrowhead",                     String: Display name
        //        "Maybe one day you could be a real arrow.",  String: Display description
        //        0,                               Int: Tier, affects spawning and what level it's usable at.
        //        TypeTag.UNCOMMON,               TypeTag, Affects spawning and loot drop, I think.
        //        350,                             Int: Render Index, the ship's sprite
        //        37,                              Int: Engine Position glow in pixels
        //        integ * 1.50F,                   Float: Hull HP (integ * multiplier), somewhat based off ShipList style of doing it.
        //        carg * 1.10F,                    Float: Cargo (carg * multiplier), also based off ShipList style of doing it.
        //        WeaponSlotLayoutList.S_2_V,      WeaponSlotLayoutList: Weapon Layout, see WeaponSlotLayoutList for full list.
        //        2,                               Int: Energy slots, unsure what the UI limit for slots are but base game doesn't go above 8 currently.
        //        1,                               Int: Armor slots
        //        1,                               Int: Shield slots
        //        0,                              Int: Device slots
        //        1,                              Int: Module slots
        //        1                                Int: Engine slots
        //);

        ShipList.write(registerShipID(550),158,Color.WHITE,"Caterpillar","Heavily Armored Transport.",2,TypeTag.UNCOMMON,850,190,200.0F,100.0F,WeaponSlotLayoutList.S_1_V,4,6,2,1,3,2);

        ShipList.write(registerShipID(551),158,Color.WHITE,"Container","For your long range transport needs.",2,TypeTag.UNCOMMON,851,218,150.0F,180.0F, WeaponSlotLayoutList.S_2_V, 6, 2, 2, 1, 3, 5 );

        ShipList.write( registerShipID(552),158,Color.WHITE,"Carrier HE","Heavily Armored Transport+.",4,TypeTag.RARE,852,480,240.0F,200.0F,WeaponSlotLayoutList.S_5_V,6,8,3,2,3,4);
        
        ShipList.write(registerShipID(553),216,Color.WHITE,"Delameya","Assault Gunship.",4,TypeTag.RARE,853,340,180.0F,50.0F,WeaponSlotLayoutList.S_6_V,5,4,4,4,4,2);

        ShipList.write(registerShipID(554),30,Color.WHITE,"Gemini","Twin Destroyer.",1,TypeTag.COMMON,854,54,160.0F,50.0F,WeaponSlotLayoutList.S_4_V,3,2,2,2,2,2);

        ShipList.write(registerShipID(555),216,Color.WHITE,"Barrier","A rarely seen Minelayer.",5,TypeTag.EXOTIC,855,310,300.0F,300.0F,WeaponSlotLayoutList.S_4_V,7,3,3,6,6,4);
        
        ShipList.write(registerShipID(556),30,Color.WHITE,"Xport","Light Military Hauler.",1,TypeTag.COMMON,856,340,160.0F,160.0F,WeaponSlotLayoutList.S_3_V,2,2,2,0,2,2);
        
        ShipList.write(registerShipID(557),158,Color.WHITE,"Dominator","Common Empire Destroyer.",1,TypeTag.COMMON,857,424,200.0F,75.0F,WeaponSlotLayoutList.S_3_V,3,2,2,1,1,3);

        ShipList.write(registerShipID(558),158,Color.WHITE,"Exterminator","Heavy Empire Destroyer.",2,TypeTag.UNCOMMON,858,395,240.0F,75.0F,WeaponSlotLayoutList.S_5_V,4,3,3,2,2,4);



        


        ShipList.loadShipStatsFromItems(_database.ItemDatabase.itemDataFile);
        ModLogger.log("[ShipTest] Registered " + REGISTERED_SHIP_IDS.size() + " ships");
    }
}
