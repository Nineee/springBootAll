package com.nineee.springboot.Utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: ljj
 * @Date: 2019/7/18 11:33
 * @Desc
 */
@Configuration
public class JedisConfig {

    /**
     * redis pool配置信息
     * */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.pool")
    public static JedisPoolConfig getRedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public static JedisConnectionFactory getConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setUsePool(true);
        JedisPoolConfig config = getRedisConfig();
        factory.setPoolConfig(config);
        return factory;
    }

    @Bean
    public RedisTemplate<?, ?> getRedisTemplate() {
        JedisConnectionFactory factory = getConnectionFactory();
        RedisTemplate<?, ?> template = new StringRedisTemplate(factory);
        return template;
    }

    @Bean
    public static Jedis getJedis(){
        JedisConnectionFactory factory = getConnectionFactory();
        Jedis jedis = new Jedis(factory.getHostName(),factory.getPort(),factory.getTimeout());
        return jedis;
    }
}
