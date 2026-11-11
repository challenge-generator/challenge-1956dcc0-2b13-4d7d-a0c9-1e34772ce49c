# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/com/bank/auth/infrastructure/config/SecurityConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/infrastructure/security/JwtAuthenticationFilter.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/infrastructure/security/JwtTokenUtil.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/domain/model/User.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/domain/ports/UserRepository.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/application/service/AuthService.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/infrastructure/adapters/UserJpaRepository.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/infrastructure/controllers/AuthController.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/infrastructure/controllers/TransactionController.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/bank/auth/application/service/AuthServiceTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/bank/auth/infrastructure/security/JwtAuthenticationFilterTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/bank/auth/infrastructure/controllers/AuthControllerIntegrationTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/bank/auth/Application.java` — `com.bank.auth.infrastructure.config.JwtProperties`: El import com.bank.auth.infrastructure.config.JwtProperties usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/test/java/com/bank/auth/application/service/AuthServiceTest.java` — `AuthService.login`: Se invoca `login` sobre `AuthService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/auth/infrastructure/controllers/AuthControllerIntegrationTest.java` — `AuthService.login`: Se invoca `login` sobre `AuthService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/auth/infrastructure/controllers/AuthControllerIntegrationTest.java` — `AuthService.register`: Se invoca `register` sobre `AuthService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced L2

### Brecha de conocimiento
Experto en el marco de trabajo (framework) mas relevante en su lenguaje de programación principal, lo que le permite escribir código más legible y reducir la redundancia. Ha implementado al menos dos mecanismos de autenticación e identifica el uso de un JWT

### Reto
- Tema: Especialista en Framework con Proficiencia en Seguridad y Legibilidad de Código
- Seniority: advanced-l2
- Tipo: practical
- Título: Implementación de Autenticación Segura en un Framework
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración Inicial del Framework — objetivo: Configurar el framework para soportar autenticación basada en JWT. — entregable (NO resolver): Configuración del framework con las dependencias y endpoints necesarios para la autenticación.
- Fase 2: Implementación de Mecanismos de Autenticación — objetivo: Implementar dos mecanismos de autenticación utilizando JWT. — entregable (NO resolver): Servicio de autenticación funcional que genera y valida tokens JWT, manejando su expiración y renovación.
- Fase 3: Integración y Pruebas de la Autenticación — objetivo: Integrar el servicio de autenticación con el resto de la aplicación y realizar pruebas. — entregable (NO resolver): Aplicación integrada con el servicio de autenticación, con pruebas unitarias y de integración que demuestren su funcionalidad y seguridad.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.bank</groupId>
    <artifactId>auth</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>auth</name>
    <description>Sistema de autenticación para aplicación bancaria</description>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- JWT -->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.12.5</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.12.5</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>0.12.5</version>
            <scope>runtime</scope>
        </dependency>

        <!-- Database -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.34</version>
            <scope>provided</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/bank/auth/Application.java ===
package com.bank.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.bank.auth.infrastructure.config.JwtProperties;

import java.util.TimeZone;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class Application {

    @Value("${app.timezone:UTC}")
    private String timezone;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public void configureTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone(timezone));
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
server:
  port: 8080
  servlet:
    context-path: /api

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/bank_auth
    username: bank_user
    password: securePassword123!
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 10
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
    open-in-view: false

app:
  jwt:
    secret: ${JWT_SECRET:defaultSecretKeyForDevelopmentOnlyChangeInProduction1234567890}
    expiration-milliseconds: 86400000 # 24 horas
    issuer: bank-auth-service
    refresh-expiration-milliseconds: 604800000 # 7 días
  security:
    permit-all-paths:
      - "/auth/login"
      - "/auth/refresh"
      - "/swagger-ui/**"
      - "/v3/api-docs/**"
      - "/actuator/health"
  timezone: UTC

logging:
  level:
    root: INFO
    com.bank.auth: DEBUG
    org.springframework.security: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE

