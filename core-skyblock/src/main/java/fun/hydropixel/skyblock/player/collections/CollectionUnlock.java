package fun.hydropixel.skyblock.player.collections;

import fun.hydropixel.skyblock.player.profiles.SkyblockProfile;

public abstract class CollectionUnlock {
    public abstract String getDisplay();
    public abstract void apply(SkyblockProfile profile);

    public enum Type {
        RECIPE,
        XP,
        CUSTOM
    }
}
