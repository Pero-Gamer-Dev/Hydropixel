package fun.hydropixel.skyblock.events.impl;

import fun.hydropixel.skyblock.entity.display.DroppedItemEntity;
import fun.hydropixel.skyblock.events.SEvent;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import net.minestom.server.event.player.PlayerDisconnectEvent;

public class PlayerDisconnectCleanupEvent extends SEvent<PlayerDisconnectEvent> {

    @Override
    public void onEvent(PlayerDisconnectEvent event) {
        if (event.getPlayer() instanceof SkyblockPlayer player) {
            DroppedItemEntity.clearDroppedItems(player);
        }
    }
}
