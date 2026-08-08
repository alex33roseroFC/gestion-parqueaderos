/**
 * Clase que representa una motocicleta en el parqueadero.
 * Hereda de Vehiculo y añade el atributo cilindraje.
 */
import java.time.LocalDateTime;

public class Motocicleta extends Vehiculo {
    private int cilindraje;

    // Tarifa por hora para motocicletas (en unidades de moneda)
    private static final double TARIFA_POR_HORA = 2000.0;

    /**
     * Constructor de la clase Motocicleta.
     *
     * @param placa       La placa de la motocicleta
     * @param marca       La marca de la motocicleta
     * @param modelo      El modelo de la motocicleta
     * @param horaEntrada La hora de entrada al parqueadero
     * @param cilindraje  El cilindraje de la motocicleta
     */
    public Motocicleta(String placa, String marca, String modelo, LocalDateTime horaEntrada, int cilindraje) {
        super(placa, marca, modelo, horaEntrada);
        this.cilindraje = cilindraje;
    }

    // Getters y Setters
    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    /**
     * Calcula la tarifa de la motocicleta basada en el tiempo de permanencia.
     * Tarifa: 2000 por hora (fracciones se cuentan como hora completa)
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
     * @return "Motocicleta"
     */
    @Override
    public String getTipo() {
        return "Motocicleta";
    }

    @Override
    public String toString() {
        return "Motocicleta{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cilindraje=" + cilindraje +
                ", horaEntrada=" + horaEntrada +
                '}';
    }
}
