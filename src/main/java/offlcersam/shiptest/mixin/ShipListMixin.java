package offlcersam.shiptest.mixin;

import items.Stat;
import items.lists.ShipList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ShipList.class, remap = false)
    public class ShipListMixin {

        @Inject(method = "compile", at = @At("RETURN"))
        private static void shiptest$applyShipBonuses(boolean isPlatform, int shipIndex, CallbackInfo ci) {

            // Mimic the giant case switch in ShipList that gives ship's bonuses
            // The Switch Case goes up to 800 currently, might be able to add more cases with this unsure.
            // Uses BaseID of ship

            if (shipIndex == 250) {
                Stat.ENERGY_REGEN.percentVal(50.0F);
                Stat.ARMOR_BANK.percentVal(140.0F);
                Stat.ARMOR_REGEN.percentVal(90.0F);
                Stat.PLATFORM_SLOT.flatVal(2.0F);
            }

            if (shipIndex == 251) {
                Stat.ENERGY_BANK.percentVal(200.0F);
                Stat.ENERGY_REGEN.percentVal(200.0F);
            }
            
            if (shipIndex == 252) {
                Stat.ENERGY_REGEN.percentVal(90.0F);
                Stat.ARMOR_BANK.percentVal(180.0F);
                Stat.ARMOR_REGEN.percentVal(130.0F);
                Stat.PLATFORM_SLOT.flatVal(5.0F);
            }
            
            if (shipIndex == 253) {
                Stat.ENERGY_BANK.percentVal(180.0F);
                Stat.ENERGY_REGEN.percentVal(100.0F);
                Stat.STATION_SLOT.flatVal(6.0F);
                Stat.PLATFORM_SLOT.flatVal(2.0F);
            }
        }
    }

