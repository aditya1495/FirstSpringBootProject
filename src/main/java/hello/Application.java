package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        boolean CLI = true;
        if (CLI) {
            new GridGame().commandLine();
        } else {
            ApplicationContext ctx = SpringApplication.run(Application.class, args);
        }
    }
}