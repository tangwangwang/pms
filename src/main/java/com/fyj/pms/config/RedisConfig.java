package com.fyj.pms.config;

import com.t2w.utils.redis.RedisClusterUtils;
import com.t2w.utils.redis.RedisSentinelUtils;
import com.t2w.utils.redis.RedisUtils;
import com.t2w.utils.redis.configuration.RedisClusterConfiguration;
import com.t2w.utils.redis.configuration.RedisConfiguration;
import com.t2w.utils.redis.configuration.RedisSentinelConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author T2W
 * @version V1.0.0
 * @email tang.wangwang@qq.com
 * @date 2019-09-10 17:01
 * @name com.fyj.pms.config.RedisConfig.java
 * @see describing
 */
@Configuration
public class RedisConfig {

    private final static String MASTER_REDIS_HOST = "redis.fuyujie.cn";

    private final static String SLAVE_REDIS_HOST = "redis.tangwangwang.com";

    private final static String REDIS_PASSWORD = "szby2019.";

    @Bean("redis")
    public RedisConfiguration redis() {
        RedisConfiguration configuration = new RedisConfiguration();
        configuration.setHost(MASTER_REDIS_HOST).setPort(6380).setPassword(REDIS_PASSWORD);
        RedisUtils.init(configuration);
        return configuration;
    }

    @Bean("redisSentinel")
    public RedisSentinelConfiguration redisSentinel() {
        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
        configuration.addNode(MASTER_REDIS_HOST, 6379).addNode(SLAVE_REDIS_HOST, 6379)
                     .setPassword(REDIS_PASSWORD);
        RedisSentinelUtils.init(configuration);
        return configuration;
    }

    @Bean("redisCluster")
    public RedisClusterConfiguration redisCluster() {
        RedisClusterConfiguration configuration = new RedisClusterConfiguration();
        configuration.addNode(SLAVE_REDIS_HOST, 6301).addNode(SLAVE_REDIS_HOST, 6302)
                     .addNode(SLAVE_REDIS_HOST, 6303).addNode(SLAVE_REDIS_HOST, 6304)
                     .addNode(MASTER_REDIS_HOST, 6301).addNode(MASTER_REDIS_HOST, 6302)
                     .addNode(MASTER_REDIS_HOST, 6303).addNode(MASTER_REDIS_HOST, 6304)
                     .addNode(MASTER_REDIS_HOST, 6305).setPassword("szby2019.");
        RedisClusterUtils.init(configuration);
        return configuration;
    }

}
