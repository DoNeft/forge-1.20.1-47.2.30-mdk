package net.doneft.endextensionmod.datagen;

import net.doneft.endextensionmod.EndExtensionMod;
import net.doneft.endextensionmod.block.ModBlocks;
import net.doneft.endextensionmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    //ALL BLOCK TO SMELT THIS ITEM
    private static final List<ItemLike> IREND_SMELTABLE = List.of(ModItems.RAWIREND.get(),
            ModBlocks.IRENDREMAINS.get(), ModBlocks.DEEPSLATE_IRENDREMAINS.get());


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while (var9.hasNext()) {
            ItemLike itemlike = (ItemLike) var9.next();
            SimpleCookingRecipeBuilder
                    .generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, EndExtensionMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, IREND_SMELTABLE, RecipeCategory.MISC, ModItems.IRENDINGOT.get(), 0.25f, 200, "sapphire");
        oreBlasting(consumer, IREND_SMELTABLE, RecipeCategory.MISC, ModItems.IRENDINGOT.get(), 0.25f, 100, "sapphire");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRENDBLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.IRENDINGOT.get())
                .unlockedBy(getHasName(ModItems.IRENDINGOT.get()), has(ModItems.IRENDINGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_IRENDBLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RAWIREND.get())
                .unlockedBy(getHasName(ModItems.RAWIREND.get()), has(ModItems.RAWIREND.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.IRENDINGOT.get(), 9)
                .requires(ModBlocks.IRENDBLOCK.get())
                .unlockedBy(getHasName(ModBlocks.IRENDBLOCK.get()), has(ModBlocks.IRENDBLOCK.get()))
                .save(consumer);


    }
}
