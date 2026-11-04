package fun.hydropixel.skyblock.player.scoreboard;

import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.events.EventManager;
import fun.hydropixel.skyblock.events.SEvent;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.PlayerDisconnectEvent;
import net.minestom.server.timer.TaskSchedule;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ScoreboardManager {
    private static final Map<UUID, AdvancedScoreboard> scoreboards = new HashMap<>();

    public static void init() {
        EventManager.registerEvent(new SEvent<PlayerDisconnectEvent>() {
            @Override
            public void onEvent(PlayerDisconnectEvent event) {
                if (event.getPlayer() instanceof SkyblockPlayer sbPlayer) {
                    remove(sbPlayer);
                }
            }
        });

        MinecraftServer.getSchedulerManager().buildTask(() -> {
            for (Player player : MinecraftServer.getConnectionManager().getOnlinePlayers()) {
                if (player instanceof SkyblockPlayer sbPlayer) {
                    AdvancedScoreboard scoreboard = scoreboards.get(sbPlayer.getUuid());
                    if (scoreboard == null) {
                        scoreboard = new AdvancedScoreboard(sbPlayer);
                        scoreboards.put(sbPlayer.getUuid(), scoreboard);
                    }
                    scoreboard.update();
                    sbPlayer.setDisplayName(fun.hydropixel.common.user.UserManager.getDisplayName(sbPlayer.getUuid()));
                }
            }
        }).repeat(TaskSchedule.tick(4)).schedule();
    }

    public static void remove(SkyblockPlayer player) {
        AdvancedScoreboard sb = scoreboards.remove(player.getUuid());
        if (sb != null) {
            sb.destroy();
        }
    }
}
