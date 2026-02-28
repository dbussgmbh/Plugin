package com.example.plugin.demo;

import com.example.core.plugin.PluginUi;
import com.example.plugin.demo.runtime.PluginRegistry;
import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ServiceLoader;

@EnableVaadin("com.example.plugin.demo")
@SpringBootApplication(scanBasePackages = {"com.example.plugin.demo","com.example.plugins"})
public class DemoApplication {
    public static void main(String[] args) { SpringApplication.run(DemoApplication.class, args); }

    @Bean
    ApplicationRunner load(PluginRegistry registry) {
        return args -> ServiceLoader.load(PluginUi.class).forEach(registry::put);
    }
}
