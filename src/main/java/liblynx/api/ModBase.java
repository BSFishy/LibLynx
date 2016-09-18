package liblynx.api;

import liblynx.api.proxy.CommonProxy;
import liblynx.api.proxyregistry.RegistryNodeGraph;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public abstract class ModBase {

    @Instance
    public static ModBase INSTANCE;
    public RegistryNodeGraph REGISTRYNODEGRAPH;

    @EventHandler
    public abstract void preInit(FMLPreInitializationEvent e);

    @EventHandler
    public abstract void init(FMLInitializationEvent e);

    @EventHandler
    public abstract void postInit(FMLPostInitializationEvent e);
}
