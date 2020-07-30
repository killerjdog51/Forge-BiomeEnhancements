package io.github.killerjdog51.biome_enhancments;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import io.github.killerjdog51.biome_enhancments.init.WorldGeneration;
import io.github.killerjdog51.biome_enhancments.util.BlockColorHandler;
import io.github.killerjdog51.biome_enhancments.util.FlowerPotHandler;
import io.github.killerjdog51.biome_enhancments.util.RegistryHandler;
import io.github.killerjdog51.biome_enhancments.util.StrippedLogHandler;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;


@Mod(BiomeEnhancements.MOD_ID)
public class BiomeEnhancements
{
    // Directly reference a log4j logger.
    public static final String MOD_ID = "biome_enhancements";

    public BiomeEnhancements()
    {
        // Register the setup method for modloading
    	
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        FMLJavaModLoadingContext.get().getModEventBus().register(new BlockColorHandler());

        //register blocks and Items
        RegistryHandler.init();
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(new FlowerPotHandler());
        MinecraftForge.EVENT_BUS.register(new StrippedLogHandler());
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	WorldGeneration.init();
    	WorldGeneration.registerBiome(WorldGeneration.OASIS, 5, BiomeType.DESERT, Type.DRY);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
       
    }

}
