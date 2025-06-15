package better_end_sky;

import better_end_sky.render.EndSkyRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod("better_end_sky")
public class BetterEndSkyMod {

    public BetterEndSkyMod() {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> this::clientSetup);
    }

    private void clientSetup() {
        if (ModList.get().isLoaded("betterend")) return;
        MinecraftForge.EVENT_BUS.register(new EndSkyRenderer());
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation("better_end_sky", path);
    }
}
