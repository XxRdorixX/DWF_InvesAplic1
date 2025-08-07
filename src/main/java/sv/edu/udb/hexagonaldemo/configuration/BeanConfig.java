package sv.edu.udb.hexagonaldemo.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    // Aquí ya no es necesario definir @Bean manual,
    // porque usamos @Component en el adaptador y Spring Data JPA
}