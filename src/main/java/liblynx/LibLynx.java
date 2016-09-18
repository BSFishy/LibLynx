package liblynx;

import net.minecraftforge.fml.common.Mod;

@Mod(modid = LibLynx.ID, version = LibLynx.VERSION, dependencies = LibLynx.DEPENDENCIES, guiFactory = LibLynx.GUI_FACTORY)
public class LibLynx {

    public static final String ID = "${modid}";
    public static final String VERSION = "${version}";
    public static final String DEPENDENCIES = "required-after:Forge@[12.18.1.2088,);required-after:mcmultipart@[1.2.1,);";
    public static final String GUI_FACTORY = "";

}
