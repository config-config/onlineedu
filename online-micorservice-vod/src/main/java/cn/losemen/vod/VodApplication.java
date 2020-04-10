package cn.losemen.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/6 - 14:52
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//排除数据源的配置
@ComponentScan(basePackages={"cn.losemen.vod","cn.losemen.common"})
public class VodApplication {

    public static void main(String[] args) {
        SpringApplication.run(VodApplication.class, args);
    }
}