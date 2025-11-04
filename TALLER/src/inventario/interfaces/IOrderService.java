package inventario.interfaces;


import inventario.model.Order;

/**
 * Define las funcionalidades de creación y administración de órdenes.
 */
public interface IOrderService {

    /**
     * Crea una nueva orden y la almacena en el sistema.
     */
    void createOrder(Order order);
}
