package fun.hydropixel.skyblock.player.fishing.event;

import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.player.fishing.WaterHookEntity;
import net.minestom.server.event.trait.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class HookCastEvent implements PlayerEvent {

    private final SkyblockPlayer player;
    private final WaterHookEntity hook;

    public HookCastEvent(@NotNull SkyblockPlayer player, @NotNull WaterHookEntity hook) {
        this.player = player;
        this.hook = hook;
    }

    @Override
    public @NotNull SkyblockPlayer getPlayer() {
        return player;
    }

    public @NotNull WaterHookEntity getHook() {
        return hook;
    }
}
