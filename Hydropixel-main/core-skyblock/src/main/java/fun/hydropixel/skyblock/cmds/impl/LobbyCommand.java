package fun.hydropixel.skyblock.cmds.impl;

import fun.hydropixel.common.redis.ServerLookup;
import fun.hydropixel.common.util.ProxyTransfer;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.player.profiles.ProfileManager;
import net.minestom.server.command.builder.Command;

import static fun.hydropixel.common.StringUtility.text;

public class LobbyCommand extends Command {

    public LobbyCommand() {
        super("lobby", "l");

        setDefaultExecutor((sender, _) -> {
            if (!(sender instanceof SkyblockPlayer player)) return;
            
            String targetServer = ServerLookup.findAnyByPrefix("lobby");
            if (targetServer == null) {
                player.sendMessage(text("<red>The Main Lobby is currently unavailable!"));
                return;
            }
            
            player.sendMessage(text("<green>Sending you to the Main Lobby..."));
            if (player.getActiveProfile() != null) {
                ProfileManager.saveProfile(player.getActiveProfile().profileID);
            }
            ProxyTransfer.send(player, targetServer);
        });
    }
}
