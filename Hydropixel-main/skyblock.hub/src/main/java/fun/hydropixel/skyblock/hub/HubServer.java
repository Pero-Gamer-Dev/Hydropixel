package fun.hydropixel.skyblock.hub;

import fun.hydropixel.common.redis.PingService;
import fun.hydropixel.skyblock.Main;
import fun.hydropixel.skyblock.config.ServerConfig;
import fun.hydropixel.skyblock.world.WorldHandler;
import fun.hydropixel.skyblock.entity.mob.SpotSpawnerTicker;
import net.minestom.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HubServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(HubServer.class);
    private static final String ADVERTISE_HOST = System.getenv().getOrDefault("HYDROPIXEL_ADVERTISE_HOST", "127.0.0.1");

    public static void main(String[] args) {
        ServerConfig config = ServerConfig.load();
        
        // Initialize Minestom
        MinecraftServer server = MinecraftServer.init(config.auth());
        
        // Initialize Core SkyBlock
        Main.initCore();
        
        // Hub Specific Initialization
        WorldHandler.initialise();
        HubManager.init();
        SpotSpawnerTicker.start();
        
        LOGGER.info("Starting SkyBlock HUB server on {}:{}", config.host(), config.port());
        server.start(config.host(), config.port());
        
        // Registration
        String serverName = System.getenv().getOrDefault("HYDROPIXEL_SERVER_NAME", "skyblock-hub");
        PingService.start(serverName, ADVERTISE_HOST, config.port());
    }
}
