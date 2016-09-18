package liblynx.api.proxyregistry;

public interface IRegistryNode {

    void clientPreInit();

    void commonPreInit();

    void clientInit();

    void commonInit();
}
