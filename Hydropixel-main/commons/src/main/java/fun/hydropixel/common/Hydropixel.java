package fun.hydropixel.common;

import fun.hydropixel.common.redis.RedisConfig;
import fun.hydropixel.common.redis.RedisManager;
import fun.hydropixel.common.user.UserManager;
import fun.hydropixel.common.service.redis.ServerOutboundMessage;

public class Hydropixel {
    public static void initialize() {
        // Initialize Redis
        if (!RedisManager.isInitialized()) {
            RedisManager.connect(RedisConfig.fromEnv());
        }

        // Initialize Outbound Messages
        ServerOutboundMessage.init();

        // Initialize MongoDB / UserManager
        String mongoUri = System.getenv().getOrDefault("MONGODB_URI", "mongodb://127.0.0.1:27017");
        UserManager.init(mongoUri);

        System.out.println("[Hydropixel] System initialized (Redis, MongoDB, Outbound Messages)");
    }
}
