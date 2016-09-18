package liblynx.api.proxy;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class CommonProxy {

    public abstract void preInit(FMLPreInitializationEvent e);

    public abstract void init(FMLInitializationEvent e);

    public abstract void postInit(FMLPostInitializationEvent e);

/*    private void registerBlock(Block block) {
        GameRegistry.register(block);
        GameRegistry.register(block.createItem());
    }

    private void registerTile(Class<? extends TileBase> tile, String id, String modid) {
        GameRegistry.registerTileEntity(tile, modid + ":" + id);

        try {
            TileBase tileInstance = tile.newInstance();

            tileInstance.getDataManager().getParameters().forEach(TileDataManager::registerParameter);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void registerItem(Item item) {
        GameRegistry.register(item);
    }*/
}
