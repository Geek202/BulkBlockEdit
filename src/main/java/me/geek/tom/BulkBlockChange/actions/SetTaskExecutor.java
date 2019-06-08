package me.geek.tom.BulkBlockChange.actions;

import me.geek.tom.BulkBlockChange.selection.Selection;
import org.bukkit.Material;

public class SetTaskExecutor extends TaskExecutor {

    private Selection selection;
    private Material blockType;

    public SetTaskExecutor(Selection selection, Material blockType) {
        this.selection = selection;
        this.blockType = blockType;
    }

    @Override
    public void runOneAction() {

    }

}
