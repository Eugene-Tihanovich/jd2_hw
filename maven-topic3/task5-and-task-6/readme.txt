set JAVA_HOME=d:\java\jdk-11
set PATH=%PATH%;d:\java\jdk-11\bin
cd /D d:\jd2_hw\maven-topic3\task5
mvn archetype:generate
maven-archetype-quickstart
2
8
it.academy
parent-maven


Y
cd parent-maven
mvn archetype:generate
maven-archetype-quickstart
2
8
it.academy
maven-module1


Y
mvn archetype:generate
org.apache.maven:
14
7
it.academy
maven-module2

Y
mvn clean install



Для 6 задания добавил через Idea IDE в родительский и дочерние pom.xml зависимость для MySQL и затем пересобрал проект.