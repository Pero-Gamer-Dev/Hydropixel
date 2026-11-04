package fun.hydropixel.common.service.redis;

import fun.hydropixel.common.service.FromServiceChannels;
import org.json.JSONObject;

public interface ServiceToClient {
    FromServiceChannels getChannel();
    JSONObject onMessage(JSONObject message);
}
