Запустил Tomcat через командную строку
Создал maven-project в IDEA
Добавил папки webapp - WEB-INF
Добавил <packaging>war</packaging> в pom.xml
Добавил dependency javax-servlet-api в pom.xml
Добавил plugins в pom.xml в частности tomcat-maven-plugin
Сделал MyServlet в it.academy.servlet
Установил webapp on Tomcat с помощью tomcat-maven-plugin (tomcat:deploy)
Зашел в менеджер Tomcat, нашел свое webapp, проверил его работоспособность
Переустановил приложение с помощью tomcat:redeploy
Выполнил tomcat:info и tomcat:list
Все работает


