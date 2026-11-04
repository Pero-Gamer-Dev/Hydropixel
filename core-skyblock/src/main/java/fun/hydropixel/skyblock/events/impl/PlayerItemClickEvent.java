package fun.hydropixel.skyblock.events.impl;

import fun.hydropixel.skyblock.events.SEvent;
import fun.hydropixel.skyblock.menus.SkyblockMenu;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import net.minestom.server.event.inventory.InventoryPreClickEvent;
import net.minestom.server.inventory.PlayerInventory;

public class PlayerItemClickEvent extends SEvent<InventoryPreClickEvent> {

    @Override
    public void onEvent(InventoryPreClickEvent event) {
        if(event.getInventory() instanceof PlayerInventory inventory){
            if(inventory.getViewers().isEmpty()) return;
            if(!inventory.getViewers().contains(event.getPlayer()))return;
            if(event.getClickedItem().getTag(PlayerJoinPostEvent.menuTag) == null) return;
            if(event.getClickedItem().getTag(PlayerJoinPostEvent.menuTag)){
                event.setCancelled(true);
                SkyblockMenu.open((SkyblockPlayer) event.getPlayer());
            }
        }
    }
}
