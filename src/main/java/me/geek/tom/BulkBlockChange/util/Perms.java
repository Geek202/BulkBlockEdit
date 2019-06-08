package me.geek.tom.BulkBlockChange.util;

import me.geek.tom.BulkBlockChange.BulkBlockChange;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Perms {

    private static Permission perms;

    private static boolean useBukkit = false;

    public static void load() {
        if (!setupPermissions()) {
            BulkBlockChange.plugin.obtainLogger().info("Vault not found, using Bukkit permissions instead");
            useBukkit = true;
        }
    }

    private static boolean setupPermissions() {
        if (BulkBlockChange.plugin.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Permission> rsp = BulkBlockChange.plugin.getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static boolean hasPerm(Player player, String perm) {
        if (useBukkit) {
            if (perm.equals("op")) {
                return player.isOp();
            }
            return player.hasPermission(perm);
        } else {
            return perms.has(player, perm);
        }
    }
}
