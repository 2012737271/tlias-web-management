package com.itheima.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 阿里云OSS配置属性类
 * 用于读取配置文件中以 aliyun.oss 为前缀的配置项，
 * 并自动映射到对应的属性字段上。
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSProperties {

    /** OSS访问端点，例如：https://oss-cn-beijing.aliyuncs.com */
    private String endpoint;

    /** OSS存储空间名称（Bucket名称） */
    private String bucketName;

    /** OSS所在地域，例如：cn-beijing */
    private String region;
}