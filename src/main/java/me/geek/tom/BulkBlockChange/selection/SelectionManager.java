package me.geek.tom.BulkBlockChange.selection;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectionManager implements Listener {

    private Map<Player,Selection> playerSelectionMap = new HashMap<Player, Selection>();

    public SelectionManager(List<Player> playerList) {
        for (Player player : playerList) {
            setPlayerSelection(player, new RectSelection(null, null));
        }
    }

    public Selection getSelectionByPlayer(Player player) {
        return playerSelectionMap.get(player);
    }

    private void setPlayerSelection(Player player, Selection selection) {
        playerSelectionMap.put(player, selection);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        setPlayerSelection(event.getPlayer(), new RectSelection(null, null));
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        playerSelectionMap.remove(event.getPlayer());
    }

    public void resetPlayerSelection(Player player) {
        setPlayerSelection(player, new RectSelection(null, null));
    }
}
