package inventario.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una orden de compra en el sistema.
 *
 * Mejora el diseño anterior eliminando el uso de Strings mal formados
 * y evitando antipatrones como Low Cohesion y Spaghetti Code.
 */
public class Order {

    private final List<OrderItem> items = new ArrayList<>();

    /**
     * Agrega un producto a la orden.
     *
     * @param item Elemento que representa producto y cantidad.
     * @throws IllegalArgumentException si el item es nulo.
     */
    public void addItem(OrderItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Order item cannot be null.");
        }
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
