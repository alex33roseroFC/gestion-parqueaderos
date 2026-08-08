# 📚 Índice de Documentación - Sistema de Gestión de Parqueadero

## 🎯 Inicio Rápido

**Si tienes prisa, lee en este orden:**

1. ⏱️ **5 minutos:** [Guía Rápida](GUIA_RAPIDA.md) - Compilar y ejecutar
2. 📖 **15 minutos:** [README](README.md) - Descripción del proyecto
3. 🚀 **10 minutos:** Prueba el sistema

---

## 📚 Documentación Completa

### Para Usuarios

| Documento | Duración | Contenido |
|-----------|----------|----------|
| [GUIA_RAPIDA.md](GUIA_RAPIDA.md) | 5-10 min | Cómo compilar y ejecutar |
| [README.md](README.md) | 10-15 min | Descripción general del proyecto |
| [DESPLIEGUE.md](DESPLIEGUE.md) | 20-30 min | Instalación en diferentes SO |

### Para Desarrolladores

| Documento | Duración | Contenido |
|-----------|----------|----------|
| [Informe_Tecnico.md](docs/Informe_Tecnico.md) | 30-45 min | Análisis técnico completo |
| [CONFIGURACION.md](CONFIGURACION.md) | 10-15 min | Estructura técnica del proyecto |
| [ESTRUCTURA.md](ESTRUCTURA.md) | 10-15 min | Árbol de directorios y patrones |

### Diagramas

| Documento | Formato | Contenido |
|-----------|---------|----------|
| [diagrama_uml.puml](diagrama_uml.puml) | PlantUML | Diagrama de clases UML |

---

## 🗺️ Navegación por Rol

### 👨‍💼 Ejecutivo / Tutor
**Tiempo recomendado:** 10 minutos

