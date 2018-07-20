package fr.skdrille.kitpvp.kit;

import fr.skdrille.kitpvp.item.ItemProvider;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class KnightKit implements Kit {

    @Override
    public ItemStack[] getArmorContents() {
        ItemStack[] armorContents = new ItemStack[] {
                ItemProvider.buildItemStack(Material.IRON_BOOTS, "Knight Boots", null ),
                ItemProvider.buildItemStack(Material.IRON_LEGGINGS, "Knight Leggings", null ),
                ItemProvider.buildItemStack(Material.IRON_CHESTPLATE, "Knight Chestplate", null ),
                ItemProvider.buildItemStack(Material.IRON_HELMET, "Knight Helmet", null ),

        };
        return armorContents;
    }

    @Override
    public ItemStack[] getContents() {
        ItemStack[] contents = new ItemStack[] {
                ItemProvider.buildItemStack(Material.DIAMOND_SWORD, "Knight Sword", null),
                ItemProvider.buildItemStack(Material.GOLDEN_APPLE, null, 5, null)
        };
        return contents;
    }

}
