package me.geek.tom.BulkBlockChange.commands;

import me.geek.tom.BulkBlockChange.BulkBlockChange;
import me.geek.tom.BulkBlockChange.actions.SetTaskExecutor;
import me.geek.tom.BulkBlockChange.actions.TaskRunnable;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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

            if (!BulkBlockChange.plugin.getSelectionManager().getSelectionByPlayer(player).validSelection()) {
                player.sendMessage(ChatColor.RED + "Your selection is not valid!");
                return true;
            }

            TaskRunnable runnable;
            runnable = new TaskRunnable(new SetTaskExecutor(BulkBlockChange.plugin.getSelectionManager().getSelectionByPlayer(player), Material.matchMaterial(args[0])), BulkBlockChange.plugin.getManager());

            BulkBlockChange.plugin.getManager().queueOperation(runnable);

            player.sendMessage(ChatColor.LIGHT_PURPLE + "Queued operation");
            return true;
        }
        return false;
    }
}
