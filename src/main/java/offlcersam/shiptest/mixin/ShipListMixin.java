package garmillas.mixin;

import items.Stat;
import items.lists.ShipList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//"46 6F 72 65 76 65 72  50 72 61 69 73 65  4F 75 72  4C 69 67 68 74"

//79 117 114  104 111 109 101 44  110 111 98 108 101 44  109 105 103 104 116 121 44  115 116 114 111 110 103  97 110 100  116 114 117 101 44
//87 111 114 108 100  111 102  109 97 106 101 115 116 121 44  119 105 116 104  104 101 114  98 108 111 115 115 111 109 115  98 108 117 101 33
//83 105 110 103  119 105 116 104  106 111 121  97 110 100  111 118 101 114 99 111 109 101 33
//77 97 121  116 104 101  103 114 97 99 101  111 102  116 104 101  103 111 100 115  119 104 111  108 111 111 107  100 111 119 110  102 114 111 109  97 98 111 118 101
//69 118 101 114  109 97 114 99 104  116 111  111 117 114  100 114 117 109 33
//71 97 114 108 101  71 97 109 105 108 97 115 33
//71 108 111 114 121  98 101  119 105 116 104  117 115 46
//69 116 101 114 110 97 108  103 108 111 114 121 33

@Mixin(value = ShipList.class, remap = false)
    public class ShipListMixin {

        @Inject(method = "compile", at = @At("RETURN"))
        private static void shiptest$applyShipBonuses(boolean isPlatform, int shipIndex, CallbackInfo ci) {

                if (shipIndex == 550) {
                    Stat.ENERGY_REGEN.percentVal(50.0F);
                    Stat.ARMOR_INTEG.percentVal(50.0F);
                    Stat.ARMOR_REPAIR.flatVal(5.0F);
                    Stat.HULL_REPAIR.flatVal(5.0F);
                }
                if (shipIndex == 551) {
                    Stat.ENERGY_BANK.percentVal(50.0F);
                    Stat.ENERGY_REGEN.percentVal(50.0F);
                    Stat.HULL_INTEG.percentVal(50.0F);
                    Stat.HULL_REPAIR.flatVal(5.0F);
                }
                if (shipIndex == 552) {
                    Stat.ENERGY_REGEN.percentVal(65.0F);
                    Stat.ARMOR_INTEG.percentVal(65.0F);
                    Stat.ARMOR_REPAIR.flatVal(8.0F);
                    Stat.HULL_REPAIR.flatVal(8.0F);
                }
                if (shipIndex == 553) {
                    Stat.ENERGY_BANK.percentVal(80.0F);
                    Stat.ENERGY_REGEN.percentVal(80.0F);
                    Stat.WEAPON_ACCURACY.percentVal(20.0F);
                    Stat.WEAPON_DAMAGE.flatVal(20.0F);
                }
                if (shipIndex == 554) {
                    Stat.ENERGY_BANK.percentVal(25.0F);
                    Stat.ENERGY_REGEN.percentVal(25.0F);
                    Stat.WEAPON_ACCURACY.percentVal(5.0F);
                    Stat.WEAPON_DAMAGE.flatVal(5.0F);
                }
                if (shipIndex == 555) {
                    Stat.ENERGY_BANK.percentVal(100.0F);
                    Stat.ENERGY_REGEN.percentVal(100.0F);
                    Stat.PLATFORM_SLOT.flatVal(6.0F);
                    Stat.SHIELD_SOAK.flatVal(10.0F);
                    Stat.ARMOR_SOAK.flatVal(15.0F);
                }
                if (shipIndex == 556) {
                    Stat.ENERGY_REGEN.percentVal(25.0F);
                    Stat.ARMOR_INTEG.percentVal(25.0F);
                    Stat.ARMOR_REPAIR.flatVal(1.5F);
                    Stat.HULL_REPAIR.flatVal(1.5F);
                }
                if (shipIndex == 557) {
                    Stat.ENERGY_REGEN.percentVal(40.0F);
                    Stat.ARMOR_INTEG.percentVal(40.0F);
                    Stat.ARMOR_REPAIR.flatVal(3.0F);
                    Stat.HULL_REPAIR.flatVal(3.0F);
                    Stat.WEAPON_DAMAGE.flatVal(10.0F);
                }
                if (shipIndex == 558) {
                    Stat.ENERGY_REGEN.percentVal(55.0F);
                    Stat.ARMOR_INTEG.percentVal(55.0F);
                    Stat.ARMOR_REPAIR.flatVal(6.0F);
                    Stat.HULL_REPAIR.flatVal(6.0F);
                    Stat.WEAPON_DAMAGE.flatVal(15.0F);
                }
            
}}
