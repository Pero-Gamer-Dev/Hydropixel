package fun.hydropixel.skyblock.minion.types;

import fun.hydropixel.skyblock.minion.base.MiningMinion;
import fun.hydropixel.skyblock.minion.model.MinionType;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.instance.Instance;

import java.util.UUID;

public final class GoldMinion extends MiningMinion {
    public GoldMinion(UUID ownerUuid, int tier, Instance instance, Pos position) {
        super(ownerUuid, MinionType.GOLD, tier, instance, position);
    }
}
