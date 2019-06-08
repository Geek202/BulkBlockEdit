package me.geek.tom.BulkBlockChange.selection;

import com.google.common.collect.Lists;
import org.bukkit.Chunk;
import org.bukkit.Location;

import java.util.List;

public class RectSelection extends Selection {

    private Location pos1;
    private Location pos2;

    public RectSelection(Location pos1, Location pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    public List<Location> getBlockLocations() {

        int xdiff = Math.abs(pos1.getBlockX() - pos2.getBlockX());
        int ydiff = Math.abs(pos1.getBlockY() - pos2.getBlockY());
        int zdiff = Math.abs(pos1.getBlockZ() - pos2.getBlockZ());

        List<Location> result = Lists.newArrayList();

        for (int x = Math.min(pos1.getBlockX(), pos2.getBlockX()); x < Math.max(pos1.getBlockX(), pos2.getBlockX()); x++) {
            for (int y = Math.min(pos1.getBlockY(), pos2.getBlockY()); y < Math.max(pos1.getBlockY(), pos2.getBlockY()); y++) {
                for (int z = Math.min(pos1.getBlockZ(), pos2.getBlockZ()); z < Math.max(pos1.getBlockZ(), pos2.getBlockZ()); z++) {
                    result.add(new Location(pos1.getWorld(), x, y, z));
                }
            }
        }

        return result;
    }

    public List<Chunk> getChunks() {

        Chunk pos1c = pos1.getChunk();
        if (pos2.getChunk().equals(pos1c)) {
            return Lists.newArrayList(pos1c);
        }
        List<Chunk> result = Lists.newArrayList();
        for (int x = pos1.getBlockX(); x < pos2.getBlockX(); x += 16) {
            for (int z = pos2.getBlockZ(); z < pos2.getBlockZ(); z += 16) {
                result.add(new Location(pos1.getWorld(), x, 1, z).getChunk());
            }
        }
        return result;
    }
}
