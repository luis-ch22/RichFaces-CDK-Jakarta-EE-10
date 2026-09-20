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

## Piezas retiradas respecto al CDK original

Este fork elimina código y recursos que ya no tenían efecto en Jakarta Faces 4:

- **El goal `richfaces-cdk:compile`.** No generaba nada: volcaba objetos del
  proyecto al log. El único goal soportado es `generate`.
- **El motor Velocity y el soporte de *skins*/temas** (`templates/`,
  `templates12/`, `skin/`, `theme/`): no estaban cableados a ninguna clase.
- **La lógica que seleccionaba salida según la versión de JSF 1.x**
  (`AbstractCDKMojo`) y las plantillas TLD/JSP de Velocity que la acompañaban.
  Faces 4 no usa JSP: el CDK genera `faces-config.xml` y `*.taglib.xml`, más
  *tag handlers* de Facelets, pero ni TLD ni clases de tag JSP.
- **Las anotaciones `@Test`/`TestType`** y el miembro `test()` de
  `@JsfComponent` y `@RendererSpecificComponent`, que ningún procesador leía.
- **Los esquemas Java EE 5 / JSF 1.2 y 2.0**; el CDK solo valida contra los de
  Jakarta Faces 4.0.

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
