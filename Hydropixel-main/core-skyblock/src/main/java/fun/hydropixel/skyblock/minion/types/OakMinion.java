package fun.hydropixel.skyblock.minion.types;

import fun.hydropixel.skyblock.minion.base.TreeMinion;
import fun.hydropixel.skyblock.minion.model.MinionType;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.instance.Instance;

import java.util.UUID;

public final class OakMinion extends TreeMinion {
    public OakMinion(UUID ownerUuid, int tier, Instance instance, Pos position) {
        super(ownerUuid, MinionType.OAK, tier, instance, position);
    }
}
