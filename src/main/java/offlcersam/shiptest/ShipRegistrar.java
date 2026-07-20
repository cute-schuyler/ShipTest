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
    private static final List<Integer> REGISTERED_SHIP_IDS = new ArrayList<>();
    private ShipRegistrar() { }
    private static int registerShipID(int id) {
        REGISTERED_SHIP_IDS.add(id);
        ModLogger.log("[ShipTest] Added ship ID to registry: " + id);
        return id;
    }
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
     
//         ▄▀▀▀▀▄   ▄▀▀▀▀▄    ▄▀▀▀▀▄   ▄▀▀▄▀▀▀▄  ▄▀▀▄ ▀▀▄      ▄▀▀█▄▄   ▄▀▀█▄▄▄▄  ▄▀▀▀▀▄  ▄▀▀▀▀▄  ▄▀▀▀▀▄     ▄▀▀█▄▄▄▄  ▄▀▀▄▀▀▀▄ 
//        █        █    █    █      █ █   █   █ █   ▀▄ ▄▀     █ ▄▀   █ ▐  ▄▀   ▐ █ █   ▐ █ █   ▐ █    █     ▐  ▄▀   ▐ █   █   █ 
//        █    ▀▄▄ ▐    █    █      █ ▐  █▀▀█▀  ▐     █       ▐ █    █   █▄▄▄▄▄     ▀▄      ▀▄   ▐    █       █▄▄▄▄▄  ▐  █▀▀█▀  
//        █     █ █    █     ▀▄    ▄▀  ▄▀    █        █         █    █   █    ▌  ▀▄   █  ▀▄   █      █        █    ▌   ▄▀    █  
//        ▐▀▄▄▄▄▀ ▐  ▄▀▄▄▄▄▄▄▀ ▀▀▀▀   █     █       ▄▀         ▄▀▄▄▄▄▀  ▄▀▄▄▄▄    █▀▀▀    █▀▀▀     ▄▀▄▄▄▄▄▄▀ ▄▀▄▄▄▄   █     █   
//        ▐          █                ▐     ▐       █         █     ▐   █    ▐    ▐       ▐        █         █    ▐   ▐     ▐   
//                   ▐                              ▐         ▐         ▐                          ▐         ▐                                             
     
        ShipList.write(registerShipID(550),158,Color.WHITE,"Caterpillar","Heavily Armored Transport.",    //Id, Icon, Color, Name, Description
                       2,TypeTag.UNCOMMON,                                                                //Tier, Rarity
                       550,190,200.0F,100.0F,                                                             //Sprite, Engine Position, #HP, #Cargo
                       WeaponSlotLayoutList.S_1_V,4,6,2,1,3,2);                                           //Weapon Layout, #Energy, #Armor, #Shield, #Device, #Module, #Engine

        ShipList.write(registerShipID(551),158,Color.WHITE,"Container","For your long range transport needs.",
                       2,TypeTag.UNCOMMON,    
                       551,218,150.0F,180.0F,    
                       WeaponSlotLayoutList.S_2_V,6,2,2,1,3,5);

        ShipList.write( registerShipID(552),158,Color.WHITE,"Carrier HE","Heavily Armored Transport+.",
                       4,TypeTag.RARE,        
                       552,480,240.0F,200.0F,    
                       WeaponSlotLayoutList.S_5_V,6,8,3,2,3,4);
        
        ShipList.write(registerShipID(553),216,Color.WHITE,"Delameya","Assault Gunship.",
                       4,TypeTag.RARE,        
                       553,340,180.0F,50.0F,     
                       WeaponSlotLayoutList.S_6_V,5,4,4,4,4,2);

        ShipList.write(registerShipID(554),30,Color.WHITE,"Gemini","Twin Destroyer.",
                       1,TypeTag.COMMON,      
                       554,54,160.0F,50.0F,      
                       WeaponSlotLayoutList.S_4_V,3,2,2,2,2,2);

        ShipList.write(registerShipID(555),216,Color.WHITE,"Barrier","A rarely seen Minelayer.",
                       5,TypeTag.EXOTIC,
                       555,310,300.0F,300.0F,
                       WeaponSlotLayoutList.S_4_V,7,3,3,6,6,4);
        
        ShipList.write(registerShipID(556),30,Color.WHITE,"Xport","Light Military Hauler.",
                       0,TypeTag.COMMON,
                       556,340,160.0F,160.0F,
                       WeaponSlotLayoutList.S_3_V,2,2,2,0,2,2);
        
        ShipList.write(registerShipID(557),158,Color.WHITE,"Dominator","Common Empire Destroyer.",
                       1,TypeTag.COMMON,
                       557,424,200.0F,75.0F,
                       WeaponSlotLayoutList.S_3_V,3,2,2,1,1,3);

        ShipList.write(registerShipID(558),158,Color.WHITE,"Exterminator","Heavy Empire Destroyer.",
                       2,TypeTag.UNCOMMON,
                       558,395,240.0F,75.0F,
                       WeaponSlotLayoutList.S_5_V,4,3,3,2,2,4);

        ShipList.write(registerShipID(558),158,Color.WHITE,"Gaiderol","One of the mainline Battleships of the Empire.",
                       7,TypeTag.EXOTIC,
                       559,1130,1200.0F,300.0F,
                       WeaponSlotLayoutList.S_10_V,9,10,8,6,8,4);

        


        ShipList.loadShipStatsFromItems(_database.ItemDatabase.itemDataFile);
        ModLogger.log("[ShipTest] Registered " + REGISTERED_SHIP_IDS.size() + " ships");
    }
}
