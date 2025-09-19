
# 🔐 Jasypt CLI Tool 0.0.1

Herramienta de línea de comandos para **cifrar y descifrar textos** utilizando **Jasypt** con soporte para múltiples algoritmos, emojis y validaciones, todo en un solo `.jar`.

---

## 📦 Estructura del Proyecto

```
com.security.jasyptcli
├── JasyptCliTool.java              # Clase principal con el método main()
├── service
│   └── JasyptCliService.java       # Lógica de cifrado y descifrado
├── constants
│   ├── AlgorithmConstants.java     # Algoritmos disponibles con emojis
│   ├── Constants.java              # Constantes generales
│   └── OperationConstants.java     # Operaciones: cifrar / descifrar
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
- Terminal que soporte UTF-8 y emojis (💻 consola Windows o bash moderna)

---

## 🔐 Características

- Elección de algoritmo Jasypt ✏️
- Interfaz por consola amigable con emojis y validaciones ❌✅
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

## 🧠 Autor

Desarrollado por Gonzalo Iván López ✨  
Con ❤️ y seguridad en mente.

---

## 🛡️ Licencia

MIT License
