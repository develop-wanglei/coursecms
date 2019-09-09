package com.newtechcollege.cms.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
/**
 * 
 * Redis封装get、set工具 
  * @return : null
 * @author wanglei
 * @date 2019/8/23 16:34
 */
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate redisTemplate;

    public void set(String key, String value, Integer time) {
        //time的时间为秒
        /*set()
        第一个参数：存放的数据的名称String.format(RedisConstant.TOKEN_PREFIX, token)
        第二个参数：存放的内容：openid
        第三个参数：存放的时间：expire
        第四个参数：存放的格式：TimeUnit.SECONDS
        * */
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);

    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void delete(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
    }
}
