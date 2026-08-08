/**
 * Clase que representa un camión en el parqueadero.
 * Hereda de Vehiculo y añade el atributo capacidadCarga.
 */
import java.time.LocalDateTime;

public class Camion extends Vehiculo {
    private double capacidadCarga;

    // Tarifa por hora para camiones (en unidades de moneda)
    private static final double TARIFA_POR_HORA = 8000.0;

    /**
     * Constructor de la clase Camion.
     *
     * @param placa           La placa del camión
     * @param marca           La marca del camión
     * @param modelo          El modelo del camión
     * @param horaEntrada     La hora de entrada al parqueadero
     * @param capacidadCarga  La capacidad de carga en toneladas
     */
    public Camion(String placa, String marca, String modelo, LocalDateTime horaEntrada, double capacidadCarga) {
        super(placa, marca, modelo, horaEntrada);
        this.capacidadCarga = capacidadCarga;
    }

    // Getters y Setters
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    /**
     * Calcula la tarifa del camión basada en el tiempo de permanencia.
     * Tarifa: 8000 por hora (fracciones se cuentan como hora completa)
     *
     * @param horaSalida La hora de salida del parqueadero
     * @return La tarifa calculada
     */
    @Override
    public double calcularTarifa(LocalDateTime horaSalida) {
        long horas = calcularHoras(horaSalida);
        return horas * TARIFA_POR_HORA;
    }

    /**
     * Retorna el tipo de vehículo.
     *
     * @return "Camión"
     */
    @Override
    public String getTipo() {
        return "Camión";
    }

    @Override
    public String toString() {
        return "Camion{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidadCarga=" + capacidadCarga +
                ", horaEntrada=" + horaEntrada +
                '}';
    }
}
