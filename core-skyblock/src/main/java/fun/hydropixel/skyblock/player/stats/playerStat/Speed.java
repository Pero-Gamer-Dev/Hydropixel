package fun.hydropixel.skyblock.player.stats.playerStat;

import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.player.stats.Stats;

import static net.minestom.server.entity.attribute.Attribute.MOVEMENT_SPEED;

public class Speed {

    public static void apply(SkyblockPlayer player) {
        double speed = player.maxStat(Stats.SPEED);
        player.getAttribute(MOVEMENT_SPEED).setBaseValue(speed / 1000.0);
    }
}
