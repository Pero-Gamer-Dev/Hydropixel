package fun.hydropixel.skyblock.dungeon.server;

import fun.hydropixel.common.redis.PingService;
import fun.hydropixel.skyblock.Main;
import fun.hydropixel.skyblock.config.ServerConfig;
import fun.hydropixel.skyblock.dungeon.DungeonServiceImpl;
import fun.hydropixel.skyblock.dungeon.DungeonServiceRegistry;
import net.minestom.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DungeonServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DungeonServer.class);
    private static final String ADVERTISE_HOST = System.getenv().getOrDefault("HYDROPIXEL_ADVERTISE_HOST", "127.0.0.1");

    public static void main(String[] args) {
        ServerConfig config = ServerConfig.load();

        // Initialize Minestom
        MinecraftServer server = MinecraftServer.init(config.auth());

        // Initialize Core SkyBlock
        Main.initCore();

        // Initialize and Register Dungeon system implementation
        DungeonServiceRegistry.register(new DungeonServiceImpl());
        DungeonServiceRegistry.get().initialize();

        LOGGER.info("Starting Dungeon server on {}:{}", config.host(), config.port());
        server.start(config.host(), config.port());

        // Registration
        String serverName = System.getenv().getOrDefault("HYDROPIXEL_SERVER_NAME", "dungeon");
        PingService.start(serverName, ADVERTISE_HOST, config.port());
    }
}
