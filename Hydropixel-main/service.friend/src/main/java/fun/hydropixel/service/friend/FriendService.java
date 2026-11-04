package fun.hydropixel.service.friend;

import fun.hydropixel.common.service.AbstractSkyBlockService;
import fun.hydropixel.common.service.ServiceType;
import fun.hydropixel.common.service.SkyBlockService;
import fun.hydropixel.common.service.redis.ServiceToServerManager;

public class FriendService extends AbstractSkyBlockService {
    public FriendService() {
        super(ServiceType.FRIEND, "fun.hydropixel.service.friend.endpoints");
    }

    public static void main(String[] args) {
        String mongoUri = System.getenv("MONGODB_URI");
        if (mongoUri == null) mongoUri = "mongodb://127.0.0.1:27017";
        
        new FriendDatabase(null).connect(mongoUri);

        FriendCache.startExpirationChecker();
        
        ServiceToServerManager.initialize(ServiceType.FRIEND);

        SkyBlockService.init(new FriendService());
    }
}
