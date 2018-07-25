package fr.skdrille.kitpvp.item;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagList;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
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

    //TODO: Faire fonctionner le glow effect
    public static ItemStack buildGlowingItemStack(Material material, String displayName, List<String> lore) {
        ItemStack item = buildItemStack(material, displayName, lore);
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);

        NBTTagCompound tag = nmsItem.getTag() == null ? new NBTTagCompound() : nmsItem.getTag();
        tag.set("ench", new NBTTagList());
        nmsItem.setTag(tag);

        return CraftItemStack.asBukkitCopy(nmsItem);
    }
}
