package fun.hydropixel.skyblock.item.items.bait;

import fun.hydropixel.skyblock.item.ItemType;
import fun.hydropixel.skyblock.item.SkyblockItem;
import fun.hydropixel.skyblock.item.items.ItemDefinition;

public class FishBait implements ItemDefinition {

    @Override
    public String getItemId() {
        return "FISH_BAIT";
    }

    @Override
    public SkyblockItem.Builder apply(SkyblockItem.Builder builder) {
        return builder
                .displayName("Fish Bait")
                .itemType(ItemType.BAIT)
                .description(
                        "Increases fishing speed by 30%.",
                        "Consumed on cast."
                );
    }
}
