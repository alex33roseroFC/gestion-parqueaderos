@echo off
REM Script de compilación para el Sistema de Gestión de Parqueadero
REM Estructura simplificada sin paquetes com.parqueadero

echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║  COMPILANDO SISTEMA DE GESTIÓN DE PARQUEADERO                  ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

REM Crear carpeta de destino si no existe
if not exist bin mkdir bin

REM Compilar todos los archivos Java de forma simple
echo Compilando archivos Java...
javac -d bin src\modelo\*.java src\gestion\*.java src\ui\*.java src\*.java 2>nul
if errorlevel 1 goto :error

echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║  ✅ COMPILACIÓN EXITOSA                                        ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.
echo Para ejecutar la aplicación, use:
echo   java -cp bin Principal
echo.
pause
exit /b 0

:error
echo.
echo ❌ Error al compilar los archivos Java
echo.
pause
exit /b 1
