package offlcersam.shiptest.mixin;

import crafting.CraftingTable;
import crafting.CraftingTableNormal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static offlcersam.shiptest.MarketRegistrar.ARROWHEAD_ITEM_ID;

@Mixin(value = CraftingTableNormal.class, remap = false)
public abstract class CraftingRegistrarMixin extends CraftingTable {

    @Inject(
            method = "init",
            at = @At("TAIL")
    )
    private void shiptest$registerArrowheadRecipe(CallbackInfo ci) {

        int arrowheadItemId = ARROWHEAD_ITEM_ID;
        int bpShipT0_1 = 20107;
        int yachtItemId = 100001;
        int AgNode      = 10702;
        int FeMatx      = 10711;

        // Yacht comparison: 1 Yacht frame, 6 Silver Nodes, 8 Iron Matrices
        this.addRecipe(
                "Arrowhead Strike Craft",
                arrowheadItemId,
                bpShipT0_1, 1,    // Requires 1 T0 blueprint wrapper
                yachtItemId, 1,   // Requires trading in 1 standard base Yacht
                AgNode, 6,        // Material component 1 and quantity
                FeMatx, 8         // Material component 2 and quantity
        );

        System.out.println("[Shiptest] Arrowhead recipe added.");
    }
}
