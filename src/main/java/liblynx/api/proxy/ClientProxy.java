package liblynx.api.proxy;

import liblynx.api.ModRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e){
        ModRegistry.MOD.REGISTRYNODEGRAPH.clientPreInit();
    }

    @Override
    public void init(FMLInitializationEvent e){
        ModRegistry.MOD.REGISTRYNODEGRAPH.clientInit();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e){
        // NOTHING; API
    }
}
