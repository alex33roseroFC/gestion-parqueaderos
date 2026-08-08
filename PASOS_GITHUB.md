# 📤 Pasos para Subir a GitHub

## 🎯 Requisitos Previos

1. **Git instalado** en tu computadora
   - Descarga desde: https://git-scm.com/download/win
   
2. **Cuenta de GitHub** creada
   - Ve a: https://github.com/signup

3. **Repositorio creado en GitHub**
   - En tu perfil de GitHub, crea un nuevo repositorio llamado `gestion-parqueaderos`

---

## 📋 PASO 1: Configurar Git (Primera vez)

Abre PowerShell o Command Prompt y ejecuta:

```powershell
git config --global user.name "Alex Esteban Rosero Gualguan"
git config --global user.email "tu-email@example.com"
```

---

## 📋 PASO 2: Inicializar el Repositorio Local

Navega a la carpeta del proyecto:

```powershell
cd c:\Gestion_Parqueaderos
```

Inicializa Git:

```powershell
git init
```

---

## 📋 PASO 3: Agregar Archivos

Añade TODOS los archivos del proyecto:

```powershell
git add .
```

**Verifica qué se agregó:**

```powershell
git status
```

---

## 📋 PASO 4: Crear el Primer Commit

```powershell
git commit -m "Proyecto inicial: Sistema de Gestión de Parqueadero

- Implementación de herencia y polimorfismo en Java
- Interfaz gráfica con Swing
- Gestión de vehículos y tarifas
- Historial completo de transacciones
- Capacidad: 40 vehículos"
```

---

## 📋 PASO 5: Conectar con GitHub

**OPCIÓN A: Usando HTTPS (Más Fácil)**

Copia la URL de tu repositorio de GitHub (algo como: `https://github.com/tu-usuario/gestion-parqueaderos.git`)

Luego ejecuta:

```powershell
git remote add origin https://github.com/tu-usuario/gestion-parqueaderos.git
git branch -M main
git push -u origin main
```

**OPCIÓN B: Usando SSH (Más Seguro - Requiere configuración)**

Si ya tienes SSH configurado:

```powershell
git remote add origin git@github.com:tu-usuario/gestion-parqueaderos.git
git branch -M main
git push -u origin main
```

---

## 📋 PASO 6: Autenticación

Cuando ejecutes `git push`, Git te pedirá autenticación:

**Para HTTPS:**
- Usuario: Tu nombre de usuario de GitHub
- Contraseña: Tu Token de GitHub (no tu contraseña)

Para crear un Token:
1. Ve a: https://github.com/settings/tokens
2. Click en "Generate new token"
3. Dale permiso a "repo"
4. Copia el token y úsalo como contraseña

**Para SSH:**
- Git te pedirá tu passphrase (si configuraste una)

---

## 📋 PASO 7: Verificar que se Subió

Visita: `https://github.com/tu-usuario/gestion-parqueaderos`

Deberías ver todos tus archivos en GitHub ✅

---

## 📝 Comandos Posteriores (Para Actualizar el Proyecto)

Cada vez que hagas cambios:

```powershell
# Ver qué cambió
git status

# Agregar cambios
git add .

# Hacer commit
git commit -m "Descripción de los cambios"

# Subir a GitHub
git push
```

---

## 🔧 Troubleshooting

### Error: "fatal: not a git repository"
**Solución**: Ejecuta `git init` primero

### Error: "Permission denied (publickey)"
**Solución**: Usa HTTPS en lugar de SSH, o configura tu SSH key correctamente

### Error: "Authentication failed"
**Solución**: Verifica tu usuario/contraseña o usa un Token en lugar de contraseña

### Quiero cambiar la URL remota
```powershell
git remote set-url origin https://github.com/tu-usuario/nuevo-repositorio.git
```

---

## 📊 Estructura del Repositorio en GitHub

Tu repositorio se verá así:

```
gestion-parqueaderos/
├── src/
│   ├── modelo/
│   │   ├── Vehiculo.java
│   │   ├── Automovil.java
│   │   ├── Motocicleta.java
│   │   └── Camion.java
│   ├── gestion/
│   │   └── Parqueadero.java
│   ├── ui/
│   │   ├── InterfazGrafica.java
│   │   └── MenuConsola.java
│   └── Principal.java
├── bin/
├── compile.bat
├── compile.sh
├── run.bat
├── run.sh
├── .gitignore
├── README.md
├── GUIA_RAPIDA.md
├── Informe_Tecnico.md
└── diagrama_uml.puml
```

---

## ✨ Archivo .gitignore (Ya Debe Estar)

Para evitar subir archivos innecesarios, verifica que exista `.gitignore` con:

```
*.class
*.jar
bin/
target/
.vscode/
.idea/
*.swp
*.swo
*~
.DS_Store
```

---

## 🎉 ¡LISTO!

Una vez subido, tu proyecto estará disponible en:

```
https://github.com/alex33roseroFC/gestion-parqueaderos
```

Y podrás compartir el link con tus profesores y compañeros. ✅

---

## 📞 Comandos Útiles

```powershell
# Ver historial de cambios
git log

# Ver cambios sin hacer commit
git diff

# Deshacer cambios en un archivo
git checkout -- nombre-archivo.java

# Ver ramas disponibles
git branch

# Crear una nueva rama
git checkout -b nombre-rama
```

---

**¡Éxito subiendo tu proyecto! 🚀**
