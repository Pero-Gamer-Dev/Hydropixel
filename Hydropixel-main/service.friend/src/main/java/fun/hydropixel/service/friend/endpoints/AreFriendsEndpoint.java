package fun.hydropixel.service.friend.endpoints;

import fun.hydropixel.common.protocol.ProtocolObject;
import fun.hydropixel.common.protocol.objects.friend.AreFriendsProtocolObject;
import fun.hydropixel.common.service.impl.ServiceProxyRequest;
import fun.hydropixel.common.service.redis.ServiceEndpoint;
import fun.hydropixel.service.friend.FriendCache;

public class AreFriendsEndpoint implements ServiceEndpoint<AreFriendsProtocolObject.AreFriendsMessage, AreFriendsProtocolObject.AreFriendsResponse> {
    @Override
    public ProtocolObject<AreFriendsProtocolObject.AreFriendsMessage, AreFriendsProtocolObject.AreFriendsResponse> associatedProtocolObject() {
        return new AreFriendsProtocolObject();
    }

    @Override
    public AreFriendsProtocolObject.AreFriendsResponse onMessage(ServiceProxyRequest request, AreFriendsProtocolObject.AreFriendsMessage message) {
        return new AreFriendsProtocolObject.AreFriendsResponse(FriendCache.areFriends(message.player1(), message.player2()));
    }
}
