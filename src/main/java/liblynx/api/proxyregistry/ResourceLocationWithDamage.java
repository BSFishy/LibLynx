package liblynx.api.proxyregistry;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class ResourceLocationWithDamage {

    private int damage;
    private ModelResourceLocation location;

    public ResourceLocationWithDamage(int damage, ModelResourceLocation location){
        this.damage = damage;
        this.location = location;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return damage;
    }

    public void setResource(ModelResourceLocation location){
        this.location = location;
    }

    public ModelResourceLocation getResource(){
        return location;
    }
}
