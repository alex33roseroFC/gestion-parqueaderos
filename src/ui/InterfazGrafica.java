import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

public class InterfazGrafica extends JFrame {
    private Parqueadero parqueadero;
    private JTable tablaVehiculos;
    private JLabel labelCapacidad;
    private JLabel labelIngresos;
    private DefaultTableModel modeloTabla;
    private DefaultTableModel modeloHistorial;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private int capacidadMaxima;

    public InterfazGrafica() {
        this(30);  // Capacidad por defecto
    }

    public InterfazGrafica(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.parqueadero = new Parqueadero("Parqueadero Central", capacidadMaxima);
        initComponents();
        actualizarDatos();
    }

    private void initComponents() {
        setTitle("Sistema de Gestión de Parqueadero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setResizable(true);
        
        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBackground(new Color(240, 242, 245));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // ===== PANEL SUPERIOR (Encabezado) =====
        JPanel panelEncabezado = crearPanelEncabezado();
        panelPrincipal.add(panelEncabezado, BorderLayout.NORTH);

        // ===== PANEL CENTRAL (Tabs) =====
        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabs.setBackground(Color.WHITE);

        tabs.addTab("Vehículos Presentes", crearPanelVehiculos());
        tabs.addTab("Registrar Entrada", crearPanelRegistroEntrada());
        tabs.addTab("Registrar Salida", crearPanelRegistroSalida());
        tabs.addTab("Historial", crearPanelHistorial());
        tabs.addTab("Buscar Vehículo", crearPanelBusqueda());

        panelPrincipal.add(tabs, BorderLayout.CENTER);

        // ===== PANEL INFERIOR (Estado) =====
        JPanel panelInferior = crearPanelInferior();
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    private JPanel crearPanelEncabezado() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(41, 128, 185));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel titulo = new JLabel("SISTEMA DE GESTIÓN DE PARQUEADERO");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setForeground(Color.WHITE);

        JPanel panelEstado = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 0));
        panelEstado.setOpaque(false);

        labelCapacidad = new JLabel("Capacidad: 0/30");
        labelCapacidad.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelCapacidad.setForeground(Color.WHITE);

        labelIngresos = new JLabel("Ingresos: $0");
        labelIngresos.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelIngresos.setForeground(Color.WHITE);

        panelEstado.add(labelCapacidad);
        panelEstado.add(new JSeparator(JSeparator.VERTICAL) {
            {
                setPreferredSize(new Dimension(2, 20));
                setForeground(Color.WHITE);
            }
        });
        panelEstado.add(labelIngresos);

        panel.add(titulo, BorderLayout.WEST);
        panel.add(panelEstado, BorderLayout.EAST);

        return panel;
    }

    private JPanel crearPanelVehiculos() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(240, 242, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Modelo y tabla
        modeloTabla = new DefaultTableModel(new String[]{"Placa", "Tipo", "Marca", "Modelo", "Entrada"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaVehiculos = new JTable(modeloTabla);
        tablaVehiculos.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        tablaVehiculos.setRowHeight(25);
        tablaVehiculos.setSelectionBackground(new Color(52, 152, 219));
        tablaVehiculos.setGridColor(new Color(200, 200, 200));

        JTableHeader header = tablaVehiculos.getTableHeader();
        header.setBackground(new Color(41, 128, 185));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));

        JScrollPane scrollPane = new JScrollPane(tablaVehiculos);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        panel.add(scrollPane, BorderLayout.CENTER);

        // Botón actualizar
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.setBackground(new Color(240, 242, 245));
        JButton btnActualizar = crearBoton("Actualizar", new Color(46, 204, 113));
        btnActualizar.addActionListener(e -> actualizarDatos());
        panelBotones.add(btnActualizar);

        panel.add(panelBotones, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel crearPanelRegistroEntrada() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 242, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tipo de vehículo
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Tipo de Vehículo:"), gbc);

        String[] tipos = {"Automóvil", "Motocicleta", "Camión"};
        JComboBox<String> comboTipo = new JComboBox<>(tipos);
        gbc.gridx = 1;
        panel.add(comboTipo, gbc);

        // Placa
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Placa:"), gbc);
        JTextField txtPlaca = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtPlaca, gbc);

        // Marca
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Marca:"), gbc);
        JTextField txtMarca = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtMarca, gbc);

        // Modelo
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Modelo:"), gbc);
        JTextField txtModelo = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtModelo, gbc);

        // Campo adicional (dinámico)
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel lblAdicional = new JLabel("Tipo de Combustible:");
        panel.add(lblAdicional, gbc);
        JTextField txtAdicional = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtAdicional, gbc);

        comboTipo.addActionListener(e -> {
            String selected = (String) comboTipo.getSelectedItem();
            if (selected.equals("Automóvil")) {
                lblAdicional.setText("Tipo de Combustible:");
            } else if (selected.equals("Motocicleta")) {
                lblAdicional.setText("Cilindraje:");
            } else {
                lblAdicional.setText("Capacidad de Carga (kg):");
            }
        });

        // Botón registrar
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        JButton btnRegistrar = crearBoton("Registrar Entrada", new Color(46, 204, 113));
        btnRegistrar.addActionListener(e -> {
            try {
                String placa = txtPlaca.getText().trim();
                String marca = txtMarca.getText().trim();
                String modelo = txtModelo.getText().trim();
                String tipo = (String) comboTipo.getSelectedItem();
                String adicional = txtAdicional.getText().trim();

                if (placa.isEmpty() || marca.isEmpty() || modelo.isEmpty() || adicional.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "[ADVERTENCIA] Completar todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Vehiculo vehiculo = null;
                if (tipo.equals("Automóvil")) {
                    vehiculo = new Automovil(placa, marca, modelo, LocalDateTime.now(), adicional);
                } else if (tipo.equals("Motocicleta")) {
                    vehiculo = new Motocicleta(placa, marca, modelo, LocalDateTime.now(), Integer.parseInt(adicional));
                } else {
                    vehiculo = new Camion(placa, marca, modelo, LocalDateTime.now(), Double.parseDouble(adicional));
                }

                if (parqueadero.registrarEntrada(vehiculo)) {
                    JOptionPane.showMessageDialog(this, "Vehículo registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    txtPlaca.setText("");
                    txtMarca.setText("");
                    txtModelo.setText("");
                    txtAdicional.setText("");
                    actualizarDatos();
                } else {
                    JOptionPane.showMessageDialog(this, "Parqueadero lleno - Capacidad máxima alcanzada", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valores inválidos - Verifique los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(btnRegistrar, gbc);

        return panel;
    }

    private JPanel crearPanelRegistroSalida() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 242, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Placa del Vehículo:"), gbc);
        JTextField txtPlaca = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtPlaca, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lblCosto = new JLabel("Costo a Pagar: $0");
        lblCosto.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblCosto.setForeground(new Color(231, 76, 60));
        panel.add(lblCosto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JButton btnCalcular = crearBoton("Calcular Tarifa", new Color(52, 152, 219));
        btnCalcular.addActionListener(e -> {
            String placa = txtPlaca.getText().trim();
            Optional<Vehiculo> vehiculo = parqueadero.buscarVehiculo(placa);
            if (vehiculo.isPresent()) {
                double costo = vehiculo.get().calcularTarifa(LocalDateTime.now());
                lblCosto.setText(String.format("Costo a Pagar: $%.0f", costo));
            } else {
                JOptionPane.showMessageDialog(this, "❌ Vehículo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(btnCalcular, gbc);

        gbc.gridy = 3;
        JButton btnRegistrarSalida = crearBoton("Registrar Salida", new Color(46, 204, 113));
        btnRegistrarSalida.addActionListener(e -> {
            String placa = txtPlaca.getText().trim();
            double costo = parqueadero.registrarSalida(placa, LocalDateTime.now());
            if (costo >= 0) {
                JOptionPane.showMessageDialog(this, String.format("Salida registrada\nCosto a pagar: $%.0f", costo), "Éxito", JOptionPane.INFORMATION_MESSAGE);
                txtPlaca.setText("");
                lblCosto.setText("Costo a Pagar: $0");
                actualizarDatos();
            } else {
                JOptionPane.showMessageDialog(this, "❌ Vehículo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(btnRegistrarSalida, gbc);

        return panel;
    }

    private JPanel crearPanelHistorial() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(240, 242, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ===== PANEL DE FILTROS =====
        JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelFiltros.setBackground(new Color(240, 242, 245));
        panelFiltros.setBorder(BorderFactory.createTitledBorder("Filtros Disponibles"));

        // Filtro por tipo
        panelFiltros.add(new JLabel("Tipo:"));
        String[] tipos = {"Todos", "Automóvil", "Motocicleta", "Camión"};
        JComboBox<String> comboTipo = new JComboBox<>(tipos);
        panelFiltros.add(comboTipo);

        // Filtro por placa
        panelFiltros.add(new JLabel("Placa:"));
        JTextField txtPlaca = new JTextField(10);
        panelFiltros.add(txtPlaca);

        modeloHistorial = new DefaultTableModel(
                new String[]{"Placa", "Tipo", "Entrada", "Salida", "Duración", "Costo"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tablaHistorial = new JTable(modeloHistorial);
        tablaHistorial.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        tablaHistorial.setRowHeight(30);
        tablaHistorial.setSelectionBackground(new Color(52, 152, 219));
        tablaHistorial.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JTableHeader header = tablaHistorial.getTableHeader();
        header.setBackground(new Color(41, 128, 185));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 11));

        JScrollPane scrollPane = new JScrollPane(tablaHistorial);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        // ===== PANEL DE BOTONES =====
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        panelBotones.setBackground(new Color(240, 242, 245));

        JButton btnFiltrar = crearBoton("Aplicar Filtros", new Color(52, 152, 219));
        btnFiltrar.addActionListener(e -> {
            actualizarHistorialConFiltros(comboTipo.getSelectedItem().toString(), txtPlaca.getText().trim());
        });
        panelBotones.add(btnFiltrar);

        JButton btnLimpiar = crearBoton("Limpiar Filtros", new Color(155, 89, 182));
        btnLimpiar.addActionListener(e -> {
            comboTipo.setSelectedIndex(0);
            txtPlaca.setText("");
            actualizarHistorial();
        });
        panelBotones.add(btnLimpiar);

        JButton btnExportar = crearBoton("Resumen Diario", new Color(46, 204, 113));
        btnExportar.addActionListener(e -> mostrarResumenDiario());
        panelBotones.add(btnExportar);

        panel.add(panelFiltros, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        return panel;
    }

    private void actualizarHistorialConFiltros(String tipo, String placa) {
        modeloHistorial.setRowCount(0);
        List<Parqueadero.RegistroVehiculo> registros;

        if (tipo.equals("Todos") && placa.isEmpty()) {
            registros = parqueadero.obtenerHistorialCompleto();
        } else if (!tipo.equals("Todos") && placa.isEmpty()) {
            registros = parqueadero.filtrarPorTipo(tipo);
        } else if (tipo.equals("Todos") && !placa.isEmpty()) {
            registros = parqueadero.filtrarPorPlaca(placa);
        } else {
            registros = parqueadero.filtrarPorTipo(tipo).stream()
                    .filter(r -> r.getVehiculo().getPlaca().equalsIgnoreCase(placa))
                    .collect(java.util.stream.Collectors.toList());
        }

        for (Parqueadero.RegistroVehiculo reg : registros) {
            modeloHistorial.addRow(new Object[]{
                    reg.getVehiculo().getPlaca(),
                    reg.getVehiculo().getTipo(),
                    reg.getHoraEntrada().format(formatter),
                    reg.getHoraSalida().format(formatter),
                    reg.getDuracionFormato(),
                    String.format("$%.0f", reg.getCosto())
            });
        }
    }

    private void mostrarResumenDiario() {
        java.time.LocalDate hoy = java.time.LocalDate.now();
        List<Parqueadero.RegistroVehiculo> registrosHoy = parqueadero.filtrarPorFecha(hoy);
        
        StringBuilder sb = new StringBuilder();
        sb.append("RESUMEN DEL DÍA - ").append(hoy.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n\n");
        sb.append("═══════════════════════════════════════\n");
        sb.append("Total de Transacciones: ").append(registrosHoy.size()).append("\n");
        sb.append("Ingreso Total del Día: $").append(String.format("%.0f", parqueadero.calcularIngresosPorFecha(hoy))).append("\n\n");
        
        sb.append("Por Tipo de Vehículo:\n");
        for (String tipo : new String[]{"Automóvil", "Motocicleta", "Camión"}) {
            long cantidad = registrosHoy.stream().filter(r -> r.getVehiculo().getTipo().equalsIgnoreCase(tipo)).count();
            double ingreso = parqueadero.filtrarPorTipo(tipo).stream()
                    .filter(r -> r.getHoraEntrada().toLocalDate().equals(hoy))
                    .mapToDouble(Parqueadero.RegistroVehiculo::getCosto).sum();
            if (cantidad > 0) {
                sb.append(String.format("  • %s: %d transacciones - $%.0f\n", tipo, cantidad, ingreso));
            }
        }
        sb.append("═══════════════════════════════════════\n");
        
        JOptionPane.showMessageDialog(this, sb.toString(), "Resumen Diario", JOptionPane.INFORMATION_MESSAGE);
    }

    private JPanel crearPanelBusqueda() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(240, 242, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel panelEntrada = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        panelEntrada.setBackground(new Color(240, 242, 245));
        panelEntrada.add(new JLabel("Placa:"));
        JTextField txtPlaca = new JTextField(15);
        panelEntrada.add(txtPlaca);

        JTextArea areaResultado = new JTextArea();
        areaResultado.setFont(new Font("Courier New", Font.PLAIN, 11));
        areaResultado.setEditable(false);
        areaResultado.setBackground(Color.WHITE);
        areaResultado.setLineWrap(true);
        areaResultado.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(areaResultado);

        JButton btnBuscar = crearBoton("Buscar", new Color(52, 152, 219));
        btnBuscar.addActionListener(e -> {
            String placa = txtPlaca.getText().trim();
            Optional<Vehiculo> vehiculo = parqueadero.buscarVehiculo(placa);
            if (vehiculo.isPresent()) {
                Vehiculo v = vehiculo.get();
                StringBuilder sb = new StringBuilder();
                sb.append("VEHÍCULO ENCONTRADO\n\n");
                sb.append("╔════════════════════════════════════════╗\n");
                sb.append(String.format("║ Placa:         %-29s║\n", v.getPlaca()));
                sb.append(String.format("║ Tipo:          %-29s║\n", v.getTipo()));
                sb.append(String.format("║ Marca:         %-29s║\n", v.getMarca()));
                sb.append(String.format("║ Modelo:        %-29s║\n", v.getModelo()));
                sb.append(String.format("║ Entrada:       %-29s║\n", v.getHoraEntrada().format(formatter)));
                sb.append(String.format("║ Tarifa Actual: $%-28.0f║\n", v.calcularTarifa(LocalDateTime.now())));
                sb.append("╚════════════════════════════════════════╝\n");
                
                areaResultado.setText(sb.toString());
            } else {
                // Buscar en historial
                List<Parqueadero.RegistroVehiculo> registros = parqueadero.filtrarPorPlaca(placa);
                if (!registros.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("HISTORIAL DE TRANSACCIONES - ").append(placa).append("\n\n");
                    sb.append("Transacciones Registradas:\n");
                    sb.append("═══════════════════════════════════════════════════\n");
                    for (Parqueadero.RegistroVehiculo reg : registros) {
                        sb.append(String.format("\nEntrada:   %s\n", reg.getHoraEntrada().format(formatter)));
                        sb.append(String.format("Salida:    %s\n", reg.getHoraSalida().format(formatter)));
                        sb.append(String.format("Duración: %s\n", reg.getDuracionFormato()));
                        sb.append(String.format("Costo:     $%.0f\n", reg.getCosto()));
                        sb.append("───────────────────────────────────────────────────\n");
                    }
                    sb.append(String.format("\nTotal Transacciones: %d\n", registros.size()));
                    sb.append(String.format("Ingreso Total: $%.0f\n", registros.stream().mapToDouble(Parqueadero.RegistroVehiculo::getCosto).sum()));
                    areaResultado.setText(sb.toString());
                } else {
                    areaResultado.setText("Vehículo no encontrado en registros");
                }
            }
        });
        panelEntrada.add(btnBuscar);

        panel.add(panelEntrada, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelInferior() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        panel.setBackground(new Color(41, 128, 185));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel version = new JLabel("v1.0 © 2026 - Sistema de Gestión Parqueadero");
        version.setForeground(Color.WHITE);
        version.setFont(new Font("Segoe UI", Font.PLAIN, 10));

        panel.add(version);

        return panel;
    }

    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 11));
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(150, 35));

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(color.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(color);
            }
        });

        return boton;
    }

    private void actualizarDatos() {
        actualizarTablaVehiculos();
        actualizarHistorial();
        actualizarEstado();
    }

    private void actualizarTablaVehiculos() {
        modeloTabla.setRowCount(0);
        for (Vehiculo v : parqueadero.obtenerVehiculosPresentes()) {
            modeloTabla.addRow(new Object[]{
                v.getPlaca(),
                v.getTipo(),
                v.getMarca(),
                v.getModelo(),
                v.getHoraEntrada().format(formatter)
            });
        }
    }

    private void actualizarHistorial() {
        modeloHistorial.setRowCount(0);
        for (Parqueadero.RegistroVehiculo reg : parqueadero.obtenerHistorialCompleto()) {
            modeloHistorial.addRow(new Object[]{
                    reg.getVehiculo().getPlaca(),
                    reg.getVehiculo().getTipo(),
                    reg.getHoraEntrada().format(formatter),
                    reg.getHoraSalida().format(formatter),
                    reg.getDuracionFormato(),
                    String.format("$%.0f", reg.getCosto())
            });
        }
    }

    private void actualizarEstado() {
        int actuales = parqueadero.obtenerVehiculosPresentes().size();
        labelCapacidad.setText(String.format("Capacidad: %d/%d", actuales, capacidadMaxima));
        labelIngresos.setText(String.format("Ingresos: $%.0f", parqueadero.calcularIngresoTotal()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazGrafica frame = new InterfazGrafica();
            frame.setVisible(true);
        });
    }
}
