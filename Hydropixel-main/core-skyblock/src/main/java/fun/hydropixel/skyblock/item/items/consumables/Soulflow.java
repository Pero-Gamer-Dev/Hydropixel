package fun.hydropixel.skyblock.item.items.consumables;

import fun.hydropixel.skyblock.item.SkyblockItem;
import fun.hydropixel.skyblock.item.items.ItemDefinition;

public class Soulflow implements ItemDefinition {

    @Override
    public String getItemId() {
        return "SOULFLOW";
    }

    @Override
    public SkyblockItem.Builder apply(SkyblockItem.Builder builder) {
        return builder
                .description("Hold an right-click to consume,",
                        "gaining <dark_aqua>+160⸎ Soulflow<gray>!");
    }
}
