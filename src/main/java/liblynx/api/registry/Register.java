package liblynx.api.registry;

import java.util.ArrayList;
import java.util.List;

public abstract class Register<T> {

    private List<T> items = new ArrayList<>();

    public void addItem(T item){
        items.add(item);
    }

    public T getItem(int id){
        return items.get(id);
    }

    public List<T> getItems(){
        return items;
    }

    public void addDefaults(){ }
}
