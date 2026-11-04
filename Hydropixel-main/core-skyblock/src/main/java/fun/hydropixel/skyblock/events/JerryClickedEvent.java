package fun.hydropixel.skyblock.events;

import fun.hydropixel.skyblock.player.SkyblockPlayer;
import net.minestom.server.event.Event;

public record JerryClickedEvent(SkyblockPlayer player) implements Event {
    public SkyblockPlayer getPlayer() {
        return player;
    }
}
