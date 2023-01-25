package br.com.bummpay;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class WebConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return  args -> {
            System.out.println("Rodando de configuração de Desenvolvimento");
        };
    }



}
