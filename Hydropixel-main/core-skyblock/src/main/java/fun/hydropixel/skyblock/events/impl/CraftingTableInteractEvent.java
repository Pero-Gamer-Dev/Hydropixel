package fun.hydropixel.skyblock.events.impl;

import fun.hydropixel.skyblock.events.SEvent;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.crafting.gui.CraftingMenu;
import net.minestom.server.event.player.PlayerBlockInteractEvent;
import net.minestom.server.instance.block.Block;

public class CraftingTableInteractEvent extends SEvent<PlayerBlockInteractEvent> {

    @Override
    public void onEvent(PlayerBlockInteractEvent event) {
        if (event.getBlock().compare(Block.CRAFTING_TABLE)) {
            if (event.getPlayer() instanceof SkyblockPlayer player) {
                event.setCancelled(true);
                CraftingMenu.open(player);
            }
        }
    }
}
