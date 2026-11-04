package fun.hydropixel.skyblock.item.items.swords;

import fun.hydropixel.skyblock.item.ItemAbility;
import fun.hydropixel.skyblock.item.SkyblockItem;
import fun.hydropixel.skyblock.item.items.ItemDefinition;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.player.stats.Stats;

import java.util.List;
import java.util.Map;

public class RogueSword implements ItemDefinition {

    private static final ItemAbility ABILITY = new ItemAbility(
            "Speed Boost", ItemAbility.AbilityType.RIGHT_CLICK,
            List.of("Grants <white>+100✦ Speed</white> for <green>30s</green>."),
            50, 0, 0, 5
    );

    @Override
    public String getItemId() {
        return "ROGUE_SWORD";
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
        player.applyEffect("rogue_sword_speed", Map.of(Stats.SPEED, 100.0), 30);
    }
}
