package liblynx.apiimpl.proxy;


import liblynx.api.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class LibLynxCommonProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        // NOTHING; API
    }

    public void init(FMLInitializationEvent e) {
        // NOTHING; API
    }

    public void postInit(FMLPostInitializationEvent e) {
        // NOTHING; API
    }

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
