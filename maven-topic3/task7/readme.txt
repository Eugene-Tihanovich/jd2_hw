set JAVA_HOME=d:\java\jdk-11
set PATH=%PATH%;d:\java\jdk-11\bin
cd /D d:\jd2_hw\maven-topic3\task7
mvn archetype:generate
org.apache.maven:
14
7
it.academy
firstWebApp


Y
cd firstWebApp
mvn compile
mvn test
mvn install