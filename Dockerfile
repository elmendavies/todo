FROM openjdk


COPY build/libs/todo-0.1.jar /todo-0.1.jar

CMD ["java", "-jar", "/todo-0.1.jar" ]

