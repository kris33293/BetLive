package com.kodilla.betlive;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableVaadin({"com.kodilla.books"})
@SpringBootApplication
public class BetLiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(BetLiveApplication.class, args);
    }

}
