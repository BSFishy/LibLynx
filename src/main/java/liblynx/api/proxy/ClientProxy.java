package liblynx.api.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class ClientProxy extends CommonProxy {

    @Override
    public abstract void preInit(FMLPreInitializationEvent e);

    @Override
    public void init(FMLInitializationEvent e){
        // NOTHING; API
    }

    @Override
    public void postInit(FMLPostInitializationEvent e){
        // NOTHING; API
    }
}
