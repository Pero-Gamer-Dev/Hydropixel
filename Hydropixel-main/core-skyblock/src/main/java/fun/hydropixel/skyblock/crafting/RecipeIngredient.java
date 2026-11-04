package fun.hydropixel.skyblock.crafting;

import fun.hydropixel.skyblock.item.ItemRegistry;
import fun.hydropixel.skyblock.item.SkyblockItem;
import lombok.Getter;

@Getter
public class RecipeIngredient {
    private final String itemId;
    private final int amount;

    public RecipeIngredient(String itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
    }

    public boolean matches(SkyblockItem item) {
        if (item == null) return false;
        String thisId = ItemRegistry.canonicalizeId(itemId);
        String thatId = ItemRegistry.canonicalizeId(item.getItemId());
        return thisId.equalsIgnoreCase(thatId);
    }
}
