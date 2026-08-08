/**
 * Clase que representa un automóvil en el parqueadero.
 * Hereda de Vehiculo y añade el atributo tipoCombustible.
 */
import java.time.LocalDateTime;

public class Automovil extends Vehiculo {
    private String tipoCombustible;

    // Tarifa por hora para automóviles (en unidades de moneda)
    private static final double TARIFA_POR_HORA = 5000.0;

    /**
     * Constructor de la clase Automovil.
     *
     * @param placa             La placa del automóvil
     * @param marca             La marca del automóvil
     * @param modelo            El modelo del automóvil
     * @param horaEntrada       La hora de entrada al parqueadero
     * @param tipoCombustible   El tipo de combustible (gasolina, diesel, etc.)
     */
    public Automovil(String placa, String marca, String modelo, LocalDateTime horaEntrada, String tipoCombustible) {
        super(placa, marca, modelo, horaEntrada);
        this.tipoCombustible = tipoCombustible;
    }

    // Getters y Setters
    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    /**
     * Calcula la tarifa del automóvil basada en el tiempo de permanencia.
     * Tarifa: 5000 por hora (fracciones se cuentan como hora completa)
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
     * @return "Automóvil"
     */
    @Override
    public String getTipo() {
        return "Automóvil";
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                ", horaEntrada=" + horaEntrada +
                '}';
    }
}
