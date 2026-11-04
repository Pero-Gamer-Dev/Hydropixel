package fun.hydropixel.skyblock.cmds.impl;

import fun.hydropixel.skyblock.Main;
import net.minestom.server.command.builder.Command;

public class StopCommand extends Command {

    public StopCommand() {
        super("stop");

        setDefaultExecutor((_,_) -> {
            //TODO: Add Admin Check;
            Main.shutdown();
        });
    }
}
