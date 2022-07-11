package com.openaudio.oa.common.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置
 */
@Configuration
public class RedisConfig {

    /**
     * RedisTemplate
     * spring 封装了 RedisTemplate 对象来进行对redis的各种操作，它支持所有的 redis 原生的 api。
     *
     * RedisConnectionFactory Redis 连接的线程安全工厂。
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){

        /*
        模板中的Redis key的类型（通常为String）如：RedisTemplate<String, Object>
        注意：如果没特殊情况，切勿定义成RedisTemplate<Object, Object>，否则根据里氏替换原则，使用的时候会造成类型错误。
         */
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
        //设置连接工厂
        redisTemplate.setConnectionFactory(factory);
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        /**
         * ObjectMapper类是Jackson库的主要类。
         * 它提供一些功能将转换成Java对象匹配JSON结构，反之亦然。它使用JsonParser和JsonGenerator的实例实现JSON实际的读/写。
         */
        ObjectMapper mapper = new ObjectMapper();

        /*
            PropertyAccessor是可以访问命名属性named properties（例如对象的bean属性或对象中的字段）的类的公共接口
            @JsonAutoDetect
            默认情况下，jackson获取public权限的字段进行系列化和反系列化。如果没有public权限的字段，就会去获取public修饰的getter/setter。
            使用 JsonAutoDetect注解，我们就可以修改默认的行为。
            fieldVisibility = Visibility.ANY 包含所有field属性并设为可见

         */
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);


        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(mapper);
        //简单字符串到 byte[]（和返回）序列化程序。
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // key采用String的序列化方式
        redisTemplate.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        redisTemplate.afterPropertiesSet();


        return redisTemplate;
    }


}
