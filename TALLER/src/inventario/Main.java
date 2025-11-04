package inventario;

import inventario.interfaces.IEmailService;
import inventario.interfaces.IInventoryRepository;
import inventario.interfaces.IInventoryService;
import inventario.interfaces.IOrderRepository;
import inventario.interfaces.IOrderService;
import inventario.interfaces.ISaleService;
import inventario.model.Order;
import inventario.model.OrderItem;
import inventario.repository.InventoryRepositoryImpl;
import inventario.repository.OrderRepositoryImpl;
import inventario.service.EmailServiceImpl;
import inventario.service.InventoryServiceImpl;
import inventario.service.OrderServiceImpl;
import inventario.service.SaleServiceImpl;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    // Logger en lugar de System.out.println
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        IInventoryRepository inventoryRepository = new InventoryRepositoryImpl();
        IOrderRepository orderRepository = new OrderRepositoryImpl();

        IInventoryService inventoryService = new InventoryServiceImpl(inventoryRepository);
        ISaleService saleService = new SaleServiceImpl(inventoryRepository);
        IOrderService orderService = new OrderServiceImpl(orderRepository);
        IEmailService emailService = new EmailServiceImpl();

        int option;

        do {
            LOGGER.info("""
                    ==== SISTEMA DE INVENTARIO ====
                    1. Agregar producto
                    2. Registrar venta
                    3. Crear orden
                    4. Consultar stock
                    5. Enviar confirmación de orden
                    0. Salir
                    Seleccione una opción:
                    """);

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (option) {
                    case 1 -> {
                        LOGGER.info("Ingrese ID del producto: ");
                        String pId = scanner.nextLine();
                        LOGGER.info("Cantidad: ");
                        int qty = scanner.nextInt();
                        scanner.nextLine();
                        inventoryService.addProduct(pId, qty);
                        LOGGER.info("Producto agregado correctamente.");
                    }
                    case 2 -> {
                        LOGGER.info("ID producto vendido: ");
                        String pId = scanner.nextLine();
                        LOGGER.info("Cantidad vendida: ");
                        int qty = scanner.nextInt();
                        scanner.nextLine();
                        saleService.registerSale(pId, qty);
                        LOGGER.info("Venta registrada correctamente.");
                    }
                    case 3 -> {
                        Order order = new Order();
                        String more;
                        do {
                            LOGGER.info("ID producto: ");
                            String pId = scanner.nextLine();
                            LOGGER.info("Cantidad: ");
                            int qty = scanner.nextInt();
                            scanner.nextLine();
                            order.addItem(new OrderItem(pId, qty));

                            LOGGER.info("¿Agregar otro producto? (s/n): ");
                            more = scanner.nextLine();
                        } while (more.equalsIgnoreCase("s"));
                        orderService.createOrder(order);
                        LOGGER.info("Orden creada correctamente.");
                    }
                    case 4 -> {
                        LOGGER.info("ID producto: ");
                        String pId = scanner.nextLine();
                        int stock = inventoryService.getStock(pId);
                        LOGGER.log(Level.INFO, "Stock actual: {0}", stock);
                    }
                    case 5 -> {
                        LOGGER.info("Correo destinatario: ");
                        String email = scanner.nextLine();
                        Order order = new Order();
                        order.addItem(new OrderItem("TEMP", 1)); // Simulación mínima
                        emailService.sendOrderConfirmation(email, order);
                        LOGGER.log(Level.INFO, "Confirmación enviada a: {0}", email);
                    }
                    case 0 -> LOGGER.info("Sistema finalizado correctamente.");
                    default -> LOGGER.warning("Opción inválida. Intente nuevamente.");
                }

            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error: Entrada inválida o fallo en la operación.", e);
                scanner.nextLine(); // limpiar buffer si ocurre error
                option = -1; // para continuar el ciclo
            }

        } while (option != 0);

        scanner.close();
    }
}

