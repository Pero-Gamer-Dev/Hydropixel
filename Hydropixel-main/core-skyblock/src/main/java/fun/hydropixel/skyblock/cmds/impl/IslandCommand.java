package fun.hydropixel.skyblock.cmds.impl;

import fun.hydropixel.common.redis.RedisManager;
import fun.hydropixel.common.redis.ServerLookup;
import fun.hydropixel.common.util.ProxyTransfer;
import fun.hydropixel.skyblock.island.Island;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.player.profiles.ProfileManager;
import fun.hydropixel.skyblock.player.profiles.SkyblockProfile;
import net.minestom.server.command.builder.Command;
import net.minestom.server.entity.GameMode;

public class IslandCommand extends Command {

    public IslandCommand() {
        super("island","is");
        setDefaultExecutor((sender,_) -> {
            if(!(sender instanceof SkyblockPlayer player)) return;
            SkyblockProfile profile = player.getActiveProfile();
            if(profile == null){
                player.sendMessage("§cYou don't have an active profile!");
                return;
            }

            String serverType = System.getenv().getOrDefault("HYDROPIXEL_SERVER_TYPE", "HUB");
            if (serverType.equalsIgnoreCase("HUB")) {
                String targetServer = ServerLookup.findAnyByPrefix("island");
                if (targetServer == null) {
                    player.sendMessage("§cIsland server is currently offline!");
                    return;
                }
                ProfileManager.saveProfile(profile.profileID);
                if (RedisManager.isInitialized()) {
                    RedisManager.get().setTransferTarget(player.getUuid().toString(), "island");
                }
                ProxyTransfer.send(player, targetServer);
                return;
            }

            Island island = profile.island;
            if (island == null) {
                player.sendMessage("§cIsland system error!");
                return;
            }

            if (island.isLoaded()) {
                if (player.getInstance() != island.getInstance()) {
                    player.setInstance(island.getInstance(), profile.getSpawnPos());
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("§aTeleporting to your island!");
                } else {
                    player.sendMessage("§aYou are already on your island!");
                }
            } else {
                player.sendMessage("§eYour island is loading, please wait...");
                island.load().thenAccept(instance -> {
                    if (instance != null) {
                        if (player.getInstance() != instance) {
                            player.setInstance(instance, profile.getSpawnPos());
                            player.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage("§aIsland loaded! Teleporting...");
                        } else {
                            player.sendMessage("§aIsland loaded!");
                        }
                    } else {
                        player.sendMessage("§cFailed to load island!");
                    }
                });
            }
        });
    }
}
