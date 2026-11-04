package fun.hydropixel.skyblock.cmds.impl;

import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.menus.BoosterCookieMenu;
import net.minestom.server.command.builder.Command;

public class BoosterCookieCommand extends Command {

    public BoosterCookieCommand() {
        super("boostercookie", "cookie", "cookies");

        setDefaultExecutor((sender, context) -> {
            if (!(sender instanceof SkyblockPlayer player)) {
                sender.sendMessage("This command can only be run by players.");
                return;
            }
            BoosterCookieMenu.open(player);
        });
    }
}