// === ARCHIVO: src/main/java/com/bank/auth/domain/model/User.java ===
package com.bank.auth.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private String role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean active;

    public User() {
    }

    public User(UUID id, String username, String password, String email, String role, LocalDateTime createdAt, LocalDateTime updatedAt, boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

// === ARCHIVO: src/main/java/com/bank/auth/domain/ports/UserRepository.java ===
package com.bank.auth.domain.ports;

import com.bank.auth.domain.model.User;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findById(UUID id);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    User save(User user);
    void deleteById(UUID id);
}

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/adapters/UserJpaRepository.java ===
package com.bank.auth.infrastructure.adapters;

import com.bank.auth.domain.model.User;
import com.bank.auth.domain.ports.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<User, UUID>, UserRepository {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/config/SecurityConfig.java ===
package com.bank.auth.infrastructure.config;

import com.bank.auth.infrastructure.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/login", "/auth/register", "/actuator/**").permitAll()
                .anyRequest().authenticated())
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/security/JwtAuthenticationFilter.java ===
package com.bank.auth.infrastructure.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = jwtTokenUtil.extractUsername(token);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            
            if (jwtTokenUtil.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = 
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/security/JwtTokenUtil.java ===
package com.bank.auth.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
            .claims(claims)
            .subject(subject)
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(getSigningKey())
            .compact();
    }
}

// === ARCHIVO: src/main/java/com/bank/auth/application/service/AuthService.java ===
package com.bank.auth.application.service;

import com.bank.auth.domain.model.User;
import com.bank.auth.domain.ports.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String authenticate(String username, String password) {
        throw new UnsupportedOperationException("Implementar autenticación con validación de credenciales");
    }

    public String refreshToken(String token) {
        throw new UnsupportedOperationException("Implementar renovación de token JWT");
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findUserById(UUID id) {
        return userRepository.findById(id);
    }
}

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/controllers/AuthController.java ===
package com.bank.auth.infrastructure.controllers;

import com.bank.auth.application.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        throw new UnsupportedOperationException("Implementar endpoint de login que valide credenciales y retorne JWT");
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String, String> request) {
        throw new UnsupportedOperationException("Implementar endpoint de refresh que renueve el token");
    }
}

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/controllers/TransactionController.java ===
package com.bank.auth.infrastructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @GetMapping("/balance")
    public ResponseEntity<?> getBalance() {
        throw new UnsupportedOperationException("Implementar endpoint protegido que retorne el saldo del usuario autenticado");
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody Map<String, Object> transferRequest) {
        throw new UnsupportedOperationException("Implementar endpoint protegido para realizar transferencias");
    }

    @GetMapping("/history")
    public ResponseEntity<?> getTransactionHistory() {
        throw new UnsupportedOperationException("Implementar endpoint protegido que retorne el historial de transacciones");
    }
}

// === ARCHIVO: src/test/java/com/bank/auth/application/service/AuthServiceTest.java ===
package com.bank.auth.application.service;

import com.bank.auth.domain.model.User;
import com.bank.auth.domain.ports.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias para AuthService")
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthService authService;

    private User testUser;
    private final String rawPassword = "SecurePass123!";
    private final String hashedPassword = "$2a$10$hashedPasswordRepresentation";

    @BeforeEach
    void setUp() {
        testUser = new User(
            UUID.randomUUID(),
            "testuser",
            hashedPassword,
            "test@bank.com",
            "USER",
            LocalDateTime.now(),
            LocalDateTime.now(),
            true
        );
    }

    @Test
    @DisplayName("Login exitoso con credenciales válidas")
    void login_WithValidCredentials_ReturnsToken() {
        // Given: usuario existente con credenciales válidas
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(testUser));
        
        // When: se intenta autenticar
        // TODO: Implementar la lógica de autenticación
        var result = authService.login("testuser", rawPassword);
        
        // Then: verificar que se genera el token
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("Login fallido con usuario inexistente")
    void login_WithNonExistentUser_ThrowsException() {
        // Given: usuario no existe en repositorio
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        
        // When: se intenta autenticar con usuario inexistente
        // TODO: Implementar manejo de excepción
        
        // Then: verificar que lanza excepción apropiada
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("Login fallido con contraseña incorrecta")
    void login_WithWrongPassword_ThrowsException() {
        // Given: usuario existe pero contraseña es incorrecta
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(testUser));
        
        // When: se intenta autenticar con contraseña incorrecta
        // TODO: Implementar validación de contraseña
        
        // Then: verificar que lanza excepción apropiada
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("Login fallido con usuario inactivo")
    void login_WithInactiveUser_ThrowsException() {
        // Given: usuario existe pero está inactivo
        testUser.setActive(false);
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(testUser));
        
        // When: se intenta autenticar
        // TODO: Implementar validación de estado activo
        
        // Then: verificar que lanza excepción apropiada
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("Registro de nuevo usuario exitoso")
    void register_WithValidData_ReturnsCreatedUser() {
        // Given: datos de registro válidos
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(testUser);
        
        // When: se registra el usuario
        // TODO: Implementar lógica de registro
        
        // Then: verificar que se crea y retorna el usuario
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("Registro fallido con username duplicado")
    void register_WithDuplicateUsername_ThrowsException() {
        // Given: username ya existe
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(testUser));
        
        // When: se intenta registrar
        // TODO: Implementar validación de duplicados
        
        // Then: verificar que lanza excepción apropiada
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("Validación de token JWT válido")
    void validateToken_WithValidToken_ReturnsTrue() {
        // Given: token JWT válido
        String validToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0dXNlciJ9.signature";
        
        // When: se valida el token
        // TODO: Implementar validación de token
        
        // Then: verificar que retorna true
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("Validación de token JWT expirado")
    void validateToken_WithExpiredToken_ReturnsFalse() {
        // Given: token JWT expirado
        String expiredToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0dXNlciIsImV4cCI6MTYwfQ.expired";
        
        // When: se valida el token
        // TODO: Implementar validación de expiración
        
        // Then: verificar que retorna false
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("Renovación de token expirado")
    void refreshToken_WithValidRefreshToken_ReturnsNewToken() {
        // Given: token de renovación válido
        String refreshToken = "refresh.token.here";
        
        // When: se solicita renovación
        // TODO: Implementar lógica de renovación
        
        // Then: verificar que retorna nuevo token
        // TODO: Implementar assertions
    }
}

// === ARCHIVO: src/test/java/com/bank/auth/infrastructure/security/JwtAuthenticationFilterTest.java ===
package com.bank.auth.infrastructure.security;


import com.bank.auth.domain.model.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.IOException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias para JwtAuthenticationFilter")
class JwtAuthenticationFilterTest {

    @Mock
    private JwtTokenUtil jwtTokenUtil;

    @Mock
    private UserDetailsService userDetailsService;

    @Mock
    private FilterChain filterChain;

    private JwtAuthenticationFilter jwtAuthenticationFilter;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @BeforeEach
    void setUp() {
        jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtTokenUtil, userDetailsService);
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        SecurityContextHolder.clearContext();
    }

    @Test
    @DisplayName("Autenticación exitosa con token JWT válido")
    void doFilter_WithValidToken_SetsAuthentication() throws ServletException, IOException {
        // Given: request con token JWT válido en Authorization header
        String validToken = "Bearer valid.jwt.token";
        request.addHeader("Authorization", validToken);
        request.setRequestURI("/api/transactions");
        
        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn("testuser");
        when(userDetails.getAuthorities()).thenReturn(Collections.emptyList());
        
        when(jwtTokenUtil.extractUsername(anyString())).thenReturn("testuser");
        when(jwtTokenUtil.validateToken(anyString(), any(UserDetails.class))).thenReturn(true);
        when(userDetailsService.loadUserByUsername("testuser")).thenReturn(userDetails);
        
        // When: se ejecuta el filtro
        jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);
        
        // Then: verificar que se estableció autenticación en el contexto
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("Filtro ignorado sin header Authorization")
    void doFilter_WithoutAuthorizationHeader_SkipsFilter() throws ServletException, IOException {
        // Given: request sin Authorization header
        request.setRequestURI("/api/transactions");
        
        // When: se ejecuta el filtro
        jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);
        
        // Then: verificar que no se intentó validar token
        verify(jwtTokenUtil, never()).extractUsername(anyString());
        verify(filterChain).doFilter(request, response);
    }

    @Test
    @DisplayName("Filtro ignorado para endpoint de autenticación")
    void doFilter_OnAuthEndpoint_SkipsFilter() throws ServletException, IOException {
        // Given: request a endpoint de login
        request.addHeader("Authorization", "Bearer some.token");
        request.setRequestURI("/auth/login");
        
        // When: se ejecuta el filtro
        jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);
        
        // Then: verificar que no se estableció autenticación
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("Filtro ignorado para endpoint de registro")
    void doFilter_OnRegisterEndpoint_SkipsFilter() throws ServletException, IOException {
        // Given: request a endpoint de registro
        request.addHeader("Authorization", "Bearer some.token");
        request.setRequestURI("/auth/register");
        
        // When: se ejecuta el filtro
        jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);
        
        // Then: verificar que no se estableció autenticación
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("Autenticación fallida con token inválido")
    void doFilter_WithInvalidToken_DoesNotSetAuthentication() throws ServletException, IOException {
        // Given: request con token JWT inválido
        String invalidToken = "Bearer invalid.token";
        request.addHeader("Authorization", invalidToken);
        request.setRequestURI("/api/transactions");
        
        when(jwtTokenUtil.extractUsername(anyString())).thenReturn("testuser");
        when(jwtTokenUtil.validateToken(anyString(), any(UserDetails.class))).thenReturn(false);
        
        // When: se ejecuta el filtro
        jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);
        
        // Then: verificar que NO se estableció autenticación
        assertNull(SecurityContextHolder.getContext().getAuthentication());
    }

    @Test
    @DisplayName("Autenticación fallida con token expirado")
    void doFilter_WithExpiredToken_DoesNotSetAuthentication() throws ServletException, IOException {
        // Given: request con token JWT expirado
        String expiredToken = "Bearer expired.token";
        request.addHeader("Authorization", expiredToken);
        request.setRequestURI("/api/transactions");
        
        when(jwtTokenUtil.extractUsername(anyString())).thenReturn("testuser");
        when(jwtTokenUtil.validateToken(anyString(), any(UserDetails.class))).thenReturn(false);
        
        // When: se ejecuta el filtro
        jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);
        
        // Then: verificar que NO se estableció autenticación y retorna 401
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("Extracción de username del token")
    void extractUsername_FromToken_ReturnsCorrectUsername() {
        // Given: token JWT con subject
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0dXNlciJ9.test";
        
        // When: se extrae el username
        // TODO: Implementar extracción
        
        // Then: verificar que retorna el username correcto
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("Validación de token con usuario no encontrado")
    void validateToken_WithNonExistentUser_ReturnsFalse() {
        // Given: token con username que no existe
        String token = "valid.token.here";
        
        when(jwtTokenUtil.extractUsername(anyString())).thenReturn("nonexistent");
        when(userDetailsService.loadUserByUsername("nonexistent")).thenThrow(new RuntimeException("User not found"));
        
        // When: se valida el token
        // TODO: Implementar validación
        
        // Then: verificar que retorna false
        // TODO: Implementar assertions
    }
}

// === ARCHIVO: src/test/java/com/bank/auth/infrastructure/controllers/AuthControllerIntegrationTest.java ===
package com.bank.auth.infrastructure.controllers;


import com.bank.auth.domain.model.User;
import com.bank.auth.application.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebMvcTest(AuthController.class)
@DisplayName("Pruebas de integración para AuthController")
class AuthControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthService authService;

    private Map<String, String> loginRequest;
    private Map<String, String> registerRequest;

    @BeforeEach
    void setUp() {
        loginRequest = Map.of(
            "username", "testuser",
            "password", "SecurePass123!"
        );
        
        registerRequest = Map.of(
            "username", "newuser",
            "password", "NewPass123!",
            "email", "newuser@bank.com"
        );
    }

    @Test
    @DisplayName("POST /auth/login - Login exitoso con credenciales válidas")
    void login_WithValidCredentials_Returns200AndToken() throws Exception {
        // Given: credenciales válidas
        String expectedToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0dXNlciJ9.signature";
        when(authService.login(anyString(), anyString())).thenReturn(expectedToken);
        
        // When: se envía request de login
        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
        
        // Then: verificar respuesta 200 con token
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.token").value(expectedToken));
    }

    @Test
    @DisplayName("POST /auth/login - Login fallido con credenciales inválidas")
    void login_WithInvalidCredentials_Returns401() throws Exception {
        // Given: credenciales inválidas
        when(authService.login(anyString(), anyString()))
            .thenThrow(new RuntimeException("Invalid credentials"));
        
        // When: se envía request de login
        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
        
        // Then: verificar respuesta 401
        .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("POST /auth/login - Login con request malformado retorna 400")
    void login_WithMalformedRequest_Returns400() throws Exception {
        // Given: request sin campos obligatorios
        Map<String, String> malformedRequest = Map.of("username", "testuser");
        
        // When: se envía request malformado
        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(malformedRequest)))
        
        // Then: verificar respuesta 400
        .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /auth/register - Registro exitoso")
    void register_WithValidData_Returns201() throws Exception {
        // Given: datos de registro válidos
        when(authService.register(anyString(), anyString(), anyString()))
            .thenReturn("User created successfully");
        
        // When: se envía request de registro
        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerRequest)))
        
        // Then: verificar respuesta 201
        .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("POST /auth/register - Registro con username duplicado retorna 409")
    void register_WithDuplicateUsername_Returns409() throws Exception {
        // Given: username ya existe
        when(authService.register(anyString(), anyString(), anyString()))
            .thenThrow(new RuntimeException("Username already exists"));
        
        // When: se envía request de registro
        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerRequest)))
        
        // Then: verificar respuesta 409
        .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("POST /auth/register - Registro con email duplicado retorna 409")
    void register_WithDuplicateEmail_Returns409() throws Exception {
        // Given: email ya existe
        when(authService.register(anyString(), anyString(), anyString()))
            .thenThrow(new RuntimeException("Email already exists"));
        
        // When: se envía request de registro
        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerRequest)))
        
        // Then: verificar respuesta 409
        .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("POST /auth/register - Registro con password débil retorna 400")
    void register_WithWeakPassword_Returns400() throws Exception {
        // Given: password que no cumple requisitos
        Map<String, String> weakPasswordRequest = Map.of(
            "username", "newuser",
            "password", "weak",
            "email", "newuser@bank.com"
        );
        
        // When: se envía request con password débil
        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(weakPasswordRequest)))
        
        // Then: verificar respuesta 400
        .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /auth/register - Registro con email inválido retorna 400")
    void register_WithInvalidEmail_Returns400() throws Exception {
        // Given: email con formato inválido
        Map<String, String> invalidEmailRequest = Map.of(
            "username", "newuser",
            "password", "NewPass123!",
            "email", "invalid-email"
        );
        
        // When: se envía request con email inválido
        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidEmailRequest)))
        
        // Then: verificar respuesta 400
        .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /auth/refresh - Renovación de token exitosa")
    void refreshToken_WithValidToken_Returns200() throws Exception {
        // Given: token de renovación válido
        String refreshToken = "refresh.token.here";
        String newAccessToken = "new.access.token";
        
        when(authService.refreshToken(anyString())).thenReturn(newAccessToken);
        
        // When: se envía request de renovación
        mockMvc.perform(post("/auth/refresh")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Map.of("refreshToken", refreshToken))))
        
        // Then: verificar respuesta 200 con nuevo token
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.token").value(newAccessToken));
    }

    @Test
    @DisplayName("POST /auth/refresh - Renovación con token inválido retorna 401")
    void refreshToken_WithInvalidToken_Returns401() throws Exception {
        // Given: token de renovación inválido
        when(authService.refreshToken(anyString()))
            .thenThrow(new RuntimeException("Invalid refresh token"));
        
        // When: se envía request de renovación
        mockMvc.perform(post("/auth/refresh")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Map.of("refreshToken", "invalid"))))
        
        // Then: verificar respuesta 401
        .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("GET /auth/status - Verificación de estado de autenticación")
    void status_AuthenticatedUser_Returns200() throws Exception {
        // Given: usuario autenticado (header con token)
        // TODO: Configurar autenticación en el contexto de seguridad
        
        // When: se verifica el estado
        mockMvc.perform(get("/auth/status"))
        
        // Then: verificar respuesta 200 con información del usuario
        // TODO: Implementar assertions
    }

    @Test
    @DisplayName("GET /auth/status - Sin autenticación retorna 401")
    void status_UnauthenticatedUser_Returns401() throws Exception {
        // Given: request sin autenticación
        
        // When: se verifica el estado
        mockMvc.perform(get("/auth/status"))
        
        // Then: verificar respuesta 401
        .andExpect(status().isUnauthorized());
    }
}
```
