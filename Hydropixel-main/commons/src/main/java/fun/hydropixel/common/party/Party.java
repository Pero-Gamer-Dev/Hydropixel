package fun.hydropixel.common.party;

import fun.hydropixel.common.protocol.Serializer;

import java.util.List;
import java.util.UUID;

public interface Party {
    Serializer<? extends Party> getSerializer();

    List<UUID> getParticipants();
}
