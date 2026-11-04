package fun.hydropixel.skyblock.cmds.impl;

import fun.hydropixel.skyblock.hotm.HotmTree;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import net.minestom.server.command.builder.Command;
import net.minestom.server.entity.Player;

public class HotmCommand extends Command {

    public HotmCommand() {
        super("hotm", "heartofthemountain");
        setDefaultExecutor((sender, context) -> {
            if (!(sender instanceof Player player)) return;
            HotmTree.of((SkyblockPlayer) player).openMenu(0);
        });
    }
}
