#!/bin/bash

# Script de ejecución para el Sistema de Gestión de Parqueadero
# Estructura simplificada

echo ""
echo "╔════════════════════════════════════════════════════════════════╗"
echo "║  INICIANDO SISTEMA DE GESTIÓN DE PARQUEADERO                   ║"
echo "╚════════════════════════════════════════════════════════════════╝"
echo ""

# Verificar que la carpeta bin existe
if [ ! -d "bin" ]; then
    echo "❌ Carpeta 'bin' no encontrada."
    echo "Debe compilar primero usando: ./compile.sh"
    echo ""
    exit 1
fi

# Ejecutar la aplicación
java -cp bin Principal

if [ $? -ne 0 ]; then
    echo ""
    echo "❌ Error al ejecutar la aplicación"
    echo ""
    exit 1
fi
