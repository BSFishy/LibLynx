package liblynx.api;

public class ModRegistry {

    public static String MODID;
    public static ModBase MOD;

    private ModRegistry() { }

    public static void setMODID(String modid){
        MODID = modid;
    }

    public static void setMOD(ModBase mod){
        MOD = mod;
    }
}
