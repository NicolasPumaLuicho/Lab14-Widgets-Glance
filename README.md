# Laboratorio 14 - Widgets con Jetpack Glance

Aplicación Android en Kotlin con Jetpack Compose que agrega dos widgets de pantalla de inicio
usando Jetpack Glance.

## Funcionalidad

- Pantalla principal con el contador de películas vistas.
- Segunda pantalla con el resumen del contador y las últimas acciones.
- Widget guiado: accesos directos a la pantalla principal y al resumen.
- Widget personalizado: muestra el contador en tiempo real y permite sumar una película
  desde el propio widget.

## Estructura

- `MainActivity`: pantalla principal.
- `SecondActivity`: vista secundaria que se abre desde el widget.
- `ui/MainScreen.kt` y `ui/SummaryScreen.kt`: pantallas en Compose.
- `data/MovieStore.kt`: contador compartido en SharedPreferences.
- `widget/SimpleWidget.kt`: widget de accesos directos (Glance).
- `widget/MovieWidget.kt`: widget personalizado con contador y acción.

## Ejecución

1. Abrir el proyecto en Android Studio.
2. Sincronizar Gradle y ejecutar en un emulador o dispositivo con Android 7.0 o superior.
3. Mantener presionada la pantalla de inicio, entrar a Widgets y agregar "MovieCounter".

## Compilación por consola

```bash
./gradlew assembleDebug -Dorg.gradle.java.home="C:\Program Files\Eclipse Adoptium\jdk-17.0.21.9-hotspot"
```
