package me.geek.tom.BulkBlockChange.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSet implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((sender instanceof Player)) {

            if (args.length < 1) {
                return false;
            }

            Player player = (Player) sender;

            player.sendMessage(ChatColor.LIGHT_PURPLE + "Queued operation");
            return true;
        }
        return false;
    }
}
