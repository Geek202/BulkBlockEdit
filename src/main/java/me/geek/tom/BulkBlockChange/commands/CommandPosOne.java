package me.geek.tom.BulkBlockChange.commands;

import me.geek.tom.BulkBlockChange.BulkBlockChange;
import me.geek.tom.BulkBlockChange.selection.RectSelection;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPosOne implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command must be run as a player.");
            return true;
        }

        Player player = (Player) sender;

        if (!(BulkBlockChange.plugin.getSelectionManager().getSelectionByPlayer(player) instanceof RectSelection)) {
            BulkBlockChange.plugin.getSelectionManager().resetPlayerSelection(player);
        }

        RectSelection selection = (RectSelection) BulkBlockChange.plugin.getSelectionManager().getSelectionByPlayer(player);
        selection.setPos1(player.getLocation());

        player.sendMessage(ChatColor.LIGHT_PURPLE + "Set pos1");

        return true;
    }
}
