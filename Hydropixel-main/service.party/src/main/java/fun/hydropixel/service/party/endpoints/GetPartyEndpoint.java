package fun.hydropixel.service.party.endpoints;

import fun.hydropixel.common.protocol.ProtocolObject;
import fun.hydropixel.common.protocol.objects.party.GetPartyProtocolObject;
import fun.hydropixel.common.service.impl.ServiceProxyRequest;
import fun.hydropixel.common.service.redis.ServiceEndpoint;
import fun.hydropixel.service.party.PartyCache;

public class GetPartyEndpoint implements ServiceEndpoint<GetPartyProtocolObject.GetPartyMessage, GetPartyProtocolObject.GetPartyResponse> {
    @Override
    public ProtocolObject<GetPartyProtocolObject.GetPartyMessage, GetPartyProtocolObject.GetPartyResponse> associatedProtocolObject() {
        return new GetPartyProtocolObject();
    }

    @Override
    public GetPartyProtocolObject.GetPartyResponse onMessage(ServiceProxyRequest request, GetPartyProtocolObject.GetPartyMessage message) {
        return new GetPartyProtocolObject.GetPartyResponse(PartyCache.getPartyByMember(message.memberUuid()));
    }
}
