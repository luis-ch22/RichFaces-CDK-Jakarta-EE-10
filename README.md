# RichFaces CDK — Jakarta EE 10 / Java 21

RichFaces Component Development Kit (CDK): el generador de código *build-time*
de RichFaces. Procesa el metamodelo de componentes, las anotaciones y las
plantillas para generar componentes, renderers, taglibs, `faces-config`,
recursos y metadatos que consume el runtime de RichFaces.

Este repositorio es un fork migrado a **Jakarta EE 10 / Jakarta Faces 4.0** y
**Java 21**. Principales cambios frente al CDK original:

- Compilación y ejecución sobre **Java 21**.
- Migración de JAXB de `javax.xml.bind` a `jakarta.xml.bind` (Jakarta XML Binding 4.x).
- Generación de descriptores con namespace `https://jakarta.ee/xml/ns/jakartaee`
  y esquemas Jakarta Faces 4.0 (`web-facesconfig_4_0.xsd`,
  `web-facelettaglibrary_4_0.xsd`, `version="4.0"`).
- Plantillas que emiten código `jakarta.faces.*` / `jakarta.el.*`.
- `groupId` del proyecto: `com.github.luisch22.richfaces.cdk`.

## Artefacto principal

El plugin Maven que consume el runtime:

```
com.github.luisch22.richfaces.cdk:richfaces-cdk-maven-plugin
```

## Build

Requiere JDK 21 y Maven 3.9+.

```
mvn clean install
```

Integration tests del plugin generador:

```
mvn -f maven-plugin/pom.xml -P it integration-test
```

## Créditos

- Fork basado en el [RichFaces CDK de Alberto Fernández](https://github.com/albfernandez/richfaces-cdk),
  a su vez derivado del proyecto JBoss RichFaces (discontinuado).
- Migración a Jakarta EE 10 / Java 21 y mantenimiento de este fork: Luis Chavez
  ([luis-ch22](https://github.com/luis-ch22)).

## Licencia

GNU Lesser General Public License, versión 2.1 (LGPL-2.1). Ver [`LICENSE`](LICENSE).
