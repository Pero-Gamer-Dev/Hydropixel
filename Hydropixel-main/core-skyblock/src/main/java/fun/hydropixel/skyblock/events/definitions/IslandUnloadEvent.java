package fun.hydropixel.skyblock.events.definitions;

import fun.hydropixel.skyblock.island.Island;
import net.minestom.server.event.Event;

public record IslandUnloadEvent(Island island) implements Event {
}
