package fun.hydropixel.skyblock.bazaar.listener;

import fun.hydropixel.skyblock.events.SEvent;
import fun.hydropixel.skyblock.player.SkyblockPlayer;
import net.minestom.server.event.inventory.InventoryOpenEvent;
import net.minestom.server.inventory.Inventory;

public class GuiListener extends SEvent<InventoryOpenEvent> {

    @Override
    public void onEvent(InventoryOpenEvent event) {
        SkyblockPlayer player = (SkyblockPlayer) event.getPlayer();
        if (event.getInventory() instanceof Inventory inv) {
            if (GuiCloseListener.isntBazaarInventory(inv)) {
                GuiCloseListener.clearBazaarData(player);
            } else {
                // If they open a top-level category menu or search menu, clear transient selections (amounts, selected items etc.)
                String title = fun.hydropixel.common.StringUtility.getTextFromComponent(inv.getTitle()).toLowerCase();
                if (title.contains("➔") && !title.contains("instant")) {
                    // Player is navigating categories, clear old buy/sell inputs so they don't persist
                    java.util.UUID uuid = player.getUuid();
                    fun.hydropixel.skyblock.bazaar.ui.buySell.BazaarInstantBuyMenu.amount.remove(uuid);
                    fun.hydropixel.skyblock.bazaar.ui.buySell.BazaarInstantSellMenu.amounts.remove(uuid);
                }
            }
        }
    }
}
