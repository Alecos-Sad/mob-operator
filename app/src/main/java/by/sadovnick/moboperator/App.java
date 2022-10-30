package by.sadovnick.moboperator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Start application class
 */
@SpringBootApplication(scanBasePackages = "by.sadovnick.*")
@EnableAspectJAutoProxy
@EnableFeignClients
public class App {
    static {
        System.setProperty("log4j.shutdownCallbackRegistry", "com.djdch.log4j.StaticShutdownCallbackRegistry");
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
