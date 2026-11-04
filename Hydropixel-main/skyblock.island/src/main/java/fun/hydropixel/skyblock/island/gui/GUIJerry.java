package fun.hydropixel.skyblock.island.gui;

import fun.hydropixel.common.gui.InventoryGUI;
import net.minestom.server.event.inventory.InventoryPreClickEvent;
import net.minestom.server.inventory.InventoryType;

public class GUIJerry extends InventoryGUI {

    public GUIJerry() {
        super("Jerry The Assistant", InventoryType.CHEST_4_ROW);
    }

    @Override
    public boolean allowHotkeying() {
        return false;
    }

    @Override
    public void onBottomClick(InventoryPreClickEvent e) {
        e.setCancelled(true);
    }
}
