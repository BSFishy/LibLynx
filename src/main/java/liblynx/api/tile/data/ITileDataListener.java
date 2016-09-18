package liblynx.api.tile.data;

public interface ITileDataListener<T> {
    void onChanged(TileDataParameter<T> parameter);
}
