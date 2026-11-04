package fun.hydropixel.lobby.npc;

import fun.hydropixel.common.npc.HydropixelNpc;
import fun.hydropixel.common.npc.NpcDefinition;
import fun.hydropixel.common.npc.NpcManager;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.instance.Instance;

public final class LobbyNpcManager {

    private final Instance instance;
    private final NpcManager<HydropixelNpc> npcs = new NpcManager<>();

    public LobbyNpcManager(Instance instance) {
        this.instance = instance;
    }

    public void spawnDefaults() {
        register(new SkyblockNPC(instance));
        register(new HydropixelStoreNPC(instance));
    }

    /**
     * Register any NpcDefinition — creates an HydropixelNpc and spawns it.
     */
    public void register(NpcDefinition definition) {
        npcs.register(new HydropixelNpc(definition));
    }

    public void registerListeners(GlobalEventHandler handler) {
        npcs.registerListeners(handler);
    }
}
