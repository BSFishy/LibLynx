package liblynx.api.item;

import liblynx.api.proxyregistry.NodeRecipe;

public abstract class CraftingItemBase extends ItemBase {
    public CraftingItemBase(String name) {
        super(name);
    }

    public abstract NodeRecipe getRecipe();
}
