package fuzs.echochest.neoforge;

import fuzs.echochest.common.EchoChest;
import fuzs.echochest.common.data.ModBlockLootProvider;
import fuzs.echochest.common.data.ModRecipeProvider;
import fuzs.echochest.common.data.tags.ModBlockTagsProvider;
import fuzs.echochest.common.data.tags.ModGameEventTagsProvider;
import fuzs.echochest.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import fuzs.puzzleslib.neoforge.api.init.v3.capability.NeoForgeCapabilityHelper;
import net.neoforged.fml.common.Mod;

@Mod(EchoChest.MOD_ID)
public class EchoChestNeoForge {

    public EchoChestNeoForge() {
        ModConstructor.construct(EchoChest.MOD_ID, EchoChest::new);
        NeoForgeCapabilityHelper.registerWorldlyBlockEntityContainer(ModRegistry.ECHO_CHEST_BLOCK_ENTITY_TYPE);
        DataProviderHelper.registerDataProviders(EchoChest.MOD_ID,
                ModBlockLootProvider::new,
                ModBlockTagsProvider::new,
                ModGameEventTagsProvider::new,
                ModRecipeProvider::new);
    }
}
