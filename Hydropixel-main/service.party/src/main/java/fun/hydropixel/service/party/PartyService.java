package fun.hydropixel.service.party;

import fun.hydropixel.common.service.AbstractSkyBlockService;
import fun.hydropixel.common.service.ServiceType;
import fun.hydropixel.common.service.SkyBlockService;
import fun.hydropixel.common.service.redis.ServiceToServerManager;

public class PartyService extends AbstractSkyBlockService {
    public PartyService() {
        super(ServiceType.PARTY, "fun.hydropixel.service.party.endpoints");
    }

    public static void main(String[] args) {
        String mongoUri = System.getenv("MONGODB_URI");
        if (mongoUri == null) mongoUri = "mongodb://127.0.0.1:27017";
        
        new PartyDatabase(null).connect(mongoUri);

        PartyCache.startExpirationChecker();
        
        ServiceToServerManager.initialize(ServiceType.PARTY);

        SkyBlockService.init(new PartyService());
    }
}
