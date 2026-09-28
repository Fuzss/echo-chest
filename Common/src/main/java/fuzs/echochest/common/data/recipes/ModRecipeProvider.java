package fuzs.echochest.common.data.recipes;

import fuzs.echochest.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.data.v3.recipes.AbstractRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Blocks;

public class ModRecipeProvider extends AbstractRecipeProvider {

    public ModRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }

    @Override
    public void buildRecipes() {
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.DECORATIONS, ModRegistry.ECHO_CHEST_BLOCK.value())
                .define('#', Blocks.DEEPSLATE)
                .define('+', Blocks.DEEPSLATE_BRICKS)
                .define('@', Items.ECHO_SHARD)
                .pattern("#+#")
                .pattern("+@+")
                .pattern("#+#")
                .unlockedBy(getHasName(Items.ECHO_SHARD), this.has(Items.ECHO_SHARD))
                .save(this.output);
    }
}
