# Implementación de Autenticación Segura en un Framework

Como especialista en Java, debes implementar un sistema de autenticación en una aplicación bancaria que maneje transacciones de alta sensibilidad. El sistema debe utilizar JWT para asegurar la comunicación entre el cliente y el servidor. El dominio es el de una aplicación bancaria donde los usuarios pueden realizar transacciones y consultar su saldo. Los actores involucrados son Clientes, Sistema de Autenticación y Servidor de Transacciones. La operación principal es la autenticación de usuarios antes de permitir transacciones. La clave para la autenticación es el JWT y el modo de falla es la expiración o invalidación del token.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Especialista en Framework con Proficiencia en Seguridad y Legibilidad de Código |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración Inicial del Framework

**Objetivo:** Configurar el framework para soportar autenticación basada en JWT.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identificar y configurar las dependencias necesarias para la autenticación JWT.
- Establecer las rutas y endpoints que requerirán autenticación.

**Entregable:** Configuración del framework con las dependencias y endpoints necesarios para la autenticación.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la estructura del proyecto y cómo las dependencias se integran con el framework.
- Piensa en la seguridad de las rutas y cómo protegerlas.

</details>

### Fase 2: Implementación de Mecanismos de Autenticación

**Objetivo:** Implementar dos mecanismos de autenticación utilizando JWT.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Crear un servicio de autenticación que genere y valide tokens JWT.
- Implementar la lógica para manejar la expiración y renovación de tokens.

**Entregable:** Servicio de autenticación funcional que genera y valida tokens JWT, manejando su expiración y renovación.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la seguridad de los tokens y cómo manejar su ciclo de vida.
- Piensa en los posibles fallos y cómo manejarlos.

</details>

### Fase 3: Integración y Pruebas de la Autenticación

**Objetivo:** Integrar el servicio de autenticación con el resto de la aplicación y realizar pruebas.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Integrar el servicio de autenticación con los endpoints de la aplicación.
- Realizar pruebas unitarias y de integración para asegurar la funcionalidad y seguridad del servicio de autenticación.

**Entregable:** Aplicación integrada con el servicio de autenticación, con pruebas unitarias y de integración que demuestren su funcionalidad y seguridad.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo integrar el servicio de autenticación de manera segura y eficiente.
- Piensa en los diferentes escenarios de prueba que podrían exponer fallos en la autenticación.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un JWT y cómo se utiliza en la autenticación?
- **paraQueSirve**: ¿Para qué sirve la autenticación basada en JWT en una aplicación bancaria?
- **comoSeUsa**: ¿Cómo se implementa y utiliza un servicio de autenticación con JWT en Java?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar autenticación con JWT y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica la implementación de un servicio de autenticación con JWT en términos de seguridad y rendimiento?

## Criterios de Evaluacion

- Configuración correcta del framework para soportar autenticación basada en JWT.
- Implementación de dos mecanismos de autenticación utilizando JWT.
- Manejo adecuado de la expiración y renovación de tokens JWT.
- Integración segura y eficiente del servicio de autenticación con la aplicación.
- Realización de pruebas unitarias y de integración que demuestren la funcionalidad y seguridad del servicio de autenticación.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
