package inventario.model;

/**
 * Representa un elemento dentro de una orden,
 * permitiendo manejar múltiples productos por pedido.
 *
 * Ayuda a mejorar la cohesión del sistema al separar responsabilidades
 * que anteriormente estaban mezcladas en cadenas de texto sin estructura.
 */
public class OrderItem {

    private String productId;
    private int quantity;

    /**
     * @param productId Identificador del producto.
     * @param quantity  Cantidad asociada a ese producto.
     */
    public OrderItem(String productId, int quantity) {
        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
