package fun.hydropixel.lobby;

import fun.hydropixel.common.Hydropixel;
import fun.hydropixel.common.gui.InventoryGUIListener;
import fun.hydropixel.common.redis.PingService;
import fun.hydropixel.common.restart.RestartManager;
import fun.hydropixel.lobby.config.LobbyConfig;
import fun.hydropixel.lobby.item.LobbyItemManager;
import fun.hydropixel.lobby.listener.LobbyChatListener;
import fun.hydropixel.lobby.listener.LobbyConnectionListener;
import fun.hydropixel.lobby.listener.LobbyProtectionListener;
import fun.hydropixel.lobby.npc.LobbyNpcManager;
import fun.hydropixel.lobby.leaderboard.LeaderboardManager;
import fun.hydropixel.common.command.AchievementCommand;
import fun.hydropixel.common.command.RestartCommand;
import fun.hydropixel.lobby.command.FlyCommand;
import fun.hydropixel.lobby.gui.AchievementMenuGUI;
import fun.hydropixel.lobby.world.LobbyWorld;
import fun.hydropixel.lobby.scoreboard.LobbyScoreboardManager;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.PlayerMoveEvent;

public final class Main {
    private static String currentServerName;
    private static final String ADVERTISE_HOST = System.getenv().getOrDefault("HYDROPIXEL_ADVERTISE_HOST", "127.0.0.1");
    public static String getServerName() {
        return currentServerName;
    }

    private Main() {}

    public static void main(String[] args) {
        LobbyConfig config = LobbyConfig.load();
        Hydropixel.initialize();

        // ── Minestom ────────────────────────────────────────────────────────
        MinecraftServer server = MinecraftServer.init(config.auth());

        LobbyWorld world = LobbyWorld.create();
        LobbyNpcManager npcManager = new LobbyNpcManager(world.instance());
        npcManager.spawnDefaults();

        LeaderboardManager leaderboardManager = new LeaderboardManager();
        leaderboardManager.init(world.instance());

        registerEvents(world, npcManager, leaderboardManager);
        MinecraftServer.getCommandManager().register(new FlyCommand());
        MinecraftServer.getCommandManager().register(new RestartCommand());
        MinecraftServer.getCommandManager().register(new AchievementCommand());
        AchievementCommand.setGuiOpener(player -> new AchievementMenuGUI().open(player));

        LobbyScoreboardManager.init();
        String serverName = System.getenv("HYDROPIXEL_SERVER_NAME");
        if (serverName == null || serverName.isBlank() || serverName.equals("lobby")) {
            String base = (serverName == null || serverName.isBlank()) ? "lobby" : serverName;
            serverName = base + "-" + java.util.UUID.randomUUID().toString().substring(0, 5);
        }
        currentServerName = serverName;

        // ── Ping (must start BEFORE server.start() because it's blocking) ──
        PingService.start(serverName, ADVERTISE_HOST, config.port());

        System.out.println("[Lobby] Starting the Server on " + config.host() + ":" + config.port());
        server.start(config.host(), config.port());
        
        // After this, it only exits when server.stopCleanly() is called
        System.out.println("[Lobby] Server has stopped.");
        
        // Check if we need to restart (exit code 3)
        if (RestartManager.getExitCode() == 3) {
            System.exit(3);
        }
    }

    private static void registerEvents(LobbyWorld world, LobbyNpcManager npcManager, LeaderboardManager leaderboardManager) {
        GlobalEventHandler handler = MinecraftServer.getGlobalEventHandler();

        InventoryGUIListener.register(handler);

        LobbyConnectionListener.register(handler, world);

        handler.addListener(PlayerMoveEvent.class, event -> {
            if (event.getNewPosition().y() < 0) {
                event.getPlayer().teleport(world.spawn());
            }
        });

        LobbyItemManager.init(handler);
        LobbyProtectionListener.register(handler);
        LobbyChatListener.register(handler);
        npcManager.registerListeners(handler);
        leaderboardManager.registerListeners(handler);
    }
}

