package inventario.interfaces;


import inventario.model.Order;

/**
 * Servicio encargado del envío de confirmaciones o notificaciones por correo.
 *
 * Uso aplicado del principio de inversión d
 * e dependencias (DIP),
 * evitando acoplamiento directo con la infraestructura.
 */
public interface IEmailService {

    /**
     * Envía un correo con la confirmación de la orden.
     *
     * @param email Dirección de correo del destinatario.
     * @param order Orden asociada a la notificación.
     */
    void sendOrderConfirmation(String email, Order order);
}
