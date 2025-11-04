package inventario.service;

import inventario.model.Order;
import java.util.logging.Logger;
import inventario.interfaces.IOrderRepository;
import inventario.interfaces.IOrderService;

/**
 * Servicio para la gestión de órdenes de compra.
 *
 * Mantiene alta cohesión al gestionar exclusivamente
 * la lógica del ciclo de vida de las órdenes.
 */
public class OrderServiceImpl implements IOrderService {

    private static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class.getName());
    private final IOrderRepository orderRepository;

    public OrderServiceImpl(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(Order order) {
        if (order == null) {
            LOGGER.warning("Cannot create order: order is null.");
            return;
        }

        orderRepository.saveOrder(order);
        LOGGER.info("Order saved successfully.");
    }
}
