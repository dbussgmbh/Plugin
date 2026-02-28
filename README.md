# Minimal Plugin Template

Change only:
1) `plugin/src/main/resources/plugin/application.properties` (plugin.id, plugin.menu.name)
2) `plugin/src/main/java/.../MyPluginView.java` (your UI)
3) Optional: `plugin/pom.xml` artifactId

## Standalone run
mvn -pl demo-app -am spring-boot:run
http://localhost:8090/p/<plugin.id>

## Build plugin jar for host
mvn -pl plugin -am clean package
