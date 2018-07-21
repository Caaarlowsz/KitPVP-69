package fr.skdrille.kitpvp.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public final class ItemProvider {

    /**
     * Build a modified ItemStack with specified parameters
     * @param material the ItemStack's material
     * @param displayName the ItemStack's displayname when player over it with cursor
     * @param amount the amount
     * @param lore the optional description
     * @return a modified ItemStack with parameters as properties
     */
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

    /**
     * Build a modified ItemStack with specified parameters ans 1 for amount.
     * @param material the ItemStack's material
     * @param displayName the ItemStack's displayname when player over it with cursor
     * @param lore the optional description
     * @return a modified ItemStack with parameters as properties
     */
    public static ItemStack buildItemStack(Material material, String displayName, List<String> lore) {
        return buildItemStack(material, displayName, 1, lore);
    }

}