1. Leer resumen ejecutivo en [README.md](README.md#descripción)
2. Ver diagrama UML en [diagrama_uml.puml](diagrama_uml.puml)
3. Revisar [Informe_Tecnico.md - Conclusiones](docs/Informe_Tecnico.md#conclusiones)

### 👨‍🎓 Estudiante
**Tiempo recomendado:** 45-60 minutos

1. [GUIA_RAPIDA.md](GUIA_RAPIDA.md) - Cómo usar
2. [README.md](README.md) - Características
3. [Informe_Tecnico.md](docs/Informe_Tecnico.md) - Conceptos POO
4. [ESTRUCTURA.md](ESTRUCTURA.md) - Organización del código
5. Explorar código fuente en `src/`

### 👨‍💻 Programador/Desarrollador
**Tiempo recomendado:** 90-120 minutos

1. [DESPLIEGUE.md](DESPLIEGUE.md) - Instalación
2. [CONFIGURACION.md](CONFIGURACION.md) - Detalles técnicos
3. [Informe_Tecnico.md](docs/Informe_Tecnico.md) - Arquitectura
4. [ESTRUCTURA.md](ESTRUCTURA.md) - Organización
5. Revisar código fuente completo
6. Explorar [diagrama_uml.puml](diagrama_uml.puml)

---

## 📂 Estructura de Documentación

```
Documentación/
│
├── 🚀 INICIO (Empieza aquí)
│   └── GUIA_RAPIDA.md
│
├── 📖 GENERAL
│   ├── README.md
│   └── INDICE.md (este archivo)
│
├── 🔧 INSTALACIÓN Y CONFIGURACIÓN
│   ├── DESPLIEGUE.md
│   └── CONFIGURACION.md
│
├── 🏗️ ARQUITECTURA Y DISEÑO
│   ├── ESTRUCTURA.md
│   ├── diagrama_uml.puml
│   └── docs/Informe_Tecnico.md
│
└── 📝 CÓDIGO FUENTE
    ├── src/com/parqueadero/modelo/
    ├── src/com/parqueadero/gestion/
    ├── src/com/parqueadero/ui/
    └── src/com/parqueadero/Principal.java
```

---

## 🎓 Conceptos Clave Documentados

### Herencia
- **Clase Base:** `Vehiculo` (abstracta)
- **Clases Derivadas:** `Automovil`, `Motocicleta`, `Camion`
- **Documentación:** [Informe_Tecnico.md#concepto-de-herencia-y-polimorfismo](docs/Informe_Tecnico.md#concepto-de-herencia-y-polimorfismo)

### Polimorfismo
- **Método Abstracto:** `calcularTarifa()`
- **Implementaciones:** Una por cada tipo de vehículo
- **Documentación:** Mismo enlace anterior

### Encapsulamiento
- **Atributos Protected:** En clase base
- **Métodos Private:** En MenuConsola
- **Getters/Setters:** En todas las clases
- **Documentación:** [Informe_Tecnico.md#análisis-de-clases](docs/Informe_Tecnico.md#análisis-de-clases)

### Composición
- **Parqueadero contiene:** Colección de Vehiculo
- **Documentación:** [ESTRUCTURA.md#jerarquía-de-clases](ESTRUCTURA.md#jerarquía-de-clases)

---

## 📋 Checklist de Lectura

### Lectura Esencial (Obligatoria)
- [ ] [GUIA_RAPIDA.md](GUIA_RAPIDA.md)
- [ ] [README.md](README.md)
- [ ] [Informe_Tecnico.md](docs/Informe_Tecnico.md) - Secciones 1-7

### Lectura Recomendada (Muy Útil)
- [ ] [DESPLIEGUE.md](DESPLIEGUE.md)
- [ ] [CONFIGURACION.md](CONFIGURACION.md)
- [ ] [ESTRUCTURA.md](ESTRUCTURA.md)
- [ ] [diagrama_uml.puml](diagrama_uml.puml)

### Lectura Adicional (Complementaria)
- [ ] [Informe_Tecnico.md](docs/Informe_Tecnico.md) - Secciones 8-12
- [ ] Código fuente comentado en `src/`

---

## 🔍 Búsqueda Rápida de Temas

### "¿Cómo uso el sistema?"
👉 [GUIA_RAPIDA.md](GUIA_RAPIDA.md)

### "¿Cómo lo instalo?"
👉 [DESPLIEGUE.md](DESPLIEGUE.md)

### "¿Cuál es la estructura del proyecto?"
👉 [ESTRUCTURA.md](ESTRUCTURA.md)

### "¿Cómo compilar?"
👉 [GUIA_RAPIDA.md#inicio-rápido](GUIA_RAPIDA.md#inicio-rápido)

### "¿Cuáles son los requisitos de sistema?"
👉 [DESPLIEGUE.md#requisitos-previos](DESPLIEGUE.md#requisitos-previos)

### "¿Cómo funciona la herencia?"
👉 [Informe_Tecnico.md#concepto-de-herencia-y-polimorfismo](docs/Informe_Tecnico.md#concepto-de-herencia-y-polimorfismo)

### "¿Cuál es el diagrama UML?"
👉 [diagrama_uml.puml](diagrama_uml.puml) o [Informe_Tecnico.md#diagrama-de-clases-uml](docs/Informe_Tecnico.md#diagrama-de-clases-uml)

### "¿Cuáles son las tarifas?"
👉 [README.md#tarifas-por-vehículo](README.md#tarifas-por-vehículo)

### "¿Tengo un error, qué hago?"
👉 [DESPLIEGUE.md#solución-de-problemas](DESPLIEGUE.md#solución-de-problemas)

### "¿Cómo extender el proyecto?"
👉 [Informe_Tecnico.md#posibles-mejoras-futuras](docs/Informe_Tecnico.md#posibles-mejoras-futuras)

---

## 🎯 Objetivos Documentales

Esta documentación cumple con:

- ✅ Explicar qué hace el sistema
- ✅ Mostrar cómo instalarlo
- ✅ Demostrar cómo usarlo
- ✅ Profundizar en conceptos POO
- ✅ Detallar la arquitectura
- ✅ Proporcionar ejemplos
- ✅ Facilitar troubleshooting
- ✅ Permitir extensiones futuras

---

## 📊 Estadísticas de Documentación

| Métrica | Cantidad |
|---------|----------|
| Archivos de documentación | 7 |
| Líneas de documentación | 3000+ |
| Diagramas | 1 (UML) |
| Ejemplos de uso | 5+ |
| Procedimientos paso-a-paso | 8+ |
| Soluciones de problemas | 7+ |
| Tablas informativas | 20+ |

---

## 🚀 Próximos Pasos Después de Leer

1. **Compila el proyecto:**
   ```bash
   ./compile.bat  # Windows o
   ./compile.sh   # Linux/MacOS
   ```

2. **Ejecuta la aplicación:**
   ```bash
   ./run.bat      # Windows o
   ./run.sh       # Linux/MacOS
   ```

3. **Prueba las funcionalidades:**
   - Registra un vehículo
   - Registra su salida
   - Verifica los costos calculados

4. **Estudia el código:**
   - Observa la herencia en `src/com/parqueadero/modelo/`
   - Entiende el polimorfismo en `Vehiculo.calcularTarifa()`
   - Revisa la gestión en `src/com/parqueadero/gestion/Parqueadero.java`

---

## ❓ Preguntas Frecuentes

**P: ¿Cuánto tiempo toma aprender este proyecto?**
R: 1-2 horas para entender completamente. 30 minutos para solo usar.

**P: ¿Necesito saber Java avanzado?**
R: No, es un proyecto educativo de nivel básico-intermedio.

**P: ¿Puedo modificar el código?**
R: Sí, ese es el objetivo. Está diseñado para ser extensible.

**P: ¿Qué licencia tiene?**
R: Académico, para uso educativo.

**P: ¿Puedo usarlo como base para otro proyecto?**
R: Sí, está diseñado para eso.

---

## 📞 Información de Contacto

Para dudas sobre el proyecto:
- Consulta la documentación
- Revisa la sección de troubleshooting
- Estudia el código comentado

---

## 📅 Historial de Cambios

| Versión | Fecha | Cambios |
|---------|-------|---------|
| 1.0.0 | 2026-08-07 | Versión inicial |

---

## 🎓 Créditos

**Proyecto:** Sistema de Gestión de Parqueadero
**Tipo:** Educativo - Actividad 3 POO
**Institución:** [Nombre de tu institución]
**Estudiante:** [Tu nombre]

---

**Documento Maestro de Documentación**
Última actualización: Agosto 7, 2026

---

## 🎬 ¡Comenzar Ahora!

### Opción 1: Usuario Nuevonínio (Primero instalar)
1. Lee: [DESPLIEGUE.md](DESPLIEGUE.md)
2. Lee: [GUIA_RAPIDA.md](GUIA_RAPIDA.md)
3. Ejecuta: `./compile.bat` o `./compile.sh`

### Opción 2: Ya tienes Java instalado
1. Lee: [GUIA_RAPIDA.md](GUIA_RAPIDA.md)
2. Ejecuta: `./compile.bat` o `./compile.sh`
3. Ejecuta: `./run.bat` o `./run.sh`

### Opción 3: Quiero aprender el código
1. Lee: [Informe_Tecnico.md](docs/Informe_Tecnico.md)
2. Estudia: `src/com/parqueadero/`
3. Revisa: [diagrama_uml.puml](diagrama_uml.puml)

---

¡Que disfrutes aprendiendo sobre Programación Orientada a Objetos! 🎉
