package fun.hydropixel.skyblock.item.items.equipment;

import fun.hydropixel.skyblock.item.SkyblockItem;
import fun.hydropixel.skyblock.item.items.ItemDefinition;

public class SoulweaverGloves implements ItemDefinition {

    @Override
    public String getItemId() {
        return "SOULWEAVER_GLOVES";
    }

    @Override
    public SkyblockItem.Builder apply(SkyblockItem.Builder builder) {
        return builder
                .description("While in <red>The Catacombs<gray>, summon a",
                        "<red>Haunted Skull <gray>that slowly revolves",
                        "around you every <green>15 <gray>seconds or",
                        "when you kill a mob with melee damage.",
                        " ",
                        "When a enemy is hit by a <red>Haunted",
                        "<red>Skull<gray>, they are stunned for <aqua>2",
                        "seconds and deal <red>5% <gray>less damage.");
    }
}
