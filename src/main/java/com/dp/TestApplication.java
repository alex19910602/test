package com.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class TestApplication {
    public static void main( String[] args ) {
        SpringApplication.run(TestApplication.class,args);
    }
}
