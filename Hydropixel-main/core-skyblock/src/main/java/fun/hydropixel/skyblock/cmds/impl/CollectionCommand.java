package fun.hydropixel.skyblock.cmds.impl;

import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.player.collections.gui.CollectionOverviewMenu;
import net.minestom.server.command.builder.Command;

public class CollectionCommand extends Command {
    public CollectionCommand() {
        super("collection", "collections", "col");

        setDefaultExecutor((sender, _) -> {
            if (!(sender instanceof SkyblockPlayer player)) return;
            CollectionOverviewMenu.open(player);
        });
    }
}
