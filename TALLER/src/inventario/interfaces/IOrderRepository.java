package inventario.interfaces;

import inventario.model.Order;

/**
 * Interfaz que abstrae la gestión de almacenamiento de órdenes.
 *
 * Colabora en eliminar el antipatrón Low Cohesion al estructurar
 * correctamente el manejo de pedidos.
 */
public interface IOrderRepository {

    /**
     * Guarda una nueva orden en el repositorio.
     *
     * @param order Orden a registrar.
     */
    void saveOrder(Order order);
}