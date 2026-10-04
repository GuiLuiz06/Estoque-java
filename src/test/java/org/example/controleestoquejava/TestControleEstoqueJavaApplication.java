package org.example.controleestoquejava;

import org.springframework.boot.SpringApplication;

public class TestControleEstoqueJavaApplication {

    public static void main(String[] args) {
        SpringApplication.from(ControleEstoqueJavaApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
