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

    public static final String ID = "${modid}";
    public static final String VERSION = "${version}";
    public static final String DEPENDENCIES = "required-after:Forge@[12.18.1.2088,);required-after:mcmultipart@[1.2.1,);";
    public static final String GUI_FACTORY = "";

    @SidedProxy(clientSide = "liblynx.apiimpl.proxy.LibLynxClientProxy", serverSide = "liblynx.apiimpl.proxy.LibLynxServerProxy")
    public LibLynxCommonProxy PROXY;

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        ModRegistry.setMODID(ID);
        ModRegistry.setMOD(INSTANCE);

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
