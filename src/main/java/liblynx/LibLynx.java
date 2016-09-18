package liblynx;

import liblynx.api.ModBase;
import liblynx.api.ModRegistry;
import liblynx.apiimpl.proxy.LibLynxCommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LibLynx.ID, version = LibLynx.VERSION, dependencies = LibLynx.DEPENDENCIES, guiFactory = LibLynx.GUI_FACTORY)
public class LibLynx extends ModBase {

    public static final String ID = "@GROUP@";
    public static final String VERSION = "@VERSION@";
    public static final String DEPENDENCIES = "required-after:Forge@[12.18.1.2088,)";
    public static final String GUI_FACTORY = "";

    @SidedProxy(clientSide = "liblynx.apiimpl.proxy.LibLynxClientProxy", serverSide = "liblynx.apiimpl.proxy.LibLynxServerProxy")
    public static LibLynxCommonProxy PROXY;

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        ModRegistry.setMODID(ID);
        ModRegistry.setMOD(INSTANCE);
        ModRegistry.setPROXY(PROXY);

        PROXY.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        PROXY.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        PROXY.postInit(e);
    }
}
