import javax.swing.SwingUtilities;

/**
 * Clase principal del sistema de gestión de parqueadero.
 * Punto de entrada de la aplicación - Interfaz Gráfica.
 */

public class Principal {
    public static void main(String[] args) {
        // Lanzar interfaz gráfica profesional con capacidad de 40 vehículos
        SwingUtilities.invokeLater(() -> {
            InterfazGrafica frame = new InterfazGrafica(40);
            frame.setVisible(true);
        });
    }
}
