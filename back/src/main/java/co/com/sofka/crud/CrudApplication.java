package co.com.sofka.crud;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Inicia el proyecto.
 *
 * @autor Jose David Echavarria Ruiz.
 */
@SpringBootApplication
public class CrudApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

}
