package inventario.interfaces;

/**
 * Define los servicios relacionados con el registro de ventas,
 * eliminando lógica mezclada del inventario original.
 */
public interface ISaleService {

    /**
     * Registra una venta en el sistema.
     *
     * @param productId Identificador del producto.
     * @param quantity  Cantidad vendida.
     * @return true si la venta se registra exitosamente, false si no hay stock suficiente.
     */
    boolean registerSale(String productId, int quantity);
}
