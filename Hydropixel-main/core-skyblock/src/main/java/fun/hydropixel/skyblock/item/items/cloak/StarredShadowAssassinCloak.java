package fun.hydropixel.skyblock.item.items.cloak;

import fun.hydropixel.skyblock.item.SkyblockItem;
import fun.hydropixel.skyblock.item.items.ItemDefinition;

public class StarredShadowAssassinCloak implements ItemDefinition {

    @Override
    public String getItemId() {
        return "STARRED_SHADOW_ASSASSIN_CLOAK";
    }

    @Override
    public SkyblockItem.Builder apply(SkyblockItem.Builder builder) {
        return builder
                .description("On teleport: Your next melee hit",
                        "within <green>5s<gray> deals <red>10% <gray>more damage.");
    }
}
