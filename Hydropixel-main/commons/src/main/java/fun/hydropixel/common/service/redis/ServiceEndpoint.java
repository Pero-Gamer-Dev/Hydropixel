package fun.hydropixel.common.service.redis;

import fun.hydropixel.common.protocol.ProtocolObject;
import fun.hydropixel.common.service.impl.ServiceProxyRequest;

public interface ServiceEndpoint<T, R> {
    ProtocolObject<T, R> associatedProtocolObject();

    R onMessage(ServiceProxyRequest request, T message);
}
