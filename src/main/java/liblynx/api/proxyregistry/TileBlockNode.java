package liblynx.api.proxyregistry;

import liblynx.api.ModRegistry;
import liblynx.api.block.BlockBase;
import liblynx.api.proxy.CommonProxy;
import liblynx.api.tile.TileBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TileBlockNode implements IRegistryNode {

    private BlockBase block;
    private TileBase tile;
    private Map<Integer, ModelResourceLocation> resources = new HashMap<>();
    private List<NodeRecipe> recipes = new ArrayList<>();

    public TileBlockNode() {}

    public TileBlockNode(BlockBase block, TileBase tile){
        this.block = block;
        this.tile = tile;
    }

    public TileBlockNode(BlockBase block, TileBase tile, NodeRecipe recipe){
        this(block, tile);
        recipes.add(recipe);
    }

    public TileBlockNode(BlockBase block, TileBase tile, List<NodeRecipe> recipes){
        this(block, tile);
        recipes.forEach(r -> this.recipes.add(r));
    }

    public TileBlockNode(BlockBase block, TileBase tile, Map<Integer, ModelResourceLocation> resources){
        this(block, tile);
        resources.forEach((i, r) -> this.resources.put(i, r));
    }

    public TileBlockNode(BlockBase block, TileBase tile, ResourceLocationWithDamage withDamage){
        this(block, tile);
        resources.put(withDamage.getDamage(), withDamage.getResource());
    }

    public TileBlockNode(BlockBase block, TileBase tile, int damage, ModelResourceLocation location){
        this(block, tile);
        resources.put(damage, location);
    }

    public TileBlockNode(BlockBase block, TileBase tile, Map<Integer, ModelResourceLocation> resources, NodeRecipe recipe){
        this(block, tile);
        resources.forEach((i, r) -> this.resources.put(i, r));
        recipes.add(recipe);
    }

    public TileBlockNode(BlockBase block, TileBase tile, ResourceLocationWithDamage withDamage, NodeRecipe recipe){
        this(block, tile);
        resources.put(withDamage.getDamage(), withDamage.getResource());
        recipes.add(recipe);
    }

    public TileBlockNode(BlockBase block, TileBase tile, int damage, ModelResourceLocation location, NodeRecipe recipe){
        this(block, tile);
        resources.put(damage, location);
        recipes.add(recipe);
    }

    public TileBlockNode(BlockBase block, TileBase tile, Map<Integer, ModelResourceLocation> resources, List<NodeRecipe> recipes){
        this(block, tile);
        resources.forEach((i, r) -> this.resources.put(i, r));
        recipes.forEach(r -> this.recipes.add(r));
    }

    public TileBlockNode(BlockBase block, TileBase tile, ResourceLocationWithDamage withDamage, List<NodeRecipe> recipes){
        this(block, tile);
        resources.put(withDamage.getDamage(), withDamage.getResource());
        recipes.forEach(r -> this.recipes.add(r));
    }

    public TileBlockNode(BlockBase block, TileBase tile, int damage, ModelResourceLocation location, List<NodeRecipe> recipes){
        this(block, tile);
        resources.put(damage, location);
        recipes.forEach(r -> this.recipes.add(r));
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

    public TileBase getTile(){
        return tile;
    }

    public void setTile(TileBase tile){
        this.tile = tile;
    }

    public BlockBase getBlock(){
        return block;
    }

    public void setBlock(BlockBase block){
        this.block = block;
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
        if(resources != null)
            resources.forEach((d, r) -> ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), d, r));
    }

    @Override
    public void commonPreInit(){
        if(tile != null && block != null)
            CommonProxy.registerTile(tile.getClass(), block.getUnlocalizedName());
        if(block != null)
            CommonProxy.registerBlock(block);
        if(recipes != null)
            recipes.forEach(GameRegistry::addRecipe);
    }

    @Override
    public void clientInit() {

    }

    @Override
    public void commonInit(){

    }
}
