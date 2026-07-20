package garmillas.mixin;

import crafting.CraftingTable;
import crafting.CraftingTableNormal;
import mods.ModLogger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CraftingTableNormal.class, remap = false)
public abstract class CraftingRegistrarMixin extends CraftingTable {

    @Inject(
            method = "init",
            at = @At("TAIL")
    )
    private void shiptest$registerShipRecipe(CallbackInfo ci) {

        // Readability, ShipIDs are essentially BaseID + 10000
        int CATERPILLAR_GE = 100550;
        int CONTAINER_GE = 100551;
        int CARRIERHE_GE = 100552;
        int DELAMEYA_GE = 100553;
        int GEMINI_GE = 100554;
        int BARRIER_GE = 100555;
        int XPORT_GE = 100556;
        int DOMINATOR_GE = 100557;
        int EXTERMINATOR_GE = 100558;

        // Uses market IDs of ships (100000 + ID), these are here for readability.
        int skiffItemId = 100000;
        int yachtItemId = 100001;
        int fabricatorItemId = 100029;
        int fabricatorplusItemId = 100039;

        // List of materials from CraftingTableNormal
        int bpKineT0_1 = 20101, bpEMT0_1 = 20102, bpFldT0_1 = 20103, bpBulkT0_1 = 20104, bpContT0_1 = 20105, bpAmmoT0_1 = 20106, bpShipT0_1 = 20107, enrFLD = 10815, drkFLD = 10816;
        int bpKineT2 = 20111, bpEMT2 = 20112, bpFldT2 = 20113, bpBulkT2 = 20114, bpContT2 = 20115, bpAmmoT2 = 20116, bpShipT2 = 20117, enrGEM = 10079, drkGEM = 10067;
        int bpKineT3_4 = 20121, bpEMT3_4 = 20122, bpFldT3_4 = 20123, bpBulkT3_4 = 20124, bpContT3_4 = 20125, bpAmmoT3 = 20126, bpShipT3 = 20127, orgGEL = 10069;
        int bpKineT5_6 = 20131, bpEMT5_6 = 20132, bpFldT5_6 = 20133, bpBulkT5_6 = 20134, bpContT5_6 = 20135, bpAmmoT4_5 = 20136, bpShipT4_5 = 20137;
        int CuNode = 10701, AgNode = 10702, AuNode = 10703, PtNode = 10704, OsNode = 10705;
        int FeMatx = 10711, AlMatx = 10712, TiMatx = 10713, WgMatx = 10714, VaMatx = 10715;

        this.addRecipe(
                "T1:Gemini",
                GEMINI_GE,
                bpShipT0_1, 1,
                skiffItemId, 1,
                CuNode, 10,
                FeMatx, 10
        );

        this.addRecipe(
                "T0:Xport",
                XPORT_GE,
                bpShipT0_1, 1,
                skiffItemId, 1,
                CuNode, 5,
                FeMatx, 5
        );

        this.addRecipe(
                "T1:Dominator",
                DOMINATOR_GE,
                bpShipT0_1, 1,
                skiffItemId, 1,
                CuNode, 10,
                FeMatx, 10
        );

        this.addRecipe(
                "T1:Dominator+Alt1",
                DOMINATOR_GE,
                bpShipT0_1, 1,
                XPORT_GE, 1,
                CuNode, 5,
                FeMatx, 5
        );

        this.addRecipe(
                "T2:Exterminator",
                EXTERMINATOR_GE,
                bpShipT2, 1,
                DOMINATOR_GE, 1,
                AgNode, 20,
                AlMatx, 20
        );

        this.addRecipe(
                "T2:Exterminator+Alt1",
                EXTERMINATOR_GE,
                bpShipT2, 1,
                GEMINI_GE, 2,
                AgNode, 10,
                AlMatx, 10
        );

        this.addRecipe(
                "T2:Caterpillar",
                CATERPILLAR_GE,
                bpShipT2, 1,
                XPORT_GE, 1,
                AgNode, 20,
                AlMatx, 20
        );

        this.addRecipe(
                "T2:Container",
                CONTAINER_GE,
                bpShipT2, 1,
                XPORT_GE, 2,
                AgNode, 20,
                AlMatx, 20
        );

        this.addRecipe(
                "T4:Carrier HE",
                CARRIERHE_GE,
                bpShipT4_5, 1,
                CATERPILLAR_GE, 1,
                CONTAINER_GE, 1,
                AuNode, 20,
                TiMatx, 20
        );

        this.addRecipe(
                "T4:Delameya",
                DELAMEYA_GE,
                bpShipT4_5, 1,
                EXTERMINATOR_GE, 1,
                AuNode, 20,
                TiMatx, 20
        );

        this.addRecipe(
                "T5:Barrier",
                BARRIER_GE,
                bpShipT4_5, 1,
                EXTERMINATOR_GE, 1,
                CATERPILLAR_GE, 1,
                AuNode, 40,
                TiMatx, 40
        );









        ModLogger.log("[Gam] Ship recipes added.");
    }
}
