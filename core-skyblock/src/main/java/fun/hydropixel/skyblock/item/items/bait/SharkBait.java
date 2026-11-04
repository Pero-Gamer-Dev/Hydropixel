package fun.hydropixel.skyblock.item.items.bait;

import fun.hydropixel.skyblock.item.ItemType;
import fun.hydropixel.skyblock.item.SkyblockItem;
import fun.hydropixel.skyblock.item.items.ItemDefinition;

public class SharkBait implements ItemDefinition {

    @Override
    public String getItemId() {
        return "SHARK_BAIT";
    }

    @Override
    public SkyblockItem.Builder apply(SkyblockItem.Builder builder) {
        return builder
                .displayName("Shark Bait")
                .itemType(ItemType.BAIT)
                .description(
                        "Increases sea creature chance by 10%.",
                        "Consumed on cast."
                );
    }
}
