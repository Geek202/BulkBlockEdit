package me.geek.tom.BulkBlockChange.selection;

import com.google.common.collect.Lists;
import org.bukkit.Chunk;
import org.bukkit.Location;

import java.util.List;

public class RectSelection extends Selection {

    public Location getPos1() {
        return pos1;
    }

    public Location getPos2() {
        return pos2;
    }

    public void setPos1(Location pos1) {
        this.pos1 = pos1;
    }

    public void setPos2(Location pos2) {
        this.pos2 = pos2;
    }

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

        if (pos1.equals(null) || pos2.equals(null)) {
            return null;
        }

        Chunk pos1c = pos1.getChunk();
        if (pos2.getChunk().equals(pos1c)) {
            List<Chunk> tmp = Lists.newArrayList();
            tmp.add(pos1c);
            return tmp;
        }
        List<Chunk> result = Lists.newArrayList();
        Chunk pos2c = pos2.getChunk();

        for (int x = Math.min(pos1c.getX(), pos2c.getX()); x <= Math.max(pos1c.getX(), pos2c.getX()); x++) {
            for (int z = Math.min(pos1c.getZ(), pos2c.getZ()); z <= Math.max(pos1c.getZ(), pos2c.getZ()); z++) {
                result.add(pos1c.getWorld().getChunkAt(x, z));
            }
        }

        return result;
    }

    public boolean isBlockInSelection(int x, int y, int z) {
        if (x <= Math.max(pos1.getBlockX(), pos2.getBlockX()) && x >= Math.min(pos1.getBlockX(), pos2.getBlockX())) {
            if (y <= Math.max(pos1.getBlockY(), pos2.getBlockY()) && y >= Math.min(pos1.getBlockY(), pos2.getBlockY())) {
                if (z <= Math.max(pos1.getBlockZ(), pos2.getBlockZ()) && z >= Math.min(pos1.getBlockZ(), pos2.getBlockZ())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validSelection() {
        if (pos1.equals(null) || pos2.equals(null)) {
            return false;
        }
        return true;
    }

}
