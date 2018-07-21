package fr.skdrille.kitpvp.menu;

import fr.skdrille.kitpvp.User;
import fr.skdrille.kitpvp.item.ItemProvider;
import fr.skdrille.kitpvp.item.MenuOption;
import fr.skdrille.kitpvp.kit.Kits;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public final class KitSelector extends Menu {

    public KitSelector(Player player) {
        super(player, Menu.DEFAULT_PLAYER_COLOR + player.getName() + ChatColor.BLUE + " >> Available kits :", 9);
    }

    @Override
    public Map<Integer, MenuOption> getOptions() {
        Map<Integer, MenuOption> options = new HashMap<>();

        User user = User.getFromUUID(getPlayer().getUniqueId());

        int slot = 1;

        for(Kits kit : user.getAvailableKits()) {

            switch (kit) {
                /*
                Knight
                 */
                case KNIGHT:
                    options.put(slot++, new MenuOption() {
                        @Override
                        public ItemStack getIcon() {
                            Kits.getOptionKitMap().put(this, Kits.KNIGHT);
                            return ItemProvider.buildItemStack(Material.IRON_CHESTPLATE, ChatColor.AQUA + "Knight Kit", Kits.KNIGHT.getDescription());
                        }
                    });
                    break;
                /*
                Archer
                 */
                case ARCHER:
                    options.put(slot++, new MenuOption() {
                        @Override
                        public ItemStack getIcon() {
                            Kits.getOptionKitMap().put(this, Kits.ARCHER);
                            return ItemProvider.buildItemStack(Material.BOW, ChatColor.YELLOW + "Archer Kit", Kits.ARCHER.getDescription());
                        }
                    });
                    break;
            };
        };

        return options;
    }
}
