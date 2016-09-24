package liblynx.api.proxyregistry;

import liblynx.api.block.BlockBase;
import liblynx.api.item.ItemBase;
import liblynx.api.tile.TileBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class RegistryNodeGraph {

    private List<TileBlockNode> blocks = new ArrayList<>();
    private List<ItemNode> items = new ArrayList<>();

    public RegistryNodeGraph(){}

    public void addBlock(TileBlockNode block){
        blocks.add(block);
    }

    public void addBlock(BlockBase block, TileBase tile, int damage, ModelResourceLocation location, NodeRecipe recipe){
        blocks.add(new TileBlockNode(block, tile, damage, location, recipe));
    }

    public void addItem(ItemNode item){
        items.add(item);
    }

    public void addItem(ItemBase item, int d, ModelResourceLocation l, NodeRecipe r){
        items.add(new ItemNode(item, d, l, r));
    }

    public List<TileBlockNode> getBlocks(){
        return blocks;
    }

    public List<ItemNode> getItems(){
        return items;
    }

    public void commonPreInit(){
        items.forEach(ItemNode::commonPreInit);
        blocks.forEach(TileBlockNode::commonPreInit);
    }

    public void clientPreInit(){
        items.forEach(ItemNode::clientPreInit);
        blocks.forEach(TileBlockNode::clientPreInit);
    }

    public void commmonInit(){
        items.forEach(ItemNode::commonInit);
        blocks.forEach(TileBlockNode::commonInit);
    }

    public void clientInit(){
        items.forEach(ItemNode::clientInit);
        blocks.forEach(TileBlockNode::clientInit);
    }
}
