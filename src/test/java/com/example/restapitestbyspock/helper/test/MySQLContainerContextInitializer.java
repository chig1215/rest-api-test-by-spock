package com.example.restapitestbyspock.helper.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;

@SuppressWarnings({"rawtypes", "unchecked"})
public class MySQLContainerContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MySQLContainerContextInitializer.class);

    private static final MySQLContainer MYSQL =
            new MySQLContainer("mysql:latest") {
                {
                    withDatabaseName("kinto");
                    withUsername("chig1215");
                    withPassword("chig1215");
                    withExposedPorts(3306);
                    withLogConsumer(new Slf4jLogConsumer(LOGGER));
                    withClasspathResourceMapping(
                            "mysql/conf.d",
                            "/etc/mysql/conf.d", BindMode.READ_ONLY);
                    withClasspathResourceMapping(
                            "flyway/sql",
                            "/docker-entrypoint-initdb.d", BindMode.READ_ONLY);
                }
            };

    static {
        MYSQL.start();
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        TestPropertyValues.of("spring.datasource.url=" + MYSQL.getJdbcUrl())
                .applyTo(applicationContext.getEnvironment());
    }
}
