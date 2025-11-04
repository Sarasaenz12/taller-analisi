package inventario.model;


/**
 * Representa un producto dentro del inventario.
 * Esta clase sustituye la mala práctica del uso de Maps con datos sueltos,
 * implementando un modelo de dominio real que encapsula el estado y las
 * reglas del producto. Evita antipatrones como Hard Code, Temporary Field
 * y falta de dominio.
 */
public class Product {

    private String id;
    private int stock;

    /**
     * Constructor para crear un nuevo producto.
     */
    public Product(String id, int stock) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative.");
        }
        this.id = id;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    /**
     * Aumenta el stock del producto.
     */
    public void addStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        this.stock += quantity;
    }

    /**
     * Resta stock del producto si es suficiente.
     */
    public boolean deductStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        if (stock >= quantity) {
            stock -= quantity;
            return true;
        }
        return false;
    }
}
