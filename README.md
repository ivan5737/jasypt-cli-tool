
# 🔐 Jasypt CLI Tool 0.0.1

Herramienta de línea de comandos para **cifrar y descifrar textos** utilizando **Jasypt** con soporte para múltiples algoritmos y validaciones, todo en un solo `.jar`.

---

## 📦 Estructura del Proyecto

```
├── JasyptCliTool.java          # Clase principal con el método main(); orquesta ejecución, maneja errores y salida
│
├── console
│ └── ConsolePrompt.java        # Manejo de interacción con el usuario vía consola (inputs, menús, selección de algoritmos)
│
├── constants
│ ├── AlgorithmConstants.java   # Lista de algoritmos soportados (con emojis descriptivos)
│ ├── Constants.java            # Constantes generales de la aplicación
│ └── OperationConstants.java   # Operaciones soportadas: encrypt / decrypt
│
├── exception
│ ├── JasyptCliException.java   # Excepción base personalizada para el CLI
│ │
│ └── constants
│ └── ErrorCode.java            # Enum con códigos y descripciones de error (para mensajes y exit codes)
│
├── model
│ └── JasyptRequest.java        # DTO para agrupar parámetros de entrada (operación, algoritmo, contraseña, input)
│
├── service
│ └── JasyptCliService.java     # Lógica de negocio: validaciones y ejecución de cifrado/descifrado
│
└── util
└── JasyptUtils.java            # Métodos utilitarios para configurar y ejecutar Jasypt (encrypt/decrypt)
```

---

## 🚀 Ejecución

Compila y ejecuta desde línea de comandos:

```bash
  mvn clean package

  java -jar target/jasyptcli-0.0.1.jar
```

---

## ⚙️ Requisitos

- Java 17+ ☕
- Maven 3.8+
- Terminal que soporte UTF-8 (💻 consola Windows o bash moderna)

---

## 🔐 Características

- Elección de algoritmo Jasypt ✏️
- Interfaz por consola amigable con validaciones ❌✅
- Cifrado y descifrado de texto plano 📥📤
- Soporte para algoritmos como:
    - `PBEWithMD5AndDES`
    - `PBEWithMD5AndTripleDES`
    - `PBEWithSHA1AndDESede`
    - `PBEWithSHA1AndRC2_40`
    - `PBEWITHSHA256AND128BITAES-CBC-BC`
    - `PBEWITHSHA256AND192BITAES-CBC-BC`
    - `PBEWITHSHA256AND256BITAES-CBC-BC`
    - `PBEWITHSHA1AND128BITAES-CBC-BC`
    - `PBEWITHSHA1AND192BITAES-CBC-BC`
    - `PBEWITHSHA1AND256BITAES-CBC-BC`
- Modularizado para cumplir con buenas prácticas: Sonar, Jacoco, Clean Code

---

## 📄 Dependencias principales

```xml
<!-- Jasypt -->
<dependency>
    <groupId>org.jasypt</groupId>
    <artifactId>jasypt</artifactId>
    <version>1.9.3</version>
</dependency>

<!-- BouncyCastle -->
<dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bcprov-jdk18on</artifactId>
    <version>1.81</version>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.32</version>
    <scope>provided</scope>
</dependency>

<!-- Logback Classic -->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.5.18</version>
</dependency>
```

## 📄 Plugins

```xml
<!-- Shade Plugin -->
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-shade-plugin</artifactId>
    <version>3.5.0</version>
</plugin>

<!-- Surefire Plugin -->
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.2.5</version>
</plugin>
        
<!-- Jacoco Plugin -->
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.12</version>
</plugin>
```

---

## 📋 Logs

- PromptLogger: usado en ConsolePrompt para interacción con el usuario (emula println).
- log (@Slf4j): usado en Service y Tool para errores y depuración.

---

## 🧪 Ejemplo de uso

```
🔐 Ingresa la clave maestra (JASYPT password):
📦 Algoritmos disponibles:
1 -> PBEWithMD5AndDES
2 -> PBEWithMD5AndTripleDES
3 -> PBEWithSHA1AndDESede
4 -> PBEWithSHA1AndRC2_40
5 -> PBEWITHSHA256AND128BITAES-CBC-BC
6 -> PBEWITHSHA256AND192BITAES-CBC-BC
7 -> PBEWITHSHA256AND256BITAES-CBC-BC
8 -> PBEWITHSHA1AND128BITAES-CBC-BC
9 -> PBEWITHSHA1AND192BITAES-CBC-BC
10 -> PBEWITHSHA1AND256BITAES-CBC-BC
✅ Seleccionaste: PBEWITHSHA256AND256BITAES-CBC-BC

🔐 Elige cifrar o descifrar:
1 -> 🔐 Cifrar
2 -> 🔐 Descifrar
✅ Seleccionaste: 🔐 Cifrar

🔑 Ingresa el texto:
miTextoSecreto123

✅ Resultado: ENC(nz9s...==)
```

---

## ❌ Códigos de Error

El CLI devuelve códigos de salida (`exit code`) en caso de error:

- 1001 → Operación inválida
- 1002 → Algoritmo no soportado
- 1003 → Contraseña vacía
- 1004 → Texto vacío
- 9999 → Error inesperado

Esto permite integrarlo fácilmente en scripts y pipelines CI/CD.


---

## 🧠 Autor

Desarrollado por Gonzalo Iván López ✨  
Con ❤️ y seguridad en mente.

---

## 🛡️ Licencia

MIT License
