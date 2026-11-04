package fun.hydropixel.skyblock.cmds.impl;

import fun.hydropixel.common.redis.RedisManager;
import fun.hydropixel.common.redis.ServerLookup;
import fun.hydropixel.common.util.ProxyTransfer;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.player.profiles.ProfileManager;
import fun.hydropixel.skyblock.world.WorldHandler;
import net.minestom.server.command.builder.Command;
import net.minestom.server.entity.GameMode;

import static fun.hydropixel.common.StringUtility.text;

public class HubCommand extends Command {

    public HubCommand() {
        super("hub");

        setDefaultExecutor((sender, _) -> {
            if (!(sender instanceof SkyblockPlayer player)) return;
            
            String serverType = System.getenv().getOrDefault("HYDROPIXEL_SERVER_TYPE", "HUB");
            if (serverType.equalsIgnoreCase("ISLAND")) {
                String targetServer = ServerLookup.findAnyByPrefix("skyblock");
                if (targetServer == null) {
                    player.sendMessage(text("<red>SkyBlock Hub is currently offline!"));
                    return;
                }
                if (player.getActiveProfile() != null) {
                    ProfileManager.saveProfile(player.getActiveProfile().profileID);
                }
                if (RedisManager.isInitialized()) {
                    RedisManager.get().setTransferTarget(player.getUuid().toString(), "hub");
                }
                ProxyTransfer.send(player, targetServer);
                return;
            }

            if (WorldHandler.getLobby() == null) {
                player.sendMessage(text("<red>SkyBlock Hub is currently unavailable!"));
                return;
            }
            
            player.sendMessage(text("<green>Teleporting to SkyBlock Hub..."));
            player.setInstance(WorldHandler.getLobby(), WorldHandler.getLobbySpawn());
            player.setGameMode(GameMode.SURVIVAL);
        });
    }
}
