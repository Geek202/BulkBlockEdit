package me.geek.tom.BulkBlockChange.selection;

import org.bukkit.Chunk;
import org.bukkit.Location;

import java.util.List;

public abstract class Selection {
    public abstract List<Location> getBlockLocations();
    public abstract List<Chunk> getChunks();
    public abstract boolean isBlockInSelection(int x, int y, int z);
    public abstract boolean validSelection();
}
