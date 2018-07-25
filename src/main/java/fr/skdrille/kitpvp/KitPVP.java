package fr.skdrille.kitpvp;

import fr.skdrille.kitpvp.item.MenuOption;
import fr.skdrille.kitpvp.enums.Kits;
import fr.skdrille.kitpvp.menu.KitSelector;
import fr.skdrille.kitpvp.menu.RankTitleSelector;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class KitPVP extends JavaPlugin implements Listener {

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
        player.getInventory().setItem(4, new ItemStack(Material.DIAMOND));

        User user = new User(player.getUniqueId());
        user.setAvailableKits(Kits.ARCHER, Kits.KNIGHT);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerInterack(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        final Action action = event.getAction();

        /*
        Check if the clicked item corresponds to a menu
         */
        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK) || action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)) {
            if (player.getItemInHand() != null) {

                switch(player.getItemInHand().getType()) {
                    //Kit selector menu
                    case BLAZE_ROD:
                        new KitSelector(player).open();
                        break;
                    //Ranks titles selector menu
                    case DIAMOND:
                        new RankTitleSelector(player).open();
                        break;
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerChooseKit(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            final Player player = (Player) event.getWhoClicked();

            if (event.getClickedInventory().getHolder() instanceof KitSelector) {
                KitSelector menu = (KitSelector) event.getClickedInventory().getHolder();
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

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        final User user = User.getFromUUID(event.getPlayer().getUniqueId());
        StringBuilder formated = new StringBuilder();

        if(user.getRankTitle() != null) {
            formated.append(user.getRankTitle().getTitle() + " ");
        }

        formated.append(ChatColor.RESET + "%1$s " + ChatColor.GRAY + ": %2$s");
        event.setFormat(formated.toString());
    }

}
