package net.muluk.iceandfirereborn;


import com.github.alexthe666.iceandfire.event.ServerEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.muluk.iceandfirereborn.config.ConfigHolder;


@Mod.EventBusSubscriber(modid = IceAndFireReborn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent.Loading event) {
        final ModConfig config = event.getConfig();

        if (config.getSpec() == ConfigHolder.SERVER_SPEC) {
            IceAndFireRebornConfig.bakeServer(config);
        }
    }

    public static void onModConfigChanged(final ModConfigEvent.Reloading event) {

    }


    public void setup() {
        MinecraftForge.EVENT_BUS.register(new ServerEvents());
    }

    public void clientInit() {
    }
}