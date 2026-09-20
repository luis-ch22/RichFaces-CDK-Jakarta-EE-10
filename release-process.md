# Release Process

This guide provides a chronological steps which goes through release tagging, staging, verification and publishing.

## Check the SNAPSHOT builds and pass the tests

Check that the project builds with JDK 21 (the level the poms target).

```bash
mvn clean package verify
```

Run the generator plugin integration tests as well; they are not bound to
`verify` and are the only end-to-end check of the generated descriptors:

```bash
mvn -f maven-plugin/pom.xml -P it integration-test
```

## Set version and build 

```bash
# change release in poms
mvn clean package verify
mvn -Psign clean package javadoc:jar source:jar install deploy
git add -A
git commit -S -m 'Release 10.0.1'
git tag -a v.10.0.1 -m "Tagging release 10.0.1"
git push
git push --tags
```


## Prepare next iteration

```bash
# change release in poms
git add -A
git commit -S -m 'Next release cycle'
git push
```

## Create release and upload artifacts to Github

Manually creating the release in Github project page, and upload generated artifacts.
