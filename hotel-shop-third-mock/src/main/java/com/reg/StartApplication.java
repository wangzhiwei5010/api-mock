package com.reg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author wangzhiwei
 */
@SpringBootApplication(scanBasePackages = {"com.reg", "springfox.documentation"}, exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@ActiveProfiles("mock")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
