@echo off
REM Script de ejecución para el Sistema de Gestión de Parqueadero
REM Estructura simplificada

echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║  INICIANDO SISTEMA DE GESTIÓN DE PARQUEADERO                   ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

REM Verificar que la carpeta bin existe
if not exist bin (
    echo ❌ Carpeta 'bin' no encontrada. 
    echo Debe compilar primero usando: compile.bat
    echo.
    pause
    exit /b 1
)

REM Ejecutar la aplicación
java -cp bin Principal

if errorlevel 1 (
    echo.
    echo ❌ Error al ejecutar la aplicación
    echo.
    pause
    exit /b 1
)

pause
