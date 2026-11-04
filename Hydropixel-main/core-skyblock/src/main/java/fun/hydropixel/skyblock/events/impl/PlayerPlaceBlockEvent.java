package fun.hydropixel.skyblock.events.impl;

import fun.hydropixel.skyblock.events.SEvent;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.world.WorldHandler;
import net.minestom.server.entity.GameMode;
import net.minestom.server.event.player.PlayerBlockPlaceEvent;
import net.minestom.server.tag.Tag;

public class PlayerPlaceBlockEvent extends SEvent<PlayerBlockPlaceEvent> {

    @Override
    public void onEvent(PlayerBlockPlaceEvent event) {
        if (event.getPlayer() instanceof SkyblockPlayer pl) {
            if (pl.getGameMode() == GameMode.CREATIVE) {
                event.setBlock(event.getBlock().withTag(Tag.Boolean("player_placed"), true));
                return;
            }

            String worldId = event.getInstance().getTag(WorldHandler.worldID);
            boolean isOwnIsland = pl.getActiveProfile() != null && worldId != null && worldId.equals(pl.getActiveProfile().profileID.toString());

            if (!isOwnIsland) {
                event.setCancelled(true);
            } else {
                event.setBlock(event.getBlock().withTag(Tag.Boolean("player_placed"), true));
            }
        }
    }
}
