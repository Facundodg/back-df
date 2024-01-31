package com.dim.Conf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

//@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class TestConfig {
    // Puedes agregar configuraciones específicas de prueba aquí
}
