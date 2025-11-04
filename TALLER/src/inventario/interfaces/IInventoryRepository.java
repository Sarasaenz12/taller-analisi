package inventario.interfaces;

import inventario.model.Product;

/**
 * Define las operaciones de acceso a datos relacionadas con el inventario.
 * Esta interfaz permite desacoplar la capa de datos de la lógica del negocio,
 * eliminando el uso de estructuras sin modelo de dominio y evitando antipatrones
 * como God Object y Spaghetti Code.
 */
public interface IInventoryRepository {

    /**
     * Busca un producto por su identificador.
     */
    Product findProductById(String productId);

    /**
     * Guarda o actualiza un producto en el inventario.
     */
    void saveProduct(Product product);
}
