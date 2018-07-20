package fr.skdrille.kitpvp.kit;

import fr.skdrille.kitpvp.item.MenuOption;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Kits {
    KNIGHT("Knight", KnightKit.class, Arrays.asList("----------------------",
                                          " - x1 Diamond Helmet",
                                          " - x1 Iron ChestPlate",
                                          " - x1 Iron Leggings",
                                          " - x1 Diamond Boots",
                                          " - x1 Iron Sword",
                                          " - x1 Bow",
                                          " - x64 Arrows",
                                          " - x2 Golden Apple",
                                          "----------------------")),
    ARCHER("Archer", ArcherKit.class, Arrays.asList("----------------------",
                                          " - x1 Diamond Helmet",
                                          " - x1 Iron ChestPlate",
                                          " - x1 Iron Leggings",
                                          " - x1 Diamond Boots",
                                          " - x1 Iron Sword",
                                          " - x1 Bow",
                                          " - x64 Arrows",
                                          " - x2 Golden Apple",
                                          "----------------------"));

    private static Map<MenuOption, Kits> optionKitMap = new HashMap<>();

    private String name;
    private Class<? extends Kit> kitClass;
    private List<String> description;

    Kits(String name, Class<? extends Kit> kitClass, List<String> description) {
        this.name = name;
        this.kitClass = kitClass;
        this.description = description;
    }

    public void giveToPlayer(Player player) {
        if(kitClass != null && player != null) {
            try {
                Kit kit = kitClass.newInstance();

                player.getInventory().clear();
                player.getInventory().setArmorContents(kit.getArmorContents());
                player.getInventory().setContents(kit.getContents());

                player.sendMessage(ChatColor.GREEN + "You selected the " + ChatColor.GOLD + getName() + ChatColor.GREEN + " kit");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getDescription() {
        return description;
    }

    public static Map<MenuOption, Kits> getOptionKitMap() {
        return optionKitMap;
    }

    public static Kits getKitFromOption(MenuOption option) {
        return getOptionKitMap().get(option);
    }

}
