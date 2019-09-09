package com.newtechcollege.cms.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "qiniu")
public class QiniuConstant {

    private String accessKey = "-Tzn5uY3hrt7IoG__SA3XruOCJve1mrMpU4QWHWu";

    private String secretKey = "V8jfz5TXXxrKAGXr4k_EOGPyOmocL02y7ksCgStM";

    private String bucket = "course";

    private String path = "http://qiniu.zhijiaozhijia.com";
    /**
     * @return the accessKey
     */
    public String getAccessKey() {
        return accessKey;
    }
    /**
     * @return the secretKey
     */
    public String getSecretKey() {
        return secretKey;
    }
    /**
     * @return the bucket
     */
    public String getBucket() {
        return bucket;
    }
    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }
}

