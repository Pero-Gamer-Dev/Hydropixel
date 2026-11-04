package fun.hydropixel.skyblock.player.collections;

import fun.hydropixel.skyblock.item.ItemRegistry;
import fun.hydropixel.skyblock.player.profiles.SkyblockProfile;

public class CustomUnlock extends CollectionUnlock {
    private final String award;

    public CustomUnlock(String award) {
        this.award = award;
    }

    @Override
    public String getDisplay() {
        return "§6" + ItemRegistry.formatName(award);
    }

    @Override
    public void apply(SkyblockProfile profile) {
    }
}
