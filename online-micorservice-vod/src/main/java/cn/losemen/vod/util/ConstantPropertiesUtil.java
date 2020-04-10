package cn.losemen.vod.util;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/6 - 15:06
 */

@Component
@Data
@ConfigurationProperties(prefix = "aliyunvodfile")
public class ConstantPropertiesUtil implements InitializingBean {
    private String keyId;

    private String keySecret;

    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;

    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESS_KEY_ID = keyId;
        ACCESS_KEY_SECRET = keySecret;
    }
}
