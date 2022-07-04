package com.sparta.spring_week01;

import com.sparta.spring_week01.models.Hanghae;
import com.sparta.spring_week01.models.HanghaeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringWeek01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringWeek01Application.class, args);
    }

    // Week02Application.java 의 main 함수 아래에 붙여주세요.
}