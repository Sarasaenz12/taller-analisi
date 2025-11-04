package inventario.interfaces;

/**
 * Define los servicios relacionados con la gestión del inventario.
 */
public interface IInventoryService {

    /**
     * Agrega una cantidad al stock de un producto.
     *
     */
    void addProduct(String productId, int quantity);

    /**
     * Obtiene el stock disponible para un producto.
     */
    int getStock(String productId);
}
