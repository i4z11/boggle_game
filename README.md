# Boggle Android (Java)

Juego de mesa clásico **Boggle** adaptado para dispositivos móviles Android, desarrollado en Java utilizando vistas XML tradicionales (Programación Orientada a Objetos).

---

## 👥 Modo de Juego
- **Multijugador local (2 jugadores):** Se juega en un solo celular, pasándoselo por turnos (150 segundos por ronda). Cada jugador juega el mismo tablero aleatorio. Al finalizar, el rival valida o descarta las palabras formadas comprobando el recorrido en el tablero.
- **Modo Práctica (1 jugador):** Práctica libre con temporizador y registro de récord guardado en el dispositivo.

---

## 🗺️ Hoja de Ruta y Versiones del Proyecto

| Versión | Estado | Descripción de lo Logrado |
| :--- | :--- | :--- |
| **v0.1.0** | ✅ Completado | Configuración inicial del proyecto en Android Studio, estructura de paquetes y plantilla base. |
| **v0.2.0** | ✅ Completado | Creación de la clase `Tablero.java` con el sistema de 16 dados en español y mezcla aleatoria. |
| **v0.3.0** | ✅ Completado | Diseño del tablero visual en `activity_main.xml` (grilla 4x4) y conexión con `MainActivity.java`. |
| **v0.4.0** | ✅ Completado | Creación de la clase `Casilla.java` y desarrollo del algoritmo de vecindad (`esVecina`). |
| **v0.5.0** | ✅ Completado | Creación de la clase `Palabra.java` con validación de no repetición y longitud mínima. |
| **v0.6.0** | ✅ Completado | Conexión interactiva de la selección de letras en la pantalla (`MainActivity`) con las reglas de juego. |
| **v0.7.0** | ⏳ Pendiente | Temporizador de la ronda (150 segundos) y flujo de turnos. |
| **v0.8.0** | ⏳ Pendiente | Modo 2 jugadores, validación cruzada de listas y cálculo de puntajes por longitud. |
| **v1.0.0** | ⏳ Pendiente | Juego completo funcional con récords guardados. |

---

## 🏛️ Arquitectura (POO)
El proyecto está estructurado separando estrictamente la lógica de negocio de la interfaz de usuario:
- `Tablero`: Genera la grilla 4x4 mediante la simulación de dados Boggle en español.
- `Casilla`: Representa una coordenada (fila, columna) y calcula la adyacencia (vecindad).
- `Palabra`: Administra el texto en construcción y valida las reglas de recorrido y longitud.
- `MainActivity`: Controla la interfaz visual y la interacción táctil con el usuario.

---

## 🚀 Cómo empezar a colaborar en equipo
1. Clonar el repositorio.
2. Abrir el proyecto en **Android Studio**.
3. Sincronizar Gradle y ejecutar la app en un emulador o dispositivo físico.
