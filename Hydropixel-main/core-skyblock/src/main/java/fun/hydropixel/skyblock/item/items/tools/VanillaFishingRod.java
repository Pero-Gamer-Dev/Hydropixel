package fun.hydropixel.skyblock.item.items.tools;

import fun.hydropixel.skyblock.item.ItemType;
import fun.hydropixel.skyblock.item.SkyblockItem;
import fun.hydropixel.skyblock.item.items.ItemDefinition;
import fun.hydropixel.skyblock.player.stats.Stats;

public class VanillaFishingRod implements ItemDefinition {

    @Override
    public String getItemId() {
        return "FISHING_ROD";
    }

    @Override
    public SkyblockItem.Builder apply(SkyblockItem.Builder builder) {
        return builder
                .displayName("Fishing Rod")
                .itemType(ItemType.FISHING_ROD)
                .stat(Stats.FISHING_SPEED, 20.0)
                .stat(Stats.SEA_CREATURE_CHANCE, 5.0)
                .description(
                        "A simple wooden rod used for catching fish,",
                        "treasures, and sea creatures."
                );
    }
}
