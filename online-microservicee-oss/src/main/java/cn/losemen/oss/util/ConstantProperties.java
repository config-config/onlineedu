package cn.losemen.oss.util;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 读取aliyunoss配置文件
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/3 - 14:21
 */
@Component
@Data
@ConfigurationProperties(prefix = "aliyunossfile")
public class ConstantProperties implements InitializingBean {
    private String endpoint;

    private String keyId;
    private String keySecret;

    private String fileHost;

    private String bucketName;

    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;
    public static String FILE_HOST ;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_ID = keyId;
        ACCESS_KEY_SECRET = keySecret;
        BUCKET_NAME = bucketName;
        FILE_HOST = fileHost;
    }
}
