# Conversor de Divisas

Este proyecto es un conversor de divisas que utiliza la API de
[ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tasas de cambio 
en tiempo real y realizar conversiones entre diferentes monedas.

![Menu principal](https://github.com/ByTRAX78/Challenge_One_Alura/blob/main/Imagenes/Menu.png)
## Descripción del programa
El programa cuenta con un menú principal en donde el usuario podrá interactuar con las diferentes opciones y además cuenta con un sistema de validaciones por si el usuario se llega a equivocar cuando quiera usar una opción.
Igualmente cuenta con un sistema de registro de las conversiones para la formación de un historial (ojo el programa no usa base de datos), si es la primera vez que el usuario interactúa le aparecerá en el programa que aún no tiene registro de sus conversiones. 

### Historial Vació
![Historial vacio](https://github.com/ByTRAX78/Challenge_One_Alura/blob/main/Imagenes/HistorialVacio.png)

Cuando el usuario empieza hacer conversiones, cada conversión se va guardando en el historial y si desea que se la muestren, debe de volver pausar el menú y seleccionar la opción número 9). El proceso se vería de la siguiente manera.
### 1.- El usuario hace una conversión.
![Ejemplo de conversion](https://github.com/ByTRAX78/Challenge_One_Alura/blob/main/Imagenes/EjemploDeConversion.png)

### 2.- Selecciona nuevamente la opción numero 9) para ver tu historial.
![Historial con registro](https://github.com/ByTRAX78/Challenge_One_Alura/blob/main/Imagenes/HistorialLleno.png)

## Requisitos del Sistema

- 20 (Oracle OpenJDK versión 21.0.1)
- Conexión a Internet para obtener tasas de cambio actualizadas.  
#### Librerías necesarias:
- GSON (2.11.0)

## Instalación

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu IDE de Java preferido.
3. Compila y ejecuta el archivo `Main.java` para iniciar la aplicación.

## Uso

- Al iniciar la aplicación, se te pedirá que selecciones una opción para hacer una conversión.
- Luego, introduce el monto que deseas convertir.
- La aplicación calculará automáticamente el monto convertido y lo mostrará.
- Puedes optar por realizar más conversiones o salir de la aplicación.

## Monedas Disponibles
La aplicación de conversión de divisas cuenta con soporte para las siguientes monedas:
* USD - Dólar estadounidense
* ARS - Peso argentino
* BRL - Real brasileño
* COP - Peso colombiano
* MXN - Peso méxicano
  

## Control de Errores y validaciones

* Válida la entrada de las opciones: Si el usuario llega a ingresar una palabra, un carácter u otro número que no tiene que ver con el menú, se le hará saber que tiene que ingresar una opción válida.
* Validación en la cantidad a convertir: Si el usuario desea ingresar una cantidad junto con algún carácter o una palabra, se le hará saber que tiene que ingresar una cantidad que sea aceptada en el programa.
* Validación de opciones en las preguntas: Cuando al usuario se le pregunta si desea seguir usando el programa, el usuario tendrá que usar las opciones que menciona el programa, de lo contrario se la hará saber con un mensaje que no esté ingresando correctamente la opción para que el programa siga funcionando adecuadamente.


## Creado por

Este proyecto fue creado por [Adrian](https://github.com/ByTRAX78).



¡Siéntete libre de contactarme si tienes alguna pregunta o sugerencia!

[LinkedIn](https://www.linkedin.com/in/martinez-martinez-adrian/)
