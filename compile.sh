#!/bin/bash

# Script de compilación para el Sistema de Gestión de Parqueadero
# Estructura simplificada sin paquetes com.parqueadero

echo ""
echo "╔════════════════════════════════════════════════════════════════╗"
echo "║  COMPILANDO SISTEMA DE GESTIÓN DE PARQUEADERO                  ║"
echo "╚════════════════════════════════════════════════════════════════╝"
echo ""

# Crear carpeta de destino si no existe
mkdir -p bin

# Compilar todos los archivos Java de forma simple
echo "Compilando archivos Java..."
javac -d bin src/modelo/*.java src/gestion/*.java src/ui/*.java src/*.java 2>/dev/null

if [ $? -ne 0 ]; then
    echo ""
    echo "❌ Error al compilar los archivos Java"
    echo ""
    exit 1
fi

echo ""
echo "╔════════════════════════════════════════════════════════════════╗"
echo "║  ✅ COMPILACIÓN EXITOSA                                        ║"
echo "╚════════════════════════════════════════════════════════════════╝"
echo ""
echo "Para ejecutar la aplicación, use:"
echo "  java -cp bin Principal"
echo ""
