package main;

import controller.GridGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationTargetException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        boolean CLI = true;
        if (CLI) {
            new GridGame().commandLine();
        } else {
            ApplicationContext ctx = SpringApplication.run(Application.class, args);
        }
    }
}