package fun.hydropixel.skyblock.quest.impl;

import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.quest.*;
import fun.hydropixel.skyblock.world.region.RegionType;
import java.util.*;

public class QuestTalkToBlacksmith extends Quest {
    @Override public String getID() { return "talk_to_blacksmith"; }
    @Override public String getName() { return "Talk to the Blacksmith"; }
    @Override public Map<String, Object> onStart(SkyblockPlayer player, ActiveQuest quest) { quest.getNewObjectiveText().forEach(player::sendMessage); return new HashMap<>(); }
    @Override public void onEnd(SkyblockPlayer player, Map<String, Object> customData, ActiveQuest quest) {
        player.getActiveProfileData().getQuestData().startQuest(QuestMineCoal.class);
    }
    @Override public Set<RegionType> getValidRegions() { return Collections.singleton(RegionType.HUB); }
}
