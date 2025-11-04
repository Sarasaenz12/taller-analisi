package inventario.service;

import inventario.model.Product;
import java.util.logging.Logger;
import inventario.interfaces.IInventoryRepository;
import inventario.interfaces.ISaleService;

/**
 * Servicio responsable del registro de ventas.
 * Separa la lógica que anteriormente estaba mezclada en una misma clase
 * (eliminando God Object y Spaghetti Code).
 */
public class SaleServiceImpl implements ISaleService {

    private static final Logger LOGGER = Logger.getLogger(SaleServiceImpl.class.getName());
    private final IInventoryRepository inventoryRepository;

    public SaleServiceImpl(IInventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public boolean registerSale(String productId, int quantity) {
        Product product = inventoryRepository.findProductById(productId);

        if (product == null) {
            LOGGER.warning("Sale failed: Product not found.");
            return false;
        }

        if (product.deductStock(quantity)) {
            inventoryRepository.saveProduct(product);
            LOGGER.info("Sale registered: " + productId + " | Quantity: " + quantity);
            return true;
        }

        LOGGER.warning("Sale failed: Insufficient stock for product " + productId);
        return false;
    }
}

