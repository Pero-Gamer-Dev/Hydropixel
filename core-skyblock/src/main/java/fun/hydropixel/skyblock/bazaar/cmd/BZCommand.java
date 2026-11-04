package fun.hydropixel.skyblock.bazaar.cmd;

import fun.hydropixel.skyblock.bazaar.BazaarRegistry;
import fun.hydropixel.skyblock.bazaar.ui.BazaarCategoryMenu;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import net.minestom.server.command.builder.Command;

public class BZCommand extends Command {

    public BZCommand() {
        super("bz","bazaar");

        setDefaultExecutor(((sender, context) -> {
            if(!(sender instanceof SkyblockPlayer player)) return;
            BazaarCategoryMenu.openMenu(player, BazaarRegistry.bazaarItemList.getFarming());
        }));
    }
}
