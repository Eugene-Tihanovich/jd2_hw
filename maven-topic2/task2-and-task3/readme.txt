set JAVA_HOME=d:\java\jdk-11
set PATH=%PATH%;d:\java\jdk-11\bin
cd /D d:\jd2_hw\maven-topic2
md task2-and-task3
cd task2-and-task3
mvn archetype:generate
maven-archetype-quickstart
2
8
it.academy
example-maven


Y
cd example-maven
mvn compile
mvn test


В Idea IDE настроил Maven: указал home path, user setting files и local repository. Также поменял версию java на 11 в pom.xml, project setting (project and modules) и в java compiler в соответствующем module.


В проект добавил тесты и ресурсы. Скомпилировал. Все работает.