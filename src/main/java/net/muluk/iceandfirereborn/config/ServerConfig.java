package net.muluk.iceandfirereborn.config;

import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class ServerConfig {

    public final ForgeConfigSpec.IntValue SeaSerpentArmorEffectStrengthLevel;
    public ForgeConfigSpec.ConfigValue<List<? extends String>> BlacklistedGorgonEntities;

    public ServerConfig(final ForgeConfigSpec.Builder builder) {
        builder.push("Armor Effects");
        this.SeaSerpentArmorEffectStrengthLevel = buildInt(builder, "SeaSerpent Armor Strength Effect Level", "all", 0, 0, 3, "Strength effect level granted when fully wearing Sea Serpent Armor, 0 = Strength I, 1 = Strength II, etc.");
        builder.pop();
        builder.push("Items");
        BlacklistedGorgonEntities = builder
                .comment("Entities that cannot be petrified by Gorgons")
                .defineList("blacklisted Gorgon Entites", Lists.newArrayList(), o -> o instanceof String);
        builder.pop();
    }

    private static ForgeConfigSpec.BooleanValue buildBoolean(ForgeConfigSpec.Builder builder, String name, String catagory, boolean defaultValue, String comment){
        return builder.comment(comment).translation(name).define(name, defaultValue);
    }

    private static ForgeConfigSpec.IntValue buildInt(ForgeConfigSpec.Builder builder, String name, String catagory, int defaultValue, int min, int max, String comment){
        return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
    }

    private static ForgeConfigSpec.DoubleValue buildDouble(ForgeConfigSpec.Builder builder, String name, String catagory, double defaultValue, double min, double max, String comment){
        return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
    }
}