package com.dd_kotlin.blog

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(acteurRepository: ActeurRepository) = ApplicationRunner {

        //val smaldini = acteurRepository.save(Acteur("smaldini", "Stéphane", "Maldini"))
    }
}