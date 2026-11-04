package fun.hydropixel.service.party.endpoints;

import fun.hydropixel.common.party.FullParty;
import fun.hydropixel.common.protocol.ProtocolObject;
import fun.hydropixel.common.protocol.objects.party.IsPlayerInPartyProtocolObject;
import fun.hydropixel.common.service.impl.ServiceProxyRequest;
import fun.hydropixel.common.service.redis.ServiceEndpoint;
import fun.hydropixel.service.party.PartyCache;

public class IsPlayerInPartyEndpoint implements ServiceEndpoint<IsPlayerInPartyProtocolObject.IsPlayerInPartyMessage, IsPlayerInPartyProtocolObject.IsPlayerInPartyResponse> {
    @Override
    public ProtocolObject<IsPlayerInPartyProtocolObject.IsPlayerInPartyMessage, IsPlayerInPartyProtocolObject.IsPlayerInPartyResponse> associatedProtocolObject() {
        return new IsPlayerInPartyProtocolObject();
    }

    @Override
    public IsPlayerInPartyProtocolObject.IsPlayerInPartyResponse onMessage(ServiceProxyRequest request, IsPlayerInPartyProtocolObject.IsPlayerInPartyMessage message) {
        FullParty party = PartyCache.getPartyByMember(message.playerUuid());
        if (party == null) {
            return new IsPlayerInPartyProtocolObject.IsPlayerInPartyResponse(false, null);
        }
        return new IsPlayerInPartyProtocolObject.IsPlayerInPartyResponse(true, party.getUuid());
    }
}
