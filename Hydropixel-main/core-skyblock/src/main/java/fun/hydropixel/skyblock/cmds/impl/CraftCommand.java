package fun.hydropixel.skyblock.cmds.impl;

import fun.hydropixel.skyblock.crafting.gui.CraftingMenu;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import net.minestom.server.command.builder.Command;

public class CraftCommand extends Command {
    public CraftCommand() {
        super("craft", "workbench");

        setDefaultExecutor((sender, _) -> {
            if (!(sender instanceof SkyblockPlayer player)) return;
            CraftingMenu.open(player);
        });
    }
}
