package fun.hydropixel.skyblock.player.fishing;

import fun.hydropixel.skyblock.entity.mob.EntityRegistry;

public final class FishingModule {

    private FishingModule() {}

    public static void init() {
        EntityRegistry.scanAndRegister("fun.hydropixel.skyblock.player.fishing.loot.mobs");
    }
}
