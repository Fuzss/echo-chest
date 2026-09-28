package fuzs.echochest.neoforge;

import fuzs.echochest.common.EchoChest;
import fuzs.echochest.common.data.loot.ModBlockLootProvider;
import fuzs.echochest.common.data.recipes.ModRecipeProvider;
import fuzs.echochest.common.data.tags.ModBlockTagsProvider;
import fuzs.echochest.common.data.tags.ModGameEventTagsProvider;
import fuzs.echochest.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v3.core.DataProviderBuilder;
import fuzs.puzzleslib.neoforge.api.init.v3.capability.NeoForgeCapabilityHelper;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.fml.common.Mod;

@Mod(EchoChest.MOD_ID)
public class EchoChestNeoForge {

    public EchoChestNeoForge() {
        ModConstructor.construct(EchoChest.MOD_ID, EchoChest::new);
        NeoForgeCapabilityHelper.registerWorldlyBlockEntityContainer(ModRegistry.ECHO_CHEST_BLOCK_ENTITY_TYPE);
        DataProviderBuilder.of(EchoChest.MOD_ID)
                .addProvider(ModBlockTagsProvider::new, ModGameEventTagsProvider::new)
                .addLootProvider(ModBlockLootProvider::new, LootContextParamSets.BLOCK)
                .addRecipeProvider(ModRecipeProvider::new);
    }
}
