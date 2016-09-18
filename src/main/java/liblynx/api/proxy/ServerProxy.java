package liblynx.api.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class ServerProxy extends CommonProxy {

    @Override
    public abstract void preInit(FMLPreInitializationEvent e);

    @Override
    public abstract void init(FMLInitializationEvent e);

    @Override
    public abstract void postInit(FMLPostInitializationEvent e);
}
