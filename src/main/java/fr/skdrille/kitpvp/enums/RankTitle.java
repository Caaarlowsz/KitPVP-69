package fr.skdrille.kitpvp.enums;

import org.bukkit.ChatColor;

public enum RankTitle {
    WOOD(ChatColor.GRAY + "✫ Wood"),
    SILVER(ChatColor.WHITE + "✫ Silver"),
    GOLD(ChatColor.GOLD + "✫ Gold"),
    DIAMOND(ChatColor.AQUA + "✫ Diamond"),
    LEGEND(ChatColor.RED + "✫ §lLegend");

    private String title;

    RankTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
