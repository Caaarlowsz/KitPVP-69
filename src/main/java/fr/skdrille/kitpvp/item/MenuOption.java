package fr.skdrille.kitpvp.item;

import org.bukkit.inventory.ItemStack;

@FunctionalInterface
public interface MenuOption {

    /**
     * Get the menu icon
     * @return the menu icon as an ItemStack
     */
    ItemStack getIcon();

}
