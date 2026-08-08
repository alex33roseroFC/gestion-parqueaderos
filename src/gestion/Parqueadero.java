/**
 * Clase encargada de gestionar los vehículos en el parqueadero.
 * Implementa funcionalidades para registrar entrada, salida y calcular tarifas.
 * Permite múltiples entradas/salidas del mismo vehículo en un día.
 */
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Parqueadero {
    private String nombre;
    private int capacidadTotal;
    private List<Vehiculo> vehiculosActuales;
    private List<RegistroVehiculo> historialCompleto;  // Registro de entrada Y salida

    /**
     * Constructor de la clase Parqueadero.
     *
     * @param nombre           El nombre del parqueadero
     * @param capacidadTotal   La capacidad máxima de vehículos
     */
    public Parqueadero(String nombre, int capacidadTotal) {
        this.nombre = nombre;
        this.capacidadTotal = capacidadTotal;
        this.vehiculosActuales = new ArrayList<>();
        this.historialCompleto = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public int getEspaciosDisponibles() {
        return capacidadTotal - vehiculosActuales.size();
    }

    public int getVehiculosPresentes() {
        return vehiculosActuales.size();
    }

    /**
     * Registra la entrada de un vehículo al parqueadero.
     * Verifica que haya espacio disponible.
     *
     * @param vehiculo El vehículo a registrar
     * @return true si se registró exitosamente, false si no hay espacio
     */
    public boolean registrarEntrada(Vehiculo vehiculo) {
        if (vehiculosActuales.size() < capacidadTotal) {
            vehiculosActuales.add(vehiculo);
            return true;
        }
        return false;
    }

    /**
     * Registra la salida de un vehículo del parqueadero.
     * Calcula el costo del parqueo y lo almacena en el historial.
     * Permite múltiples entradas/salidas del mismo vehículo en un día.
     *
     * @param placa      La placa del vehículo que sale
     * @param horaSalida La hora de salida
     * @return El costo del parqueo, o -1 si el vehículo no se encuentra
     */
    public double registrarSalida(String placa, LocalDateTime horaSalida) {
        Optional<Vehiculo> vehiculoOpt = buscarVehiculo(placa);
        
        if (vehiculoOpt.isPresent()) {
            Vehiculo vehiculo = vehiculoOpt.get();
            double costo = vehiculo.calcularTarifa(horaSalida);
            
            // Registrar en el historial completo (entrada Y salida)
            historialCompleto.add(new RegistroVehiculo(vehiculo, vehiculo.getHoraEntrada(), horaSalida, costo));
            
            // Remover del parqueadero
            vehiculosActuales.remove(vehiculo);
            
            return costo;
        }
        return -1;
    }

    /**
     * Busca un vehículo en el parqueadero por su placa.
     *
     * @param placa La placa del vehículo
     * @return Un Optional con el vehículo si se encuentra, vacío en caso contrario
     */
    public Optional<Vehiculo> buscarVehiculo(String placa) {
        return vehiculosActuales.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst();
    }

    /**
     * Obtiene la lista de vehículos presentes en el parqueadero.
     *
     * @return Lista de vehículos
     */
    public List<Vehiculo> obtenerVehiculosPresentes() {
        return new ArrayList<>(vehiculosActuales);
    }

    /**
     * Obtiene el historial completo de transacciones (entrada y salida).
     *
     * @return Lista de registros completos
     */
    public List<RegistroVehiculo> obtenerHistorialCompleto() {
        return new ArrayList<>(historialCompleto);
    }

    /**
     * Obtiene el historial filtrado por fecha específica.
     *
     * @param fecha La fecha para filtrar
     * @return Lista de registros de esa fecha
     */
    public List<RegistroVehiculo> filtrarPorFecha(LocalDate fecha) {
        return historialCompleto.stream()
                .filter(r -> r.getHoraEntrada().toLocalDate().equals(fecha))
                .collect(Collectors.toList());
    }

    /**
     * Obtiene el historial filtrado por tipo de vehículo.
     *
     * @param tipo El tipo de vehículo ("Automóvil", "Motocicleta", "Camión")
     * @return Lista de registros de ese tipo
     */
    public List<RegistroVehiculo> filtrarPorTipo(String tipo) {
        return historialCompleto.stream()
                .filter(r -> r.getVehiculo().getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    /**
     * Obtiene el historial filtrado por placa.
     *
     * @param placa La placa del vehículo
     * @return Lista de transacciones de ese vehículo
     */
    public List<RegistroVehiculo> filtrarPorPlaca(String placa) {
        return historialCompleto.stream()
                .filter(r -> r.getVehiculo().getPlaca().equalsIgnoreCase(placa))
                .collect(Collectors.toList());
    }

    /**
     * Obtiene el historial filtrado por fecha y tipo de vehículo.
     *
     * @param fecha La fecha para filtrar
     * @param tipo El tipo de vehículo
     * @return Lista de registros filtrados
     */
    public List<RegistroVehiculo> filtrarPorFechaYTipo(LocalDate fecha, String tipo) {
        return historialCompleto.stream()
                .filter(r -> r.getHoraEntrada().toLocalDate().equals(fecha) && 
                            r.getVehiculo().getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    /**
     * Calcula el ingreso total del parqueadero desde todas las salidas registradas.
     *
     * @return El ingreso total
     */
    public double calcularIngresoTotal() {
        return historialCompleto.stream()
                .mapToDouble(RegistroVehiculo::getCosto)
                .sum();
    }

    /**
     * Calcula el ingreso total de un día específico.
     *
     * @param fecha La fecha para calcular ingresos
     * @return El ingreso total de ese día
     */
    public double calcularIngresosPorFecha(LocalDate fecha) {
        return filtrarPorFecha(fecha).stream()
                .mapToDouble(RegistroVehiculo::getCosto)
                .sum();
    }

    /**
     * Calcula el ingreso total por tipo de vehículo.
     *
     * @param tipo El tipo de vehículo
     * @return El ingreso total de ese tipo
     */
    public double calcularIngresosPorTipo(String tipo) {
        return filtrarPorTipo(tipo).stream()
                .mapToDouble(RegistroVehiculo::getCosto)
                .sum();
    }

    /**
     * Obtiene un resumen del estado actual del parqueadero.
     *
     * @return String con el resumen
     */
    public String obtenerResumenEstado() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n========== RESUMEN PARQUEADERO ==========\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Capacidad Total: ").append(capacidadTotal).append("\n");
        sb.append("Vehículos Presentes: ").append(vehiculosActuales.size()).append("\n");
        sb.append("Espacios Disponibles: ").append(getEspaciosDisponibles()).append("\n");
        sb.append("Transacciones Totales: ").append(historialCompleto.size()).append("\n");
        sb.append("Ingreso Total: $").append(String.format("%.2f", calcularIngresoTotal())).append("\n");
        sb.append("========================================\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Parqueadero{" +
                "nombre='" + nombre + '\'' +
                ", capacidadTotal=" + capacidadTotal +
                ", vehiculosActuales=" + vehiculosActuales.size() +
                '}';
    }

    /**
     * Clase interna para registrar las transacciones completas de vehículos.
     * Guarda la entrada, salida y costo de cada transacción.
     */
    public static class RegistroVehiculo {
        private Vehiculo vehiculo;
        private LocalDateTime horaEntrada;
        private LocalDateTime horaSalida;
        private double costo;

        public RegistroVehiculo(Vehiculo vehiculo, LocalDateTime horaEntrada, LocalDateTime horaSalida, double costo) {
            this.vehiculo = vehiculo;
            this.horaEntrada = horaEntrada;
            this.horaSalida = horaSalida;
            this.costo = costo;
        }

        public Vehiculo getVehiculo() {
            return vehiculo;
        }

        public LocalDateTime getHoraEntrada() {
            return horaEntrada;
        }

        public LocalDateTime getHoraSalida() {
            return horaSalida;
        }

        public double getCosto() {
            return costo;
        }

        /**
         * Calcula la duración de la estadía.
         * @return Duración en minutos
         */
        public long getDuracionMinutos() {
            return java.time.temporal.ChronoUnit.MINUTES.between(horaEntrada, horaSalida);
        }

        /**
         * Calcula la duración de la estadía en formato legible.
         * @return String con formato "X horas Y minutos"
         */
        public String getDuracionFormato() {
            long minutos = getDuracionMinutos();
            long horas = minutos / 60;
            long mins = minutos % 60;
            return String.format("%d h %d min", horas, mins);
        }

        @Override
        public String toString() {
            return "RegistroVehiculo{" +
                    "vehiculo=" + vehiculo.getPlaca() +
                    ", entrada=" + horaEntrada +
                    ", salida=" + horaSalida +
                    ", duracion=" + getDuracionFormato() +
                    ", costo=" + costo +
                    '}';
        }
    }
}
