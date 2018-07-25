package fr.skdrille.kitpvp.menu;

import fr.skdrille.kitpvp.enums.RankTitle;
import fr.skdrille.kitpvp.item.ItemProvider;
import fr.skdrille.kitpvp.item.MenuOption;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class RankTitleSelector extends Menu {

    public RankTitleSelector(Player player) {
        super(player, Menu.DEFAULT_PLAYER_COLOR + player.getName() + " >> " + ChatColor.LIGHT_PURPLE + "Ranks titles", InventoryType.CHEST.getDefaultSize());
    }

    @Override
    public Map<Integer, MenuOption> getOptions() {
        Map<Integer, MenuOption> options = new HashMap<>();
        List<String> defaultLore = new ArrayList<String>() {
            {
                add(ChatColor.GRAY + "Show your skill to other players");
                add(ChatColor.GRAY + "by using a rank title.");
            }
        };

                    options.put(10, new MenuOption() {
                @Override
            public ItemStack getIcon() {
                return ItemProvider.buildItemStack(Material.BROWN_GLAZED_TERRACOTTA, RankTitle.WOOD.getTitle() + " Title", defaultLore);
            }
        });

        options.put(12, new MenuOption() {
            @Override
            public ItemStack getIcon() {
                return ItemProvider.buildItemStack(Material.GRAY_GLAZED_TERRACOTTA, RankTitle.SILVER.getTitle() + " Title", defaultLore);
            }
        });

        options.put(14, new MenuOption() {
            @Override
            public ItemStack getIcon() {
                return ItemProvider.buildGlowingItemStack(Material.YELLOW_GLAZED_TERRACOTTA, RankTitle.GOLD.getTitle() + " Title", defaultLore);
            }
        });

        options.put(16, new MenuOption() {
            @Override
            public ItemStack getIcon() {
                return ItemProvider.buildGlowingItemStack(Material.CYAN_GLAZED_TERRACOTTA, RankTitle.DIAMOND.getTitle() + " Title", defaultLore);
            }
        });

        options.put(18, new MenuOption() {
            @Override
            public ItemStack getIcon() {
                return ItemProvider.buildGlowingItemStack(Material.BLACK_GLAZED_TERRACOTTA, RankTitle.LEGEND.getTitle() + " Title", defaultLore);
            }
        });

        return options;
    }
}
