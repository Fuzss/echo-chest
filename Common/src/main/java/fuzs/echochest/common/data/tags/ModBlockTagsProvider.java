package fuzs.echochest.common.data.tags;

import fuzs.echochest.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.data.v3.core.DataProviderContext;
import fuzs.puzzleslib.common.api.data.v3.tags.AbstractTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

public class ModBlockTagsProvider extends AbstractTagsProvider<Block> {

    public ModBlockTagsProvider(DataProviderContext context) {
        super(Registries.BLOCK, context);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.GUARDED_BY_PIGLINS).add(ModRegistry.ECHO_CHEST_BLOCK);
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.ECHO_CHEST_BLOCK);
    }
}
