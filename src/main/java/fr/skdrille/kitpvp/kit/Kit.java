package fr.skdrille.kitpvp.kit;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public interface Kit {

    /**
     * Get the kit's armor contents.
     * @return an array of ItemStack
     */
    ItemStack[] getArmorContents();

    /**
     * Get the kit's contents (no armor).
     * @return an array of ItemStack
     */
    ItemStack[] getContents();

}
