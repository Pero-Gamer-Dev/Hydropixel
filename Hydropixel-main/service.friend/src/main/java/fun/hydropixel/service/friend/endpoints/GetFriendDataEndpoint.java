package fun.hydropixel.service.friend.endpoints;

import fun.hydropixel.common.protocol.ProtocolObject;
import fun.hydropixel.common.protocol.objects.friend.GetFriendDataProtocolObject;
import fun.hydropixel.common.service.impl.ServiceProxyRequest;
import fun.hydropixel.common.service.redis.ServiceEndpoint;
import fun.hydropixel.service.friend.FriendCache;

public class GetFriendDataEndpoint implements ServiceEndpoint<GetFriendDataProtocolObject.GetFriendDataMessage, GetFriendDataProtocolObject.GetFriendDataResponse> {
    @Override
    public ProtocolObject<GetFriendDataProtocolObject.GetFriendDataMessage, GetFriendDataProtocolObject.GetFriendDataResponse> associatedProtocolObject() {
        return new GetFriendDataProtocolObject();
    }

    @Override
    public GetFriendDataProtocolObject.GetFriendDataResponse onMessage(ServiceProxyRequest request, GetFriendDataProtocolObject.GetFriendDataMessage message) {
        return new GetFriendDataProtocolObject.GetFriendDataResponse(FriendCache.getFriendData(message.playerUuid()));
    }
}
