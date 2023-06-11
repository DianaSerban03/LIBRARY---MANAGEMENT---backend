package com.mylibrary;

import com.mylibrary.model.Book;
import com.mylibrary.model.User;
import com.mylibrary.repository.IBook;
import com.mylibrary.repository.IUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Import(CorsConfig.class)
public class MyLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyLibraryApplication.class, args);
    }

    @Bean
    CommandLineRunner init(IUser teamRepository, IBook employeeRepository) {
        return args -> {
            for(User u: teamRepository.findAll())
                System.out.println("User: "+u.getUsername()+" "+u.getRole());
            System.out.println();
            for(Book u: employeeRepository.findAll())
                System.out.println("Book: "+u.getTitle());
            //employeeRepository.deleteById(123456);
            for(Book u: employeeRepository.findAll())
                System.out.println("Vook: "+u.getTitle());
            employeeRepository.findAll().forEach(System.out::println);
        };
    }

}
