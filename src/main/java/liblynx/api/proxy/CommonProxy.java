package liblynx.api.proxy;

import liblynx.api.ModRegistry;
import liblynx.api.block.BlockBase;
import liblynx.api.item.ItemBase;
import liblynx.api.tile.TileBase;
import liblynx.api.tile.data.TileDataManager;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class CommonProxy {

    public void preInit(FMLPreInitializationEvent e){
        ModRegistry.MOD.REGISTRYNODEGRAPH.commonPreInit();
    }

    public void init(FMLInitializationEvent e){
        ModRegistry.MOD.REGISTRYNODEGRAPH.commmonInit();
    }

    public void postInit(FMLPostInitializationEvent e) { }

    public static void registerBlock(BlockBase block) {
        GameRegistry.register(block);
        GameRegistry.register(block.createItem());
    }

    public static void registerTile(Class<? extends TileBase> tile, String id) {
        GameRegistry.registerTileEntity(tile, ModRegistry.MODID + ":" + id);

        try {
            TileBase tileInstance = tile.newInstance();

            tileInstance.getDataManager().getParameters().forEach(TileDataManager::registerParameter);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void registerItem(ItemBase item) {
        GameRegistry.register(item);
    }
}
