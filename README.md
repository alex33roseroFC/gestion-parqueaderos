# Sistema de Gestión de Parqueadero

## Descripción
Sistema de gestión de parqueadero desarrollado en Java que permite registrar diferentes tipos de vehículos, gestionar su entrada y salida, y calcular el costo del parqueo según el tipo de vehículo y el tiempo de permanencia.

## Características principales
- ✅ Registro de entrada y salida de vehículos
- ✅ Soporte para tres tipos de vehículos (Automóvil, Motocicleta, Camión)
- ✅ Cálculo automático de tarifas por hora
- ✅ Gestión de capacidad del parqueadero
- ✅ Historial de transacciones
- ✅ Interfaz de consola interactiva
- ✅ Implementación de herencia y polimorfismo en Java

## Estructura del Proyecto

```
Gestion_Parqueaderos/
├── src/
│   └── com/
│       └── parqueadero/
│           ├── modelo/
│           │   ├── Vehiculo.java           (Clase base abstracta)
│           │   ├── Automovil.java          (Clase derivada)
│           │   ├── Motocicleta.java        (Clase derivada)
│           │   └── Camion.java             (Clase derivada)
│           ├── gestion/
│           │   └── Parqueadero.java        (Gestión de vehículos)
│           ├── ui/
│           │   └── MenuConsola.java        (Interfaz de usuario)
│           └── Principal.java              (Punto de entrada)
├── docs/
│   └── Informe_Tecnico.md                  (Documentación técnica)
├── diagrama_uml.puml                       (Diagrama UML en PlantUML)
├── README.md                               (Este archivo)
└── .gitignore
```

## Tarifas por Vehículo

| Tipo de Vehículo | Tarifa por Hora |
|------------------|-----------------|
| Motocicleta      | $2,000          |
| Automóvil        | $5,000          |
| Camión           | $8,000          |

**Nota:** Las fracciones de hora se cuentan como horas completas.

## Compilación y Ejecución

### Requisitos
- Java Development Kit (JDK) 8 o superior
- Compilador javac

### Compilar

Desde la raíz del proyecto:

```bash
# En Windows
javac -d bin -sourcepath src src/com/parqueadero/Principal.java

# En Linux/Mac
javac -d bin -sourcepath src src/com/parqueadero/Principal.java
```

### Ejecutar

```bash
# En Windows
java -cp bin com.parqueadero.Principal

# En Linux/Mac
java -cp bin com.parqueadero.Principal
```

## Ejemplo de Uso

1. Iniciar la aplicación
2. Seleccionar opción 1 para registrar entrada de vehículo
3. Ingresar tipo de vehículo (1-Automóvil, 2-Motocicleta, 3-Camión)
4. Completar información del vehículo
5. Seleccionar opción 2 para registrar salida
6. Ingresar placa y hora de salida
7. Consultar estado del parqueadero (opción 4)

## Conceptos de Programación Orientada a Objetos

### Herencia
- Clase base **Vehiculo** define atributos y métodos comunes
- Las clases **Automovil**, **Motocicleta** y **Camion** heredan de Vehiculo
- Cada clase derivada añade atributos específicos

### Polimorfismo
- Método **calcularTarifa()** es abstracto en Vehiculo
- Cada clase derivada implementa su propia versión
- El tipo de tarifa depende de la clase específica del vehículo

### Encapsulamiento
- Atributos protected en la clase base
- Getters y setters para acceso controlado
- Métodos privados en MenuConsola para operaciones internas

### Composición
- **Parqueadero** contiene una colección de **Vehiculo**
- Relación 1 a muchos entre Parqueadero y Vehiculo

## Métodos Principales

### Clase Vehiculo
- `calcularTarifa(LocalDateTime horaSalida)` - Abstract
- `getTipo()` - Abstract
- `calcularHoras(LocalDateTime horaSalida)` - Protected

### Clase Parqueadero
- `registrarEntrada(Vehiculo vehiculo)` - Registra entrada
- `registrarSalida(String placa, LocalDateTime horaSalida)` - Registra salida y calcula costo
- `buscarVehiculo(String placa)` - Busca vehículo por placa
- `obtenerVehiculosPresentes()` - Retorna lista de vehículos actuales
- `obtenerHistorialSalidas()` - Retorna historial de transacciones
- `calcularIngresoTotal()` - Calcula ingreso total

## Diagrama de Clases UML

Consulte `diagrama_uml.puml` para ver el diagrama completo de clases y sus relaciones.

## Documentación Técnica

Para más información sobre arquitectura, diseño y detalles de implementación, consulte el archivo `docs/Informe_Tecnico.md`.

## Autor
**Alex Esteban Rosero Gualguan**

**GitHub**: [https://github.com/alex33roseroFC](https://github.com/alex33roseroFC)

## Fecha de Creación
2026

## Licencia
Este proyecto es de uso académico.
