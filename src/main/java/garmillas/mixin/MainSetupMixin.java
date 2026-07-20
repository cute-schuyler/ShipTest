package garmillas.mixin;

import offlcersam.shiptest.MarketRegistrar;
import offlcersam.shiptest.ShipRegistrar;
import game.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Main.class, remap = false)
public class MainSetupMixin {

    @Inject(
            method = "setup",
            at = @At(
                    value = "INVOKE",
                    target = "L_database/ItemDatabase;loadDatabase()V",
                    shift = At.Shift.AFTER
            )
    )
    private void shiptest$registerShips(CallbackInfo ci) {
        ShipRegistrar.registerShips();
    }

    @Inject(
            method = "setup",
            at = @At(
                    value = "INVOKE",
                    target = "Lgame/markets/MarketDatabase;loadDatabase()V",
                    shift = At.Shift.AFTER
            )
    )
    private void shiptest$registerMarkets(CallbackInfo ci) {
        MarketRegistrar.registerMarkets();
    }
}
