package fun.hydropixel.skyblock.quest.impl;

import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.quest.*;
import fun.hydropixel.skyblock.world.region.RegionType;
import java.util.*;

public class QuestGiveWoolToCarpenter extends Quest {
    @Override public String getID() { return "give_wool_to_carpenter"; }
    @Override public String getName() { return "Give Wool to the Carpenter"; }
    @Override public Map<String, Object> onStart(SkyblockPlayer player, ActiveQuest quest) { quest.getNewObjectiveText().forEach(player::sendMessage); return new HashMap<>(); }
    @Override public void onEnd(SkyblockPlayer player, Map<String, Object> customData, ActiveQuest quest) {
    }
    @Override public Set<RegionType> getValidRegions() { return Collections.singleton(RegionType.HUB); }
}
