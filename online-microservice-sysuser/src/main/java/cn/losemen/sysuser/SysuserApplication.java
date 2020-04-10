package cn.losemen.sysuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author hz
 * @version 1.0
        * @Function
 * @date 2020/4/2 - 21:59
        */
@SpringBootApplication
public class SysuserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysuserApplication.class, args);
    }
}