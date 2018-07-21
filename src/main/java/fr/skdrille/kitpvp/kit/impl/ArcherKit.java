package fr.skdrille.kitpvp.kit.impl;

import fr.skdrille.kitpvp.item.ItemProvider;
import fr.skdrille.kitpvp.kit.Kit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public final class ArcherKit implements Kit {

    @Override
    public ItemStack[] getArmorContents() {
        ItemStack[] armorContents = new ItemStack[] {
                ItemProvider.buildItemStack(Material.DIAMOND_HELMET, "Archer Helmet", null),
                ItemProvider.buildItemStack(Material.IRON_CHESTPLATE, "Archer ChestPlate", null),
                ItemProvider.buildItemStack(Material.IRON_LEGGINGS, "Archer Leggings", null),
                ItemProvider.buildItemStack(Material.DIAMOND_BOOTS, "Archer Boots", null)

        };
        return armorContents;
    }

    @Override
    public ItemStack[] getContents() {
        ItemStack[] contents = new ItemStack[] {
                ItemProvider.buildItemStack(Material.IRON_SWORD, "Archer Sword", null),
                ItemProvider.buildItemStack(Material.BOW, "Archer Bow", null),
                ItemProvider.buildItemStack(Material.ARROW, null, 64,null),
                ItemProvider.buildItemStack(Material.GOLDEN_APPLE, null, 2, null)

        };
        return contents;
    }
}
