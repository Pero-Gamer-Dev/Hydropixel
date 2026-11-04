package fun.hydropixel.skyblock.dungeon_hub;

import fun.hydropixel.common.redis.PingService;
import fun.hydropixel.skyblock.Main;
import fun.hydropixel.skyblock.config.ServerConfig;
import net.minestom.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DungeonHubServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DungeonHubServer.class);
    private static final String ADVERTISE_HOST = System.getenv().getOrDefault("HYDROPIXEL_ADVERTISE_HOST", "127.0.0.1");

    public static void main(String[] args) {
        ServerConfig config = ServerConfig.load();
        MinecraftServer server = MinecraftServer.init(config.auth());
        Main.initCore();
        DungeonHubManager.init();

        LOGGER.info("Starting Dungeon Hub server on {}:{}", config.host(), config.port());
        server.start(config.host(), config.port());

        String serverName = System.getenv().getOrDefault("HYDROPIXEL_SERVER_NAME", "dungeon-hub");
        PingService.start(serverName, ADVERTISE_HOST, config.port());
    }
}
