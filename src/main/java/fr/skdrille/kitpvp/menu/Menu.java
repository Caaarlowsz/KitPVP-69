package fr.skdrille.kitpvp.menu;

import fr.skdrille.kitpvp.item.MenuOption;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.Map;

public abstract class Menu implements InventoryHolder {

    protected static final ChatColor DEFAULT_PLAYER_COLOR = ChatColor.DARK_PURPLE;

    private Player player;
    private final String name;
    private final int size;
    private Inventory inv;

    protected Menu(Player player, String name, int size) {
        this.player = player;
        this.name = name;
        this.size = size;
    }

    protected Player getPlayer() {
        return player;
    }

    protected String getName() {
        return name;
    }

    protected int getSize() {
        return size;
    }

    /**
     * Get all the menu options.
     * @return a Map with the menu options associated to their slot in inventory
     */
    public abstract Map<Integer, MenuOption> getOptions();

    /**
     * Get the final menu inventory.
     * @return the menu inventory
     */
    @Override
    public Inventory getInventory() {
        if(inv == null) {
            inv = Bukkit.createInventory(this, size, name);

            //Place les options dans l'inventaire
            for(Map.Entry<Integer, MenuOption> entry : getOptions().entrySet()) {
                inv.setItem(entry.getKey() - 1, entry.getValue().getIcon());
            }
        }
        return inv;
    }

    /**
     * Open the menu to the specified player.
     */
    public void open() {
        if(player.getOpenInventory() != null) {
            player.getOpenInventory().close();
        }
        player.openInventory(getInventory());
    }

}
