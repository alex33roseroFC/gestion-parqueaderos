/**
 * Clase base que representa un vehículo en el parqueadero.
 * Define los atributos y métodos comunes a todos los tipos de vehículos.
 */
import java.time.LocalDateTime;

public abstract class Vehiculo {
    protected String placa;
    protected String marca;
    protected String modelo;
    protected LocalDateTime horaEntrada;

    /**
     * Constructor de la clase Vehiculo.
     *
     * @param placa        La placa del vehículo
     * @param marca        La marca del vehículo
     * @param modelo       El modelo del vehículo
     * @param horaEntrada  La hora de entrada al parqueadero
     */
    public Vehiculo(String placa, String marca, String modelo, LocalDateTime horaEntrada) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.horaEntrada = horaEntrada;
    }

    // Getters y Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * Método abstracto para calcular la tarifa del vehículo.
     * Cada tipo de vehículo tiene una tarifa diferente.
     *
     * @param horaSalida La hora de salida del parqueadero
     * @return La tarifa calculada
     */
    public abstract double calcularTarifa(LocalDateTime horaSalida);

    /**
     * Calcula el número de horas de permanencia, considerando fracciones como horas completas.
     *
     * @param horaSalida La hora de salida del parqueadero
     * @return El número de horas redondeado hacia arriba
     */
    protected long calcularHoras(LocalDateTime horaSalida) {
        long minutos = java.time.temporal.ChronoUnit.MINUTES.between(horaEntrada, horaSalida);
        return (minutos + 59) / 60; // Redondea hacia arriba
    }

    /**
     * Retorna el tipo de vehículo.
     * Este método es importante para polimorfismo.
     *
     * @return El tipo de vehículo
     */
    public abstract String getTipo();

    @Override
    public String toString() {
        return "Vehículo{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", horaEntrada=" + horaEntrada +
                '}';
    }
}
