package io.github.killerjdog51.biome_enhancments;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import io.github.killerjdog51.biome_enhancments.entity.boat.ModBoatEntity;
import io.github.killerjdog51.biome_enhancments.entity.boat.ModBoatRenderer;
import io.github.killerjdog51.biome_enhancments.init.WorldGeneration;
import io.github.killerjdog51.biome_enhancments.tileentity.ModSignTileEntity;
import io.github.killerjdog51.biome_enhancments.tileentity.ModSignTileEntityRenderer;
import io.github.killerjdog51.biome_enhancments.util.BlockColorHandler;
import io.github.killerjdog51.biome_enhancments.util.BlockFlammableHandler;
import io.github.killerjdog51.biome_enhancments.util.FlowerPotHandler;
import io.github.killerjdog51.biome_enhancments.util.RegistryHandler;
import io.github.killerjdog51.biome_enhancments.util.StrippedLogHandler;
import net.minecraftforge.common.BiomeDictionary.Type;


@Mod(BiomeEnhancements.MOD_ID)
public class BiomeEnhancements
{
    // Directly reference a log4j logger.
    public static final String MOD_ID = "biome_enhancements";

    public BiomeEnhancements()
    {
        // Register blocks and Items
        RegistryHandler.init();
        
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register color handlers
        FMLJavaModLoadingContext.get().getModEventBus().register(new BlockColorHandler());

        // Make Blocks Flammable
        BlockFlammableHandler.init();
        
        // Register events
        MinecraftForge.EVENT_BUS.register(new FlowerPotHandler());
        MinecraftForge.EVENT_BUS.register(new StrippedLogHandler());
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	WorldGeneration.init();
    	WorldGeneration.registerBiome(WorldGeneration.OASIS, Type.DRY);
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
		ClientRegistry.bindTileEntitySpecialRenderer(ModSignTileEntity.class, new ModSignTileEntityRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModBoatEntity.class, ModBoatRenderer::new);

    }

}
