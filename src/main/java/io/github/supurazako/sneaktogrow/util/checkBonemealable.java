package io.github.supurazako.sneaktogrow.util;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;

import java.util.Set;


public class checkBonemealable {


    private static final Set<Material> SNEAK_GROW_PLANTS = Set.of(
            // 作物
            Material.WHEAT,
            Material.CARROTS,
            Material.POTATOES,
            Material.BEETROOTS,
            Material.PUMPKIN_STEM,
            Material.MELON_STEM,
            // 苗木
            Material.OAK_SAPLING,
            Material.SPRUCE_SAPLING,
            Material.BIRCH_SAPLING,
            Material.JUNGLE_SAPLING,
            Material.ACACIA_SAPLING,
            Material.DARK_OAK_SAPLING,
            Material.AZALEA,
            Material.FLOWERING_AZALEA,
            Material.MANGROVE_PROPAGULE,
            // 花
            Material.SUNFLOWER,
            Material.LILAC,
            Material.ROSE_BUSH,
            Material.PEONY,
            // その他
            Material.SEAGRASS,

            Material.RED_MUSHROOM,
            Material.BROWN_MUSHROOM,

            Material.COCOA,

            Material.SEA_PICKLE,
            Material.CRIMSON_FUNGUS,
            Material.WARPED_FUNGUS,

            Material.WEEPING_VINES,
            Material.WEEPING_VINES_PLANT,
            Material.TWISTING_VINES,
            Material.TWISTING_VINES_PLANT,
            Material.CAVE_VINES,
            Material.CAVE_VINES_PLANT,

            
            Material.BAMBOO,
            Material.BAMBOO_SAPLING,
            Material.SWEET_BERRY_BUSH,
            Material.KELP,
            Material.KELP_PLANT
    );


    public static boolean isBonemealable(Block block) {
        Material material = block.getType();
        if(isFullyGrown(block)) {
            return false;
        }
        return material.isBlock() && SNEAK_GROW_PLANTS.contains(material);
    }


    public static boolean isFullyGrown(Block block) {
        if(block.getBlockData() instanceof Ageable) {
            Ageable ageable = (Ageable) block.getBlockData();
            return ageable.getAge() == ageable.getMaximumAge();
        }
        else {
            return false;
        }
    }
}
