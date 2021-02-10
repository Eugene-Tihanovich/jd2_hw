package it.academy;

import it.academy.config.Config;
import it.academy.pojos.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        Car car = ac.getBean(Car.class);
        System.out.println(car.toString());
    }
}