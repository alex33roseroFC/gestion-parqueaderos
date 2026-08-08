/**
 * Clase encargada de proporcionar la interfaz de consola para el sistema de parqueadero.
 * Maneja la interacción con el usuario a través de un menú de opciones.
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuConsola {
    private Parqueadero parqueadero;
    private Scanner scanner;
    private DateTimeFormatter formatter;

    /**
     * Constructor de la clase MenuConsola.
     *
     * @param parqueadero El parqueadero a gestionar
     */
    public MenuConsola(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    }

    /**
     * Inicia el menú principal del sistema.
     */
    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();
            continuar = procesarOpcion(opcion);
        }
        scanner.close();
    }

    /**
     * Muestra el menú principal.
     */
    private void mostrarMenuPrincipal() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN DE PARQUEADERO    ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1. Registrar entrada de vehículo       ║");
        System.out.println("║ 2. Registrar salida de vehículo        ║");
        System.out.println("║ 3. Consultar vehículos presentes       ║");
        System.out.println("║ 4. Ver estado del parqueadero          ║");
        System.out.println("║ 5. Ver historial de salidas            ║");
        System.out.println("║ 6. Buscar vehículo por placa           ║");
        System.out.println("║ 7. Salir                               ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Lee la opción del usuario.
     *
     * @return La opción seleccionada
     */
    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Opción inválida. Por favor ingrese un número.");
            return -1;
        }
    }

    /**
     * Procesa la opción seleccionada por el usuario.
     *
     * @param opcion La opción seleccionada
     * @return false si debe salir del sistema, true en caso contrario
     */
    private boolean procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarEntrada();
                break;
            case 2:
                registrarSalida();
                break;
            case 3:
                consultarVehiculosPresentes();
                break;
            case 4:
                verEstadoParqueadero();
                break;
            case 5:
                verHistorialSalidas();
                break;
            case 6:
                buscarVehiculo();
                break;
            case 7:
                System.out.println("\n[OK] ¡Gracias por usar el sistema! Hasta luego.");
                return false;
            default:
                System.out.println("[ERROR] Opción no válida. Intente nuevamente.");
        }
        return true;
    }

    /**
     * Registra la entrada de un nuevo vehículo.
     */
    private void registrarEntrada() {
        System.out.println("\n---------- REGISTRAR ENTRADA DE VEHÍCULO ----------");

        // Seleccionar tipo de vehículo
        System.out.println("\nTipo de vehículo:");
        System.out.println("1. Automóvil");
        System.out.println("2. Motocicleta");
        System.out.println("3. Camión");
        System.out.print("Seleccione tipo (1-3): ");

        int tipo = leerOpcion();
        if (tipo < 1 || tipo > 3) {
            System.out.println("[ERROR] Tipo de vehículo inválido.");
            return;
        }

        // Datos comunes
        System.out.print("Placa del vehículo: ");
        String placa = scanner.nextLine().trim().toUpperCase();

        System.out.print("Marca: ");
        String marca = scanner.nextLine().trim();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine().trim();

        System.out.print("Hora de entrada (yyyy-MM-dd HH:mm) [Dejar en blanco para hora actual]: ");
        String horaStr = scanner.nextLine().trim();
        LocalDateTime horaEntrada = horaStr.isEmpty() ? LocalDateTime.now() : 
                                    LocalDateTime.parse(horaStr, formatter);

        Vehiculo vehiculo = null;

        try {
            switch (tipo) {
                case 1: // Automóvil
                    System.out.print("Tipo de combustible (gasolina/diesel): ");
                    String combustible = scanner.nextLine().trim();
                    vehiculo = new Automovil(placa, marca, modelo, horaEntrada, combustible);
                    break;

                case 2: // Motocicleta
                    System.out.print("Cilindraje (cc): ");
                    int cilindraje = Integer.parseInt(scanner.nextLine().trim());
                    vehiculo = new Motocicleta(placa, marca, modelo, horaEntrada, cilindraje);
                    break;

                case 3: // Camión
                    System.out.print("Capacidad de carga (toneladas): ");
                    double capacidad = Double.parseDouble(scanner.nextLine().trim());
                    vehiculo = new Camion(placa, marca, modelo, horaEntrada, capacidad);
                    break;
            }

            if (parqueadero.registrarEntrada(vehiculo)) {
                System.out.println("\n[OK] Vehículo registrado exitosamente.");
                System.out.println("   " + vehiculo);
            } else {
                System.out.println("[ERROR] No hay espacio disponible en el parqueadero.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("❌ Formato de fecha/hora inválido.");
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Valor numérico inválido.");
        }
    }

    /**
     * Registra la salida de un vehículo.
     */
    private void registrarSalida() {
        System.out.println("\n---------- REGISTRAR SALIDA DE VEHÍCULO ----------");

        System.out.print("Placa del vehículo: ");
        String placa = scanner.nextLine().trim().toUpperCase();

        System.out.print("Hora de salida (yyyy-MM-dd HH:mm) [Dejar en blanco para hora actual]: ");
        String horaStr = scanner.nextLine().trim();

        try {
            LocalDateTime horaSalida = horaStr.isEmpty() ? LocalDateTime.now() : 
                                       LocalDateTime.parse(horaStr, formatter);

            double costo = parqueadero.registrarSalida(placa, horaSalida);

            if (costo >= 0) {
                System.out.println("\n[OK] Vehículo registrado de salida exitosamente.");
                System.out.println("   Placa: " + placa);
                System.out.println("   Costo del parqueo: $" + String.format("%.2f", costo));
            } else {
                System.out.println("[ERROR] Vehículo no encontrado en el parqueadero.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("❌ Formato de fecha/hora inválido.");
        }
    }

    /**
     * Consulta los vehículos presentes en el parqueadero.
     */
    private void consultarVehiculosPresentes() {
        System.out.println("\n---------- VEHÍCULOS PRESENTES EN EL PARQUEADERO ----------");

        List<Vehiculo> vehiculos = parqueadero.obtenerVehiculosPresentes();

        if (vehiculos.isEmpty()) {
            System.out.println("El parqueadero está vacío.");
        } else {
            System.out.println("\nTotal de vehículos: " + vehiculos.size() + "/" + parqueadero.getCapacidadTotal());
            System.out.println("─────────────────────────────────────────────");
            for (int i = 0; i < vehiculos.size(); i++) {
                Vehiculo v = vehiculos.get(i);
                System.out.println((i + 1) + ". " + v.getTipo());
                System.out.println("   Placa: " + v.getPlaca());
                System.out.println("   Marca: " + v.getMarca() + " - Modelo: " + v.getModelo());
                System.out.println("   Hora de entrada: " + v.getHoraEntrada());
                mostrarDetallesVehiculo(v);
                System.out.println("─────────────────────────────────────────────");
            }
        }
    }

    /**
     * Muestra detalles específicos según el tipo de vehículo.
     *
     * @param v El vehículo
     */
    private void mostrarDetallesVehiculo(Vehiculo v) {
        if (v instanceof Automovil) {
            Automovil a = (Automovil) v;
            System.out.println("   Combustible: " + a.getTipoCombustible());
        } else if (v instanceof Motocicleta) {
            Motocicleta m = (Motocicleta) v;
            System.out.println("   Cilindraje: " + m.getCilindraje() + " cc");
        } else if (v instanceof Camion) {
            Camion c = (Camion) v;
            System.out.println("   Capacidad de carga: " + c.getCapacidadCarga() + " toneladas");
        }
    }

    /**
     * Muestra el estado del parqueadero.
     */
    private void verEstadoParqueadero() {
        System.out.println(parqueadero.obtenerResumenEstado());
    }

    /**
     * Muestra el historial completo de transacciones.
     */
    private void verHistorialSalidas() {
        System.out.println("\n---------- HISTORIAL COMPLETO ----------");

        List<Parqueadero.RegistroVehiculo> historial = parqueadero.obtenerHistorialCompleto();

        if (historial.isEmpty()) {
            System.out.println("No hay registros de transacciones.");
        } else {
            System.out.println("\nTotal de registros: " + historial.size());
            System.out.println("─────────────────────────────────────────────");
            for (int i = 0; i < historial.size(); i++) {
                Parqueadero.RegistroVehiculo r = historial.get(i);
                System.out.println((i + 1) + ". Placa: " + r.getVehiculo().getPlaca());
                System.out.println("   Tipo: " + r.getVehiculo().getTipo());
                System.out.println("   [ENTRADA] Entrada: " + r.getHoraEntrada());
                System.out.println("   [SALIDA] Salida: " + r.getHoraSalida());
                System.out.println("   [DURACION] Duración: " + r.getDuracionFormato());
                System.out.println("   [COSTO] Costo: $" + String.format("%.2f", r.getCosto()));
                System.out.println("─────────────────────────────────────────────");
            }
            System.out.println("Ingreso total: $" + String.format("%.2f", parqueadero.calcularIngresoTotal()));
        }
    }

    /**
     * Busca un vehículo específico por placa.
     */
    private void buscarVehiculo() {
        System.out.println("\n---------- BUSCAR VEHÍCULO ----------");

        System.out.print("Ingrese la placa del vehículo: ");
        String placa = scanner.nextLine().trim().toUpperCase();

        Optional<Vehiculo> vehiculoOpt = parqueadero.buscarVehiculo(placa);

        if (vehiculoOpt.isPresent()) {
            Vehiculo v = vehiculoOpt.get();
            System.out.println("\n[OK] Vehículo encontrado:");
            System.out.println("   Tipo: " + v.getTipo());
            System.out.println("   Placa: " + v.getPlaca());
            System.out.println("   Marca: " + v.getMarca());
            System.out.println("   Modelo: " + v.getModelo());
            System.out.println("   Hora de entrada: " + v.getHoraEntrada());
            mostrarDetallesVehiculo(v);

            // Calcular tiempo y tarifa estimada
            LocalDateTime ahora = LocalDateTime.now();
            long minutos = java.time.temporal.ChronoUnit.MINUTES.between(v.getHoraEntrada(), ahora);
            double tarifa = v.calcularTarifa(ahora);
            System.out.println("   Tiempo en parqueadero: " + minutos + " minutos");
            System.out.println("   Tarifa estimada actual: $" + String.format("%.2f", tarifa));
        } else {
            System.out.println("❌ Vehículo no encontrado en el parqueadero.");
        }
    }
}
