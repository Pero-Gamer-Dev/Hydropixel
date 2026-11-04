package fun.hydropixel.skyblock;

import fun.hydropixel.common.gui.InventoryGUIListener;
import fun.hydropixel.skyblock.events.EventManager;
import fun.hydropixel.skyblock.island.IslandManager;
import fun.hydropixel.skyblock.island.IslandSystemListener;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.player.actionbar.ActionBarManager;
import fun.hydropixel.skyblock.player.bestiary.BestiaryService;
import fun.hydropixel.skyblock.player.collections.CollectionRegistry;
import fun.hydropixel.skyblock.player.combat.CombatListener;
import fun.hydropixel.skyblock.player.fishing.FishingModule;
import fun.hydropixel.skyblock.player.level.SkyBlockLevelRequirement;
import fun.hydropixel.skyblock.player.profiles.ProfileManager;
import fun.hydropixel.skyblock.player.scoreboard.ScoreboardManager;
import fun.hydropixel.skyblock.player.skill.SkillRegistry;
import fun.hydropixel.skyblock.player.skill.listener.SkillListeners;
import fun.hydropixel.skyblock.minion.service.MinionManager;
import fun.hydropixel.skyblock.auction.AuctionRegistry;
import fun.hydropixel.skyblock.bazaar.BazaarRegistry;
import fun.hydropixel.skyblock.blocks.BlockManager;
import fun.hydropixel.skyblock.cmds.CommandHandler;
import fun.hydropixel.skyblock.crafting.RecipeRegistry;
import fun.hydropixel.skyblock.dungeon.DungeonServiceRegistry;
import fun.hydropixel.skyblock.entity.mob.EntityRegistry;
import fun.hydropixel.skyblock.item.ItemRegistry;
import fun.hydropixel.skyblock.item.items.ItemDefinitions;
import fun.hydropixel.skyblock.item.reforge.Reforge;
import fun.hydropixel.skyblock.listeners.ProfileListener;
import fun.hydropixel.skyblock.listeners.SkyblockChatListener;
import fun.hydropixel.skyblock.npc.SkyblockNPCManager;
import fun.hydropixel.skyblock.calendar.Calendar;
import fun.hydropixel.skyblock.shop.ShopRegistry;
import fun.hydropixel.skyblock.world.region.RegionListener;
import fun.hydropixel.skyblock.world.region.RegionManager;
import net.minestom.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fun.hydropixel.common.Hydropixel;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void initCore() {
        Hydropixel.initialize();

        MinecraftServer.getConnectionManager().setPlayerProvider(SkyblockPlayer::new);

        ItemDefinitions.init();
        ItemRegistry.init();
        Reforge.init();

        EventManager.initialise();
        SkyblockNPCManager.init();
        BlockManager.initialize();
        Calendar.startTimeUpdates();
        ScoreboardManager.init();
        ActionBarManager.init();
        MinionManager.init();
        SkillRegistry.init();
        SkillListeners.register();
        CollectionRegistry.init();
        SkyBlockLevelRequirement.loadFromYaml();
        RecipeRegistry.init();
        fun.hydropixel.skyblock.quest.QuestRegistry.init();
        CommandHandler.initialise();
        EntityRegistry.scanAndRegister("fun.hydropixel.skyblock.entity.mob.mobs");
        FishingModule.init();
        CombatListener.register();
        SkyblockChatListener.register();
        RegionManager.initialize();
        BazaarRegistry.initialise();
        AuctionRegistry.initialise();
        ShopRegistry.initialise();
        BestiaryService.register(MinecraftServer.getGlobalEventHandler());
        RegionListener.register(MinecraftServer.getGlobalEventHandler());
        ProfileListener.register(MinecraftServer.getGlobalEventHandler());
        IslandSystemListener.register(MinecraftServer.getGlobalEventHandler());
        InventoryGUIListener.register(MinecraftServer.getGlobalEventHandler());
        
        String serverType = System.getenv().getOrDefault("HYDROPIXEL_SERVER_TYPE", "HUB");
        if (serverType.equalsIgnoreCase("ISLAND")) {
            IslandManager.runVacantLoop();
        }
        
        if (DungeonServiceRegistry.get() != null) {
            DungeonServiceRegistry.get().initialize();
        }

        LOGGER.info("Core SkyBlock initialized successfully!");
    }

    public static void shutdown() {
        LOGGER.info("Shutting down SkyBlock Core...");
        ProfileManager.saveAllProfiles();
        MinecraftServer.stopCleanly();
    }
}

