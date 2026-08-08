# Guía de Despliegue - Sistema de Gestión de Parqueadero

## Introducción

Este documento proporciona instrucciones detalladas para instalar, configurar y ejecutar el Sistema de Gestión de Parqueadero en diferentes sistemas operativos.

---

## Tabla de Contenidos

1. [Requisitos Previos](#requisitos-previos)
2. [Instalación en Windows](#instalación-en-windows)
3. [Instalación en Linux](#instalación-en-linux)
4. [Instalación en MacOS](#instalación-en-macos)
5. [Verificación de Instalación](#verificación-de-instalación)
6. [Solución de Problemas](#solución-de-problemas)
7. [Configuración Avanzada](#configuración-avanzada)

---

## Requisitos Previos

### Software Mínimo Requerido

| Componente | Versión | Obligatorio |
|------------|---------|------------|
| Java Development Kit (JDK) | 8 o superior | ✅ Sí |
| Git | Cualquiera | ❌ Opcional |
| Terminal/Línea de Comandos | - | ✅ Sí |

### Espacio en Disco

- **Instalación JDK:** ~150 MB
- **Proyecto fuente:** ~2 MB
- **Proyecto compilado:** ~500 KB
- **Documentación:** ~1 MB
- **Total recomendado:** 200 MB

### Requisitos del Hardware

- **Procesador:** 1 GHz o superior
- **Memoria RAM:** 512 MB (mínimo), 2 GB (recomendado)
- **Almacenamiento:** 500 MB libres

---

## Instalación en Windows

### Paso 1: Instalar JDK

#### Opción A: Instalador Oficial (Recomendado)

1. Descargar desde: https://www.oracle.com/java/technologies/downloads/
2. Seleccionar "Java SE 21" (o versión superior)
3. Descargar el instalador para Windows
4. Ejecutar el instalador `.exe`
5. Seguir las instrucciones del asistente
6. **Importante:** Recordar la ruta de instalación (por defecto: `C:\Program Files\Java\jdk-xx`)

#### Opción B: Usando Chocolatey (si tienes Chocolatey instalado)

```powershell
choco install jdk21
```

### Paso 2: Verificar Instalación de Java

1. Abrir PowerShell o Símbolo del Sistema
2. Ejecutar:
```powershell
java -version
javac -version
```

**Resultado esperado:**
```
java version "21.0.x" ...
javac 21.0.x
```

**Si no funciona:**
- Agregar JDK al PATH:
  1. Presionar `Windows + X`, seleccionar "Sistema"
  2. Click en "Configuración avanzada del sistema"
  3. Click en "Variables de entorno"
  4. Crear nueva variable:
     - Nombre: `JAVA_HOME`
     - Valor: `C:\Program Files\Java\jdk-21` (ajustar según tu versión)
  5. Editar variable `Path` y agregar: `%JAVA_HOME%\bin`
  6. Reiniciar la terminal

### Paso 3: Clonar o Descargar el Proyecto

#### Opción A: Con Git

```powershell
cd c:\
git clone <URL-del-repositorio>
cd Gestion_Parqueaderos
```

#### Opción B: Sin Git

1. Descargar ZIP del proyecto
2. Extraer en `C:\Gestion_Parqueaderos`
3. Abrir PowerShell en esa carpeta

### Paso 4: Compilar el Proyecto

```powershell
cd C:\Gestion_Parqueaderos
.\compile.bat
```

**Resultado esperado:**
```
╔════════════════════════════════════════╗
║  COMPILANDO SISTEMA DE GESTIÓN...     ║
║  ✅ COMPILACIÓN EXITOSA               ║
╚════════════════════════════════════════╝
```

### Paso 5: Ejecutar la Aplicación

```powershell
.\run.bat
```

---

## Instalación en Linux

### Paso 1: Instalar JDK

#### Ubuntu/Debian

```bash
sudo apt update
sudo apt install openjdk-21-jdk
```

#### Fedora/RHEL

```bash
sudo dnf install java-21-openjdk-devel
```

#### Arch Linux

```bash
sudo pacman -S jdk-openjdk
```

### Paso 2: Verificar Instalación

```bash
java -version
javac -version
```

### Paso 3: Descargar el Proyecto

```bash
# Opción A: Con Git
git clone <URL-del-repositorio>
cd Gestion_Parqueaderos

# Opción B: Descargar y extraer manualmente
cd ~
wget <URL-del-zip>
unzip Gestion_Parqueaderos.zip
cd Gestion_Parqueaderos
```

### Paso 4: Dar Permisos de Ejecución

```bash
chmod +x compile.sh
chmod +x run.sh
```

### Paso 5: Compilar el Proyecto

```bash
./compile.sh
```

### Paso 6: Ejecutar la Aplicación

```bash
./run.sh
```

---

## Instalación en MacOS

### Paso 1: Instalar JDK

#### Opción A: Usando Homebrew (Recomendado)

```bash
# Instalar Homebrew si no lo tienes
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# Instalar JDK
brew install openjdk@21
```

#### Opción B: Descarga Directa

1. Ir a: https://www.oracle.com/java/technologies/downloads/
2. Descargar versión para macOS
3. Ejecutar el instalador `.dmg`

### Paso 2: Configurar Variables de Entorno

```bash
# Abrir archivo de configuración
nano ~/.zshrc
# O para bash antiguo:
nano ~/.bash_profile

# Agregar estas líneas:
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=$JAVA_HOME/bin:$PATH

# Guardar: Ctrl+O, Enter, Ctrl+X

# Aplicar cambios
source ~/.zshrc
```

### Paso 3: Verificar Instalación

```bash
java -version
javac -version
```

### Paso 4: Descargar el Proyecto

```bash
# Con Git
git clone <URL-del-repositorio>
cd Gestion_Parqueaderos

# O manualmente
cd ~
curl -O <URL-del-zip>
unzip Gestion_Parqueaderos.zip
cd Gestion_Parqueaderos
```

### Paso 5: Dar Permisos

```bash
chmod +x compile.sh
chmod +x run.sh
```

### Paso 6: Compilar y Ejecutar

```bash
# Compilar
./compile.sh

# Ejecutar
./run.sh
```

---

## Verificación de Instalación

### Verificar Java

```bash
# Todos los sistemas
java -version
```

**Debe mostrar:** Version 8 o superior

### Verificar Compilación

Después de ejecutar el script de compilación:

```bash
# Windows
dir bin\com\parqueadero\*.class

# Linux/MacOS
ls -la bin/com/parqueadero/
```

**Debe mostrar:** Al menos 8 archivos `.class`

### Verificar Ejecución

```bash
# Windows
java -cp bin com.parqueadero.Principal

# Linux/MacOS
java -cp bin com.parqueadero.Principal
```

**Debe mostrar:** El menú principal de la aplicación

---

## Solución de Problemas

### Problema 1: "javac: command not found"

**Causa:** Java no está instalado o no está en el PATH

**Solución:**
1. Instalar JDK siguiendo pasos anteriores
2. Reiniciar terminal
3. En Windows, agregar a PATH (ver paso 2)

### Problema 2: "java: command not found"

**Causa:** Mismo que Problema 1

**Solución:** Mismo que Problema 1

### Problema 3: "ClassNotFoundException: com.parqueadero.Principal"

**Causa:** No se compiló correctamente o claspath incorrecto

**Solución:**
```bash
# Limpiar y recompilar
rm -rf bin/  # Linux/MacOS
rmdir /s /q bin  # Windows
./compile.bat  # Windows o
./compile.sh   # Linux/MacOS
```

### Problema 4: "No hay espacio disponible en el parqueadero"

**Causa:** Capacidad máxima alcanzada (30 vehículos)

**Solución:**
- Registrar la salida de algunos vehículos
- Ver opción 2 del menú

### Problema 5: Error de Formato de Fecha

**Causa:** Formato de fecha incorrecto

**Solución:**
- Usar formato: `yyyy-MM-dd HH:mm`
- Ejemplo: `2026-08-07 14:30`
- Dejar en blanco para usar hora actual

### Problema 6: Script no ejecuta en Linux/MacOS

**Causa:** No tiene permisos de ejecución

**Solución:**
```bash
chmod +x compile.sh
chmod +x run.sh
```

### Problema 7: "Permission denied"

**Causa:** Falta de permisos para escribir en directorio

**Solución:**
```bash
# Linux/MacOS - cambiar permisos
chmod -R 755 .

# O instalar en directorio del usuario
cd ~
mkdir Parqueadero
cd Parqueadero
# copiar archivos aquí
```

---

## Configuración Avanzada

### Aumentar Memoria de la JVM

Si experimentas problemas de memoria:

```bash
# Aumentar a 1GB
java -Xmx1024m -cp bin com.parqueadero.Principal

# Aumentar a 512MB (recomendado para uso normal)
java -Xmx512m -Xms256m -cp bin com.parqueadero.Principal
```

### Crear Ejecutable (Windows)

Crear archivo `parqueadero.bat`:

```batch
@echo off
cd /d %~dp0
java -Xmx512m -cp bin com.parqueadero.Principal
pause
```

Usar: hacer doble click en `parqueadero.bat`

### Crear Ejecutable (Linux)

Crear archivo `parqueadero.sh`:

```bash
#!/bin/bash
cd "$(dirname "$0")"
java -Xmx512m -cp bin com.parqueadero.Principal
```

Usar:
```bash
chmod +x parqueadero.sh
./parqueadero.sh
```

### Usar Variables de Entorno

```bash
# Windows - Crear variable PARQUEO_HOME
setx PARQUEO_HOME "c:\Gestion_Parqueaderos"
java -cp %PARQUEO_HOME%\bin com.parqueadero.Principal

# Linux/MacOS - Agregar a ~/.bashrc o ~/.zshrc
export PARQUEO_HOME="$HOME/Gestion_Parqueaderos"
java -cp $PARQUEO_HOME/bin com.parqueadero.Principal
```

### Compilación con Opciones

```bash
# Compilación con warnings detallados
javac -d bin -sourcepath src -Xlint:all src/com/parqueadero/Principal.java

# Compilación con source y target específicos
javac -d bin -source 11 -target 11 -sourcepath src src/com/parqueadero/Principal.java
```

---

## Mantenimiento

### Limpiar Archivos Compilados

```bash
# Windows
rmdir /s /q bin

# Linux/MacOS
rm -rf bin
```

### Crear Archivo JAR

```bash
# Compilar primero
./compile.bat  # o compile.sh

# Crear JAR
jar cfe parqueadero.jar com.parqueadero.Principal -C bin .

# Ejecutar JAR
java -jar parqueadero.jar
```

### Actualizar Proyecto

```bash
# Si estás usando Git
git pull origin main

# Recompilar
./compile.bat  # o compile.sh
```

---

## Checklist de Instalación

- [ ] JDK 8+ instalado
- [ ] `java -version` muestra versión correcta
- [ ] `javac -version` muestra versión correcta
- [ ] Proyecto descargado/clonado
- [ ] Script de compilación ejecutado sin errores
- [ ] Carpeta `bin` creada con archivos `.class`
- [ ] Aplicación ejecuta correctamente
- [ ] Menú principal se muestra

---

## Próximos Pasos

Después de la instalación exitosa:

1. Leer la [Guía Rápida](GUIA_RAPIDA.md)
2. Consultar el [Informe Técnico](docs/Informe_Tecnico.md)
3. Explorar el [Código Fuente](src/)
4. Probar las funcionalidades del sistema

---

## Soporte

Si encuentras problemas:

1. Consulta la sección de [Solución de Problemas](#solución-de-problemas)
2. Verifica que cumples con los [Requisitos Previos](#requisitos-previos)
3. Revisa los logs de compilación
4. Intenta reinstalar Java

---

**Documento Actualizado:** Agosto 7, 2026
**Versión:** 1.0.0
