package com.kamar.ticketing_system_fin.user.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * the user app context configuration.
 * @author kamar baraka.*/

@Configuration
public class RestConfig {

    /**
     * create {@link org.springframework.web.client.RestTemplate} bean.
     * */
    @Bean
    public RestTemplate restTemplate(){

        /*create and return a rest template*/
        return new RestTemplate();
    }

    /**
     * create a model mapper bean.*/
    @Bean
    public ModelMapper modelMapper(){

        /*construct a new model mapper and return*/
        return new ModelMapper();
    }
}
