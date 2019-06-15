package me.geek.tom.BulkBlockChange.actions;

import me.geek.tom.BulkBlockChange.BulkBlockChange;
import me.geek.tom.BulkBlockChange.selection.Selection;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.List;

public class SetTaskExecutor extends TaskExecutor {

    private Selection selection;
    private Material blockType;

    public SetTaskExecutor(Selection selection, Material blockType) {
        this.selection = selection;
        this.blockType = blockType;
    }

    @Override
    public void runOneAction() {
        List<Chunk> chunks = selection.getChunks();

        for (Chunk chunk : chunks) {

            boolean unload = false;

            if (!chunk.isLoaded()) {
                chunk.load(true);
                unload = true;
            }

            for (int y = 0; y < 256; y++) {

                for (int x = 0; x < 16; x++) {

                    for (int z = 0; z < 16; z++) {

                        Location pos = new Location(chunk.getWorld(), (chunk.getX() * 16) + x, y, (chunk.getZ() * 16) + z);

                        Block block = chunk.getBlock(pos.getBlockX(), pos.getBlockY(), pos.getBlockZ());

                        if (selection.isBlockInSelection(pos.getBlockX(), pos.getBlockY(), pos.getBlockZ())) {
                            block.setType(blockType, false);
                        }

                    }

                }

            }
            if (unload) {
                chunk.unload(true);
            }
        }
    }

}
