package fun.hydropixel.skyblock.cmds.impl;

import fun.hydropixel.skyblock.player.SkyblockPlayer;
import fun.hydropixel.skyblock.player.skill.SkillType;
import fun.hydropixel.skyblock.player.skill.gui.SkillDetailMenu;
import fun.hydropixel.skyblock.player.skill.gui.SkillOverviewMenu;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.command.builder.arguments.ArgumentWord;

import java.util.Locale;

import static fun.hydropixel.common.StringUtility.text;

public class SkillsCommand extends Command {

    public SkillsCommand() {
        super("skills", "skill");

        setDefaultExecutor((sender, ctx) -> {
            if (!(sender instanceof SkyblockPlayer player)) return;
            SkillOverviewMenu.open(player);
        });

        ArgumentWord skillArg = ArgumentType.Word("skill");

        addSyntax((sender, ctx) -> {
            if (!(sender instanceof SkyblockPlayer player)) return;

            String input = ctx.get(skillArg).toUpperCase(Locale.ROOT);
            SkillType type;
            try {
                type = SkillType.valueOf(input);
            } catch (IllegalArgumentException e) {
                player.sendMessage(text("<red>Unknown skill: <white>" + ctx.get(skillArg)));
                return;
            }

            SkillDetailMenu.open(player, type, 0);
        }, skillArg);
    }
}
