package inventario.service;

import inventario.interfaces.IEmailService;
import inventario.model.Order;
import java.util.logging.Logger;

/**
 * Implementación del servicio de envío de notificaciones.
 *
 * Cumple con el principio DIP desacoplando totalmente el envío
 * de cualquier cliente que requiera notificaciones.
 */
public class EmailServiceImpl implements IEmailService {

    private static final Logger LOGGER = Logger.getLogger(EmailServiceImpl.class.getName());

    @Override
    public void sendOrderConfirmation(String email, Order order) {
        if (email == null || email.isBlank() || order == null) {
            LOGGER.warning("Email or order invalid. Cannot send notification.");
            return;
        }

        LOGGER.info("Order confirmation sent to: " + email);
    }
}

