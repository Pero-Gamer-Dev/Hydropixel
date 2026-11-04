package fun.hydropixel.skyblock.shop.command;

import fun.hydropixel.skyblock.shop.ShopMenu;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.command.builder.arguments.ArgumentWord;

public class ShopCommand extends Command {

    public ShopCommand() {
        super("shop");

        ArgumentWord shopID = ArgumentType.Word("shop");
        
        addSyntax((sender, args) -> {
            if(!(sender instanceof SkyblockPlayer pl)) return;
            String shop = args.get(shopID);
            ShopMenu.open(pl, shop);
        }, shopID);
    }
}
