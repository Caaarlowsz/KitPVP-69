package fr.skdrille.kitpvp.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemProvider {

    public static ItemStack buildItemStack(Material material, String displayName, int amount, List<String> lore) {
        ItemStack item = new ItemStack(material);
        item.setAmount(amount);

        ItemMeta meta = item.getItemMeta();

        if(displayName != null && !displayName.equals("")) {
            meta.setDisplayName(displayName);
        }

        if(lore != null && !lore.isEmpty()) {
            meta.setLore(lore);
        }

        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack buildItemStack(Material material, String displayName, List<String> lore) {
        return buildItemStack(material, displayName, 1, lore);
    }

}
