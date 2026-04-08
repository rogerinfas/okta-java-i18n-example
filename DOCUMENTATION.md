# Documentación - Quiz.java

## ¿Qué es Quiz.java?

Es un cuestionario interactivo con 3 preguntas sencillo que muestra cómo funciona la **internacionalización (i18n)** en Java. El idioma de las preguntas cambia según el parámetro que se pase al ejecutar el programa.

## Concepto de Internacionalización (i18n)

La internacionalización es el proceso de diseñar una aplicación para que pueda adaptarse a diferentes idiomas y regiones sin cambiar su código fuente. En Java esto se logra mediante:

1. **Archivos de propiedades (.properties)** - Contienen las traducciones organizadas por clave-valor
2. **ResourceBundle** - Carga el archivo de propiedades según el idioma seleccionado
3. **Locale** - Representa el idioma y región específicos

## Código de Quiz.java

```java
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
        String language = "en";

        if (args.length == 1) {
            language = args[0];
        }

        var locale = Locale.forLanguageTag(language);
        var messages = ResourceBundle.getBundle("quiz", locale);
        var scanner = new Scanner(System.in);

        System.out.println("=== " + messages.getString("title") + " ===\n");

        System.out.println(messages.getString("q1"));
        System.out.print(messages.getString("answer") + " ");
        scanner.nextLine();

        System.out.println(messages.getString("q2"));
        System.out.print(messages.getString("answer") + " ");
        scanner.nextLine();

        System.out.println(messages.getString("q3"));
        System.out.print(messages.getString("answer") + " ");
        scanner.nextLine();

        System.out.println("\n" + messages.getString("thanks"));
        scanner.close();
    }
}
```

## Explicación del Código

1. `String language = "en"` - Define el idioma por defecto (inglés)
2. `language = args[0]` - Captura el idioma enviado como parámetro al ejecutar
3. `Locale.forLanguageTag(language)` - Convierte el texto en un objeto Locale válido
4. `ResourceBundle.getBundle("quiz", locale)` - Carga el archivo de propiedades del idioma seleccionado
5. `messages.getString("title")` - Obtiene el valor asociado a "title" del archivo properties

## Archivos de Propiedades

### quiz_en.properties (Inglés)
```properties
title=Simple Quiz
q1=What is your name?
q2=How old are you?
q3=What is your favorite color?
answer=Answer:
thanks=Thank you for completing the quiz!
```

### quiz_es.properties (Español)
```properties
title=Cuestionario Simple
q1=¿Cuál es tu nombre?
q2=¿Cuántos años tienes?
q3=¿Cuál es tu color favorito?
answer=Respuesta:
thanks=¡Gracias por completar el cuestionario!
```

## Cómo Ejecutar

**Inglés:**
```bash
java Quiz.java en
```

**Español:**
```bash
java Quiz.java es
```

## Diagrama del Flujo

```
Ejecución (java Quiz.java es)
       ↓
  args[0] = "es"
       ↓
  Locale.forLanguageTag("es")
       ↓
  ResourceBundle.getBundle("quiz", locale)
       ↓
  Carga quiz_es.properties
       ↓
  messages.getString("title") → "Cuestionario Simple"
  messages.getString("q1") → "¿Cuál es tu nombre?"
  ... y así sucesivamente
```

## Conclusión

Quiz.java demuestra cómo con `Locale` y `ResourceBundle` podemos cambiar completamente el idioma de una aplicación sin modificar el código Java, solo con cambiar el parámetro de entrada y tener archivos de propiedades para cada idioma.
