package io.github.supurazako.sneaktogrow.util;

import org.bukkit.CropState;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.material.Crops;
import org.bukkit.block.Block;

import java.util.Set;


public class checkBonemealable {


    private static final Set<Material> SNEAK_GROW_PLANTS = Set.of(
            Material.WHEAT,
            Material.CARROT,
            Material.POTATOES,
            Material.BEETROOTS,

            Material.OAK_SAPLING,
            Material.SPRUCE_SAPLING,
            Material.BIRCH_SAPLING,
            Material.JUNGLE_SAPLING,
            Material.ACACIA_SAPLING,
            Material.DARK_OAK_SAPLING,
            Material.AZALEA,
            
            Material.BAMBOO,
            Material.MELON_STEM,
            Material.PUMPKIN_STEM,
            Material.SWEET_BERRY_BUSH,
            Material.KELP
    );

    public boolean isBonemealable(Material material) {
        return material.isBlock() && SNEAK_GROW_PLANTS.contains(material);
    }
}
