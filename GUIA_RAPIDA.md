# Guía Rápida de Inicio

## 🎓 Información del Proyecto

**Institución**: Universidad EAN
**Materia**: Desarrollo de Software - Grupo 1 - Tercer Ciclo - 2026
**Estudiante**: Alex Esteban Rosero Gualguan
**Carrera**: Ingeniería de Sistemas
**Versión**: 2026 Agosto
**GitHub**: [https://github.com/alex33roseroFC](https://github.com/alex33roseroFC)

---

## 🚀 Inicio Rápido (3 pasos)

### Paso 1: Compilar el Proyecto

**En Windows:**
```bash
compile.bat
```

**En Linux/MacOS:**
```bash
chmod +x compile.sh
./compile.sh
```

### Paso 2: Ejecutar la Aplicación

**En Windows:**
```bash
run.bat
```

**En Linux/MacOS:**
```bash
chmod +x run.sh
./run.sh
```

### Paso 3: Usar el Sistema

El menú principal te mostrará las opciones disponibles.

---

## 📋 Estructura de Directorios

```
Gestion_Parqueaderos/
├── src/                          # Código fuente
│   └── com/parqueadero/
│       ├── modelo/              # Clases de vehículos
│       ├── gestion/             # Gestión de parqueadero
│       ├── ui/                  # Interfaz de usuario
│       └── Principal.java       # Punto de entrada
├── bin/                         # Clases compiladas
├── docs/                        # Documentación
├── compile.bat/.sh              # Script de compilación
├── run.bat/.sh                  # Script de ejecución
├── diagrama_uml.puml            # Diagrama UML
├── README.md                    # Información del proyecto
└── GUIA_RAPIDA.md              # Este archivo
```

---

## 💡 Ejemplos de Uso Común

### Registrar un Vehículo

1. Selecciona opción **1** del menú
2. Elige el tipo de vehículo (1-3)
3. Ingresa los datos solicitados
4. El sistema confirmará el registro

### Registrar Salida

1. Selecciona opción **2** del menú
2. Ingresa la placa del vehículo
3. Confirma la hora de salida
4. Se mostrará automáticamente el costo

### Consultar Estado

1. Selecciona opción **4** para ver resumen
2. O opción **3** para listar todos los vehículos
3. O opción **5** para ver historial de salidas

---

## 🔧 Requisitos

- **Java Development Kit (JDK)** 8 o superior
- **Línea de comandos / Terminal**

### Verificar si tienes Java instalado

```bash
java -version
javac -version
```

---

## ❌ Solución de Problemas

### "javac: command not found"
- Instala el JDK
- Agrega el bin del JDK al PATH del sistema

### "ClassNotFoundException"
- Asegúrate de haber compilado primero
- Verifica que la carpeta `bin` contiene los archivos `.class`

### "No hay espacio disponible"
- El parqueadero tiene capacidad máxima de 30 vehículos
- Registra la salida de algunos vehículos

---

## 📊 Tarifas

| Vehículo | Tarifa/Hora |
|----------|-------------|
| Motocicleta | $2,000 |
| Automóvil | $5,000 |
| Camión | $8,000 |

Las fracciones de hora se redondean hacia arriba.

---

## 📝 Datos de Prueba

### Automóvil de Ejemplo
- Placa: ABC-1234
- Marca: Toyota
- Modelo: Corolla
- Combustible: Gasolina
- Hora entrada: 2026-08-07 10:00
- Hora salida: 2026-08-07 13:30
- **Costo esperado: $15,000** (3.5h → 4h × $5,000)

### Motocicleta de Ejemplo
- Placa: XYZ-5678
- Marca: Honda
- Modelo: CB500
- Cilindraje: 500
- Hora entrada: 2026-08-07 11:00
- Hora salida: 2026-08-07 12:45
- **Costo esperado: $4,000** (1.75h → 2h × $2,000)

### Camión de Ejemplo
- Placa: CAM-9012
- Marca: Volvo
- Modelo: FH16
- Capacidad: 20 toneladas
- Hora entrada: 2026-08-07 09:00
- Hora salida: 2026-08-07 10:15
- **Costo esperado: $8,000** (1.25h → 2h × $8,000)

---

## 🎓 Concepto Pedagógico

Este proyecto demuestra:
- **Herencia:** Las clases Automóvil, Motocicleta y Camión heredan de Vehiculo
- **Polimorfismo:** Cada tipo de vehículo calcula su tarifa de forma diferente
- **Encapsulamiento:** Atributos privados/protegidos con acceso controlado
- **Composición:** Parqueadero contiene una colección de Vehiculos

---

## 📖 Documentación Adicional

- **Informe Técnico:** `docs/Informe_Tecnico.md`
- **Diagrama UML:** `diagrama_uml.puml`
- **README Completo:** `README.md`

---

## 💬 Menú de Opciones

```
1. Registrar entrada de vehículo
2. Registrar salida de vehículo
3. Consultar vehículos presentes
4. Ver estado del parqueadero
5. Ver historial de salidas
6. Buscar vehículo por placa
7. Salir
```

---

**¡Que disfrutes usando el Sistema de Gestión de Parqueadero!** 🚗🏍️🚚
