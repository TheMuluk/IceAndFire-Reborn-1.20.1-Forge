package net.muluk.iceandfirereborn;

import com.google.common.collect.Lists;
import net.minecraftforge.fml.config.ModConfig;
import net.muluk.iceandfirereborn.config.ConfigHolder;

import java.util.List;

public class IceAndFireRebornConfig {

    public static int SeaSerpentArmorEffectStrengthLevel = 0;
    public static List<? extends String> blacklistedBreakBlocks = Lists.newArrayList();

    public static void bakeServer(final ModConfig config) {
        try {
            SeaSerpentArmorEffectStrengthLevel = ConfigHolder.SERVER.SeaSerpentArmorEffectStrengthLevel.get();
            blacklistedBreakBlocks = ConfigHolder.SERVER.BlacklistedGorgonEntities.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}