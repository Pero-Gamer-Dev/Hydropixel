package fun.hydropixel.skyblock.item.items.swords;

import fun.hydropixel.skyblock.item.ItemAbility;
import fun.hydropixel.skyblock.item.SkyblockItem;
import fun.hydropixel.skyblock.item.items.ItemDefinition;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.player.stats.Stats;
import fun.hydropixel.skyblock.util.ItemTeleport;

import java.util.List;
import java.util.Map;

public class AspectOfTheEnd implements ItemDefinition {

    private static final ItemAbility ABILITY = new ItemAbility(
            "Instant Transmission", ItemAbility.AbilityType.RIGHT_CLICK,
            List.of("Teleport <green>8 blocks</green> ahead of you and",
                    "gain <green>+50 <white>✦ Speed</white> for <green>3 seconds</green>."),
            50, 0, 0, 0
    );

    @Override
    public String getItemId() {
        return "ASPECT_OF_THE_END";
    }

    @Override
    public ItemAbility ability() {
        return ABILITY;
    }

    @Override
    public SkyblockItem.Builder apply(SkyblockItem.Builder builder) {
        return builder.ability(ABILITY);
    }

    @Override
    public void onRightClick(SkyblockPlayer player) {
        if (!ItemTeleport.teleport(player, 8, false)) return;
        player.applyEffect("instant_transmission_speed", Map.of(Stats.SPEED, 50.0), 3);
    }
}
