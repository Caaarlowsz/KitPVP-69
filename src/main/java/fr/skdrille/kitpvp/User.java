package fr.skdrille.kitpvp;

import fr.skdrille.kitpvp.kit.Kits;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public final class User {

    private static Map<UUID, User> users = new HashMap<>();
    private UUID uuid;
    private Set<Kits> availableKits = new HashSet<>();

    public User(UUID uuid) {
        this.uuid = uuid;
        User.users.put(uuid, this);
    }

    public UUID getUUID() {
        return uuid;
    }

    public Player getBukkitPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    public Set<Kits> getAvailableKits() {
        return availableKits;
    }

    public void setAvailableKits(Kits... kits) {
        availableKits.addAll(Arrays.asList(kits));
    }

    public static User getFromUUID(UUID uuid) {
        return User.users.get(uuid);
    }
}
