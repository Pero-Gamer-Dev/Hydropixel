package fun.hydropixel.skyblock.shop;

import fun.hydropixel.skyblock.player.SkyblockPlayer;
import net.kyori.adventure.text.Component;

import java.util.List;

public interface ShopPrice {

    List<Component> getGUIDisplay();

    String getNamePlural();

    boolean canAfford(SkyblockPlayer player);

    void processPurchase(SkyblockPlayer player);

    ShopPrice multiply(int amount);

    ShopPrice divide(double amount);
}
