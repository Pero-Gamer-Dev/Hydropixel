package fun.hydropixel.skyblock.item.items;

import fun.hydropixel.skyblock.item.ItemAbility;
import fun.hydropixel.skyblock.item.SkyblockItem;
import fun.hydropixel.skyblock.player.SkyblockPlayer;

public interface ItemDefinition {

    String getItemId();

    SkyblockItem.Builder apply(SkyblockItem.Builder builder);

    default ItemAbility ability() { return null; }

    default void onRightClick(SkyblockPlayer player) {}

    default void onLeftClick(SkyblockPlayer player) {}
}
