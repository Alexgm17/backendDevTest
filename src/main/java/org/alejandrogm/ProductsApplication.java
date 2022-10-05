package org.alejandrogm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ({"org.alejandrogm.controller.*"})
public class ProductsApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ProductsApplication.class, args);
    }
}
