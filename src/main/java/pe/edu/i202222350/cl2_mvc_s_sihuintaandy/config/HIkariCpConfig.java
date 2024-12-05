package pe.edu.i202222350.cl2_mvc_s_sihuintaandy.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableCaching
public class HIkariCpConfig {
    @Value("${DB_SAKILA_URL}")
    private String bdSakilaUrl;
    @Value("${DB_SAKILA_USER}")
    private String bdSakilaUser;
    @Value("${DB_SAKILA_PASS}")
    private String bdSakilaPass;
    @Value("${DB_SAKILA_DRIVER}")
    private String bdSakilaDriver;

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl( bdSakilaUrl);
        config.setUsername(bdSakilaUser);
        config.setPassword(bdSakilaPass);
        config.setDriverClassName(bdSakilaDriver);

        // configuracion de HikariCP
        config.setMaximumPoolSize(20); // numero maximo de conexiones en el pool
        config.setMinimumIdle(5); // numero minimo de conexiones que deben mantenerse inactivas en el pool
        config.setIdleTimeout(300000); // 5 minutos, tiempo en milisegundos despues del cual una conexion inactiva puede ser eliminada
        config.setConnectionTimeout(30000); // 30 segundos, tiempo en milisegundos que el pool espera para obtener una conexion antes de lanzar una excepcion
        System.out.println("###### HikariCP initialized ######");

        return new HikariDataSource(config);

    }


}


