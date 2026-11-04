package fun.hydropixel.skyblock.npc;

import fun.hydropixel.common.npc.HydropixelNpc;
import fun.hydropixel.common.npc.NpcManager;
import net.minestom.server.entity.Entity;

import java.util.HashSet;
import java.util.Set;

public class SkyblockNPCManager {
    private static final NpcManager<HydropixelNpc> MANAGER = new NpcManager<>();
    private static final Set<HydropixelNpc> SKYBLOCK_NPCS = new HashSet<>();

    public static void init() {
        MANAGER.registerListeners(net.minestom.server.MinecraftServer.getGlobalEventHandler());
    }

    public static void registerNPC(HydropixelNpc npc) {
        SKYBLOCK_NPCS.add(npc);
        MANAGER.register(npc);
    }

    public static Set<HydropixelNpc> getNPCS() {
        return SKYBLOCK_NPCS;
    }

    public static HydropixelNpc getNPCbyID(String id) {
        if (id == null) return null;
        return MANAGER.getById(id).orElse(null);
    }

    public static HydropixelNpc getNPCByEntity(Entity minestomEntity) {
        if (minestomEntity == null) return null;
        return MANAGER.getByEntity(minestomEntity).orElse(null);
    }

    public static void removeNPCbyID(String id) {
        if (id == null) return;
        SKYBLOCK_NPCS.removeIf(npc -> {
            if (npc.id() != null && npc.id().equals(id)) {
                MANAGER.removeById(id);
                return true;
            }
            return false;
        });
    }
}
