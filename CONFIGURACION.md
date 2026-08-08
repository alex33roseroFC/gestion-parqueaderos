# Configuración del Proyecto - Sistema de Gestión de Parqueadero

## Información del Proyecto

**Nombre:** Sistema de Gestión de Parqueadero
**Versión:** 1.0.0
**Descripción:** Sistema educativo de gestión de parqueadero con herencia y polimorfismo
**Autor:** [Nombre del Estudiante]
**Institución:** [Nombre de la Institución]
**Asignatura:** Programación Orientada a Objetos
**Actividad:** 3 - Resolución de Problemas usando Herencia

## Configuración Técnica

### Java
- **Versión Mínima:** 8
- **Versión Objetivo:** 8+
- **Codificación:** UTF-8

### Paquetes Principales

#### com.parqueadero.modelo
Clases que representan las entidades del dominio.

| Clase | Descripción |
|-------|-------------|
| `Vehiculo` | Clase base abstracta |
| `Automovil` | Hereda de Vehiculo |
| `Motocicleta` | Hereda de Vehiculo |
| `Camion` | Hereda de Vehiculo |

#### com.parqueadero.gestion
Clases encargadas de la lógica de negocio.

| Clase | Descripción |
|-------|-------------|
| `Parqueadero` | Gestión de vehículos |
| `RegistroVehiculo` | Registro de transacciones |

#### com.parqueadero.ui
Interfaz de usuario.

| Clase | Descripción |
|-------|-------------|
| `MenuConsola` | Menú interactivo |

#### com.parqueadero
Punto de entrada de la aplicación.

| Clase | Descripción |
|-------|-------------|
| `Principal` | Método main |

## Compilación

### Archivos Fuente
- Total: 9 archivos Java
- Líneas de código: ~2,000+

### Proceso de Compilación

```
Source (.java) ──→ Compilador (javac) ──→ Bytecode (.class)
src/             ──→ Javac              ──→ bin/
```

### Dependencias
- No hay dependencias externas
- Solo usa librerías estándar de Java

### Carpetas Generadas
```
bin/                                    # Clases compiladas
├── com/
│   └── parqueadero/
│       ├── modelo/
│       │   ├── Vehiculo.class
│       │   ├── Automovil.class
│       │   ├── Motocicleta.class
│       │   └── Camion.class
│       ├── gestion/
│       │   └── Parqueadero.class
│       │   └── Parqueadero$RegistroVehiculo.class
│       ├── ui/
│       │   └── MenuConsola.class
│       └── Principal.class
```

## Ejecución

### Comando Base
```bash
java -cp bin com.parqueadero.Principal
```

### Variables JVM Recomendadas
- `-Xmx512m` Memoria máxima: 512 MB
- `-Xms256m` Memoria inicial: 256 MB

### Ejemplo con Opciones
```bash
java -Xmx512m -Xms256m -cp bin com.parqueadero.Principal
```

## Estructura de Directorios

```
Gestion_Parqueaderos/
│
├── src/                              # Código fuente
│   └── com/parqueadero/
│       ├── modelo/
│       │   ├── Vehiculo.java
│       │   ├── Automovil.java
│       │   ├── Motocicleta.java
│       │   └── Camion.java
│       ├── gestion/
│       │   └── Parqueadero.java
│       ├── ui/
│       │   └── MenuConsola.java
│       └── Principal.java
│
├── bin/                              # Clases compiladas (generado)
│   └── com/parqueadero/...
│
├── docs/                             # Documentación
│   └── Informe_Tecnico.md
│
├── compile.bat                       # Script compilación (Windows)
├── compile.sh                        # Script compilación (Unix)
├── run.bat                          # Script ejecución (Windows)
├── run.sh                           # Script ejecución (Unix)
│
├── diagrama_uml.puml                # Diagrama UML
├── README.md                        # Información general
├── GUIA_RAPIDA.md                   # Guía de inicio rápido
├── CONFIGURACION.md                 # Este archivo
└── .gitignore                       # Configuración de Git

Total: 21 archivos
```

## Características de Compilación

### Scripts Inteligentes
- Validación de errores
- Creación automática de carpetas
- Mensajes de progreso
- Manejo de errores

### Compilación por Componentes
1. Modelo (Vehiculo y subclases)
2. Gestión (Parqueadero)
3. UI e Principal

## Requisitos de Desarrollo

### Software
- JDK 8 o superior
- Editor de texto o IDE (VS Code recomendado)
- Git (opcional, para versionado)

### Hardware Mínimo
- RAM: 512 MB
- Espacio en disco: 100 MB
- Procesador: 1 GHz

## Configuración de IDE (VS Code)

### Extensiones Recomendadas
- Extension Pack for Java (Microsoft)
- Code Runner (Jun Han)
- Better Comments

### Configuración launch.json
```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "name": "Launch Parqueadero",
            "type": "java",
            "name": "Launch Principal",
            "request": "launch",
            "mainClass": "com.parqueadero.Principal",
            "projectName": "Gestion_Parqueaderos",
            "cwd": "${workspaceFolder}"
        }
    ]
}
```

## Problemas Conocidos y Soluciones

| Problema | Causa | Solución |
|----------|-------|----------|
| ClassNotFoundException | Classpath incorrecto | Usar `-cp bin` |
| No hay espacios | Capacidad llena | Registrar salidas |
| Formato de fecha inválido | Formato incorrecto | Usar `yyyy-MM-dd HH:mm` |

## Mejoras Futuras

- [ ] Integración con base de datos
- [ ] API REST
- [ ] Interfaz gráfica (Swing/JavaFX)
- [ ] Sistema de tarificación dinámico
- [ ] Reportes avanzados

## Control de Versiones

### .gitignore configurado para:
- *.class (archivos compilados)
- *.jar (archivos empaquetados)
- out/ (salida del IDE)
- target/ (salida de Maven)
- .vscode/ (configuración VS Code)
- .idea/ (configuración IntelliJ)

## Licencia

Proyecto académico para uso educativo.

---

**Última actualización:** Agosto 7, 2026
