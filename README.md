# android_kotlin_fake_bot_app

## Esta es una app creada en el marco de un challenge.

### A continuación el mismo: 

<br>
<br>
<br>

# Ejercicio: Fake Bot

Este ejercicio es parte del curso Android Completo con Kotlin. Al desarrollarlo practicarás los siguientes temas de Android:

- RecyclerViews.
- Adapters.
- Empty views.
- Runnable (Opcional)

Este ejercicio como todos los del curso es opcional. Puedes ver la app completa en este repositorio de Github en el brach starter. Aunque te recomiendo que lo intentes hacer por tu cuenta.

Trataré de explicar el proyecto tal como te lo explicarían en un trabajo de la vida real (A excepción del siguiente párrafo 😅). ¡Vamos a ello!

Fake Bot es una app estilo la caracola mágica de Bob esponja (Si no has visto este capítulo puedes ver de qué se trata aquí aquí).

Esta app simula ser un Bot que responde a tus preguntas automáticamente, te puede responder con las siguientes respuestas:

- Si
- No
- Pregunta de nuevo
- Es muy probable
- No lo creo
- No sé 🙁
- Tal vez
- Más respuestas que quieras agregar de tu repertorio

<br>

### La app luce como una app de chat:

<br>

**Tu misión, si la aceptas, es cumplir con los siguientes objetivos:**

Desarrollar la app para que, cuando des clic en el botón de enviar, agregue tu mensaje a un RecyclerView y lo muestre.
Una vez que se agregue tu mensaje, la app deberá elegir una respuesta de las que insertaste de manera aleatoria y también agregarla al RecyclerView para simular que el Bot te respondió. Mira más abajo para consejos de cómo hacer esto.
Si no hay elementos en la lista, mostrar un texto que diga que no hay mensajes todavía.
Cuando se envía un mensaje, borrar el texto del campo de mensaje para poder volver a escribir sin tener que borrarlo a mano.
Cuando se agrega un nuevo mensaje, el recyclerView se debe «scrollear» hasta la parte de abajo para poder ver el último mensaje agregado. Observa cómo funciona Whatsapp u otra app de chat para que veas a lo que me refiero.
Restricciones y corner cases:

Estas son algunas restricciones y casos especiales que hay que tomar en cuenta.

Puedes usar cualquier tipo de Layout para realizar los diseños.
Puedes hacerlo con o sin data binding, no importa.
Si das clic en enviar pero el campo de mensaje está vacío debe aparecer un toast que diga «Debes insertar un mensaje para enviarlo».
Consejos:

Hay muchas formas de hacer este ejercicio, mi recomendación es que crees un arreglo con las posibles respuestas y luego tomes la respuesta aleatoriamente de ese arreglo usando un índice.

Para generar un número aleatorio que vaya de 1 a N, puedes usar Random, te podría decir exactamente como pero el 80% de tu tiempo como programador será buscar en Google así que búscalo 😉, si de plano no lo encuentras me preguntas.

Para hacer scroll a un RecyclerView con programación puedes usar myRecycler.scrollToPosition(position). OJO: Hay un error en este método, necesitarás poner la penúltima posición de la lista, no la última.

No olvides el excecutePendingBindings en el adapter.

<br>

### Retos Super Saijayin:

<br>


Todo el ejercicio es opcional pero retos son doblemente opcionales, si los haces aprenderás mucho:

- Que las preguntas aparezcan del lado derecho con fondo verde y las respuestas del lado izquierdo con fondo azul (Mira la imagen de la app más arriba)
- Simula un retraso de 1 o 2 segundos entre cuando haces la pregunta y cuando el bot te responde. Esto lo puedes hacer con un Runnable.
- Super Saijayin nivel Dios (Esto lo veremos en la siguiente sección del curso pero si eres aventurero(a) le puedes dar una intentada desde aquí): Implementa un ViewModel para manejar la lógica, la lista de mensajes estaría en un LiveData para que cuando agregues nuevos mensajes se actualice el adapter.
  
### No es un ejercicio sencillo pero aprenderás muchísimo en el camino. Si tienes dudas me puedes preguntar con toda confianza en el mismo curso, aquí o en la comunidad Hackaprende, donde te parezca mejor.
