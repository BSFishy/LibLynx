package liblynx.api.proxyregistry;

import liblynx.api.item.CraftingItemBase;
import liblynx.api.item.ItemBase;
import liblynx.api.proxy.CommonProxy;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemNode implements IRegistryNode {

    private ItemBase item;
    private Map<Integer, ModelResourceLocation> resources = new HashMap<>();
    private List<NodeRecipe> recipes = new ArrayList<>();

    public ItemNode() {}

    public ItemNode(ItemBase item){
        this.item = item;
    }

    public ItemNode(ItemBase item, Map<Integer, ModelResourceLocation> resources){
        this(item);
        this.resources = resources;
    }

    public ItemNode(ItemBase item, int d, ModelResourceLocation r){
        this(item);
        resources.put(d, r);
    }

    public ItemNode(ItemBase item, ResourceLocationWithDamage rlwd){
        this(item);
        resources.put(rlwd.getDamage(), rlwd.getResource());
    }

    public ItemNode(ItemBase item, List<NodeRecipe> recipes){
        this(item);
        recipes.forEach(r -> this.recipes.add(r));
    }

    public ItemNode(ItemBase item, NodeRecipe r){
        this(item);
        recipes.add(r);
    }

    public ItemNode(ItemBase item, Map<Integer, ModelResourceLocation> resources, List<NodeRecipe> recipes){
        this(item);
        this.resources = resources;
        recipes.forEach(r -> this.recipes.add(r));
    }

    public ItemNode(ItemBase item, int d, ModelResourceLocation r, List<NodeRecipe> recipes){
        this(item);
        resources.put(d, r);
        recipes.forEach(rc -> this.recipes.add(rc));
    }

    public ItemNode(ItemBase item, ResourceLocationWithDamage rlwd, List<NodeRecipe> recipes){
        this(item);
        resources.put(rlwd.getDamage(), rlwd.getResource());
        recipes.forEach(r -> this.recipes.add(r));
    }

    public ItemNode(ItemBase item, Map<Integer, ModelResourceLocation> resources, NodeRecipe r){
        this(item);
        this.resources = resources;
        recipes.add(r);
    }

    public ItemNode(ItemBase item, int d, ModelResourceLocation l, NodeRecipe r){
        this(item);
        resources.put(d, l);
        recipes.add(r);
    }

    public ItemNode(ItemBase item, ResourceLocationWithDamage rlwd, NodeRecipe r){
        this(item);
        resources.put(rlwd.getDamage(), rlwd.getResource());
        recipes.add(r);
    }

    public void addResource(int damage, ModelResourceLocation location){
        resources.put(damage, location);
    }

    public void addResource(ResourceLocationWithDamage withDamage){
        resources.put(withDamage.getDamage(), withDamage.getResource());
    }

    public void addResource(Map<Integer, ModelResourceLocation> resources){
        resources.forEach((i, r) -> this.resources.put(i, r));
    }

    public Map<Integer, ModelResourceLocation> getResources(){
        return resources;
    }

    public void setResources(Map<Integer, ModelResourceLocation> resources){
        this.resources = resources;
    }

    public ItemBase getItem(){
        return item;
    }

    public void setItem(ItemBase item){
        this.item = item;
    }

    public List<NodeRecipe> getRecipes(){
        return recipes;
    }

    public void addRecipe(NodeRecipe recipe){
        recipes.add(recipe);
    }

    public void addRecipes(List<NodeRecipe> recipes){
        recipes.forEach(r -> this.recipes.add(r));
    }

    @Override
    public void clientPreInit() {
        if(!resources.isEmpty()) {
            if (resources.size() > 1) {
                resources.forEach((d, r) -> ModelBakery.registerItemVariants(item, r));
            }
            resources.forEach((d, r) -> ModelLoader.setCustomModelResourceLocation(item, d, r));
        }
    }

    @Override
    public void commonPreInit() {
        if(item != null)
            CommonProxy.registerItem(item);
        if(recipes != null)
            recipes.forEach(GameRegistry::addRecipe);
        else if (item instanceof CraftingItemBase)
            GameRegistry.addRecipe(((CraftingItemBase) item).getRecipe());
    }

    @Override
    public void clientInit() {

    }

    @Override
    public void commonInit() {

    }
}
