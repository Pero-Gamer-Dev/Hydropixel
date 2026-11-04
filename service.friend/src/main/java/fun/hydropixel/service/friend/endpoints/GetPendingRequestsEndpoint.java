package fun.hydropixel.service.friend.endpoints;

import fun.hydropixel.common.protocol.ProtocolObject;
import fun.hydropixel.common.protocol.objects.friend.GetPendingFriendRequestsProtocolObject;
import fun.hydropixel.common.service.impl.ServiceProxyRequest;
import fun.hydropixel.common.service.redis.ServiceEndpoint;
import fun.hydropixel.service.friend.FriendCache;

public class GetPendingRequestsEndpoint implements ServiceEndpoint<GetPendingFriendRequestsProtocolObject.GetPendingRequestsMessage, GetPendingFriendRequestsProtocolObject.GetPendingRequestsResponse> {
    @Override
    public ProtocolObject<GetPendingFriendRequestsProtocolObject.GetPendingRequestsMessage, GetPendingFriendRequestsProtocolObject.GetPendingRequestsResponse> associatedProtocolObject() {
        return new GetPendingFriendRequestsProtocolObject();
    }

    @Override
    public GetPendingFriendRequestsProtocolObject.GetPendingRequestsResponse onMessage(ServiceProxyRequest request, GetPendingFriendRequestsProtocolObject.GetPendingRequestsMessage message) {
        return new GetPendingFriendRequestsProtocolObject.GetPendingRequestsResponse(FriendCache.getPendingRequestsFor(message.playerUuid()));
    }
}
