package fun.hydropixel.skyblock.menus.command;

import fun.hydropixel.skyblock.player.SkyblockPlayer;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.command.builder.arguments.ArgumentWord;

import static fun.hydropixel.common.StringUtility.text;

public class GuiCommand extends Command {

    public GuiCommand() {
        super("opengui");

        ArgumentWord guiArg = ArgumentType.Word("guiName");

        addSyntax((sender, ctx) -> {
            if (!(sender instanceof SkyblockPlayer player)) {
                sender.sendMessage("This command is for players only.");
                return;
            }

            String guiName = ctx.get(guiArg);
            String[] packages = {
                "fun.hydropixel.skyblock.menus.",
                "fun.hydropixel.skyblock.player.skill.gui.",
                "fun.hydropixel.skyblock.player.collections.gui.",
                "fun.hydropixel.skyblock.menus.command.blockGui.",
                "fun.hydropixel.skyblock.menus.command.skyblockMenu."
            };

            boolean found = false;
            for (String pkg : packages) {
                try {
                    Class<?> clazz = Class.forName(pkg + guiName);
                    java.lang.reflect.Method openMethod = clazz.getMethod("open", SkyblockPlayer.class);
                    openMethod.invoke(null, player);
                    player.sendMessage(text("<green>Opened GUI: <white>" + guiName));
                    found = true;
                    break;
                } catch (ClassNotFoundException ignored) {
                } catch (NoSuchMethodException e) {
                    player.sendMessage(text("<red>GUI " + guiName + " does not have a static open(SkyblockPlayer) method."));
                    found = true;
                    break;
                } catch (Exception e) {
                    player.sendMessage(text("<red>Error opening GUI: " + e.getMessage()));
                    e.printStackTrace();
                    found = true;
                    break;
                }
            }

            if (!found) {
                player.sendMessage(text("<red>GUI " + guiName + " not found."));
            }
        }, guiArg);
    }
}

