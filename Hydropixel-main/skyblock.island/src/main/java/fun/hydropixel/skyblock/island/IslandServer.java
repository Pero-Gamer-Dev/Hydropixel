package fun.hydropixel.skyblock.island;

import fun.hydropixel.common.redis.PingService;
import fun.hydropixel.skyblock.Main;
import fun.hydropixel.skyblock.config.ServerConfig;
import net.minestom.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IslandServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(IslandServer.class);
    private static final String ADVERTISE_HOST = System.getenv().getOrDefault("HYDROPIXEL_ADVERTISE_HOST", "127.0.0.1");

    public static void main(String[] args) {
        ServerConfig config = ServerConfig.load();
        
        // Initialize Minestom
        MinecraftServer server = MinecraftServer.init(config.auth());
        
        // Initialize Core SkyBlock
        Main.initCore();
        
        // Initialize Island NPCs
        IslandNPCManager.init(MinecraftServer.getGlobalEventHandler());
        
        LOGGER.info("Starting SkyBlock ISLAND server on {}:{}", config.host(), config.port());
        server.start(config.host(), config.port());
        
        // Registration
        String serverName = System.getenv().getOrDefault("HYDROPIXEL_SERVER_NAME", "skyblock-island");
        PingService.start(serverName, ADVERTISE_HOST, config.port());
    }
}
