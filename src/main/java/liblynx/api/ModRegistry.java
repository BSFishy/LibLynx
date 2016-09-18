package liblynx.api;

import liblynx.api.proxy.CommonProxy;

public class ModRegistry {

    public static String MODID;
    public static ModBase MOD;
    public static CommonProxy PROXY;

    private ModRegistry() { }

    public static void setMODID(String modid){
        MODID = modid;
    }

    public static void setMOD(ModBase mod){
        MOD = mod;
    }

    public static void setPROXY(CommonProxy proxy){
        PROXY = proxy;
    }
}
