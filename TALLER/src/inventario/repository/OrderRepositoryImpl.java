package inventario.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import inventario.interfaces.IOrderRepository;
import inventario.model.Order;
/**
 * Repositorio para la gestión de órdenes utilizando almacenamiento en memoria.
 *
 * Este diseño cumple con SRP y evita el antipatrón Low Cohesion
 * al definir una única responsabilidad claramente delimitada.
 */
public class OrderRepositoryImpl implements IOrderRepository {

    private static final Logger LOGGER = Logger.getLogger(OrderRepositoryImpl.class.getName());
    private final List<Order> orderStorage = new ArrayList<>();

    @Override
    public void saveOrder(Order order) {
        if (order == null) {
            LOGGER.warning("Cannot save null order.");
            return;
        }
        orderStorage.add(order);
        LOGGER.info("Order saved successfully.");
    }

    /**
     * Método de apoyo para debugging y pruebas.
     *
     * @return Lista de órdenes en memoria.
     */
    public List<Order> getAllOrders() {
        return orderStorage;
    }
}
