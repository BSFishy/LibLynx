package liblynx.api.item;

import liblynx.api.ModRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class ItemBase extends Item {
    private String name;

    public ItemBase(String name) {
        this.name = name;

        setRegistryName(ModRegistry.MODID, name);
        //setCreativeTab(ModRegistry.MOD.INSTANCE.tab);
    }

    @Override
    public String getUnlocalizedName() {
        return "item." + ModRegistry.MODID + ":" + name;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        if (getHasSubtypes()) {
            return getUnlocalizedName() + "." + stack.getItemDamage();
        }

        return getUnlocalizedName();
    }
}
