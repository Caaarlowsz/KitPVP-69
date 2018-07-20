package fr.skdrille.kitpvp;

import fr.skdrille.kitpvp.item.MenuOption;
import fr.skdrille.kitpvp.kit.Kits;
import fr.skdrille.kitpvp.menu.KitSelectorMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class KitPVP extends JavaPlugin implements Listener {

    private static KitPVP instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(player.getOpenInventory() != null) {
                player.getOpenInventory().close();
            }
        }
    }

    public static KitPVP getInstance() {
        return instance;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        player.getInventory().clear();
        player.getInventory().setItem(0, new ItemStack(Material.BLAZE_ROD));
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerInterack(PlayerInteractEvent event) {
        final Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getItemInHand() != null && player.getItemInHand().getType().equals(Material.BLAZE_ROD)) {
                new KitSelectorMenu(player).open();
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerChooseKit(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            final Player player = (Player) event.getWhoClicked();

            if (event.getClickedInventory().getHolder() instanceof KitSelectorMenu) {
                KitSelectorMenu menu = (KitSelectorMenu) event.getClickedInventory().getHolder();
                event.setCancelled(true);

                if (event.getCurrentItem() != null) {
                    /*
                    Parcourt les options du menu et récupère le kit associé à l'option cliquée.
                    */
                    for (MenuOption option : menu.getOptions().values()) {
                        if (option.getIcon().isSimilar(event.getCurrentItem())) {
                            Kits.getKitFromOption(option).giveToPlayer(player);
                        }
                    }
                }
            }
        }
    }

}
