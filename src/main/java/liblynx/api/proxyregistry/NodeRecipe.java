package liblynx.api.proxyregistry;

import net.minecraft.block.Block;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class NodeRecipe extends ShapedOreRecipe {
    public NodeRecipe(Block result, Object... recipe) {
        super(result, recipe);
    }
}
