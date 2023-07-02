package com.gientech.core.redis;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;

/**
 * 网上抄的，能用
 * 
 * @author 胡砥峰
 *
 */
@EnableCaching
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

	@Bean(name = "redisTemplate")
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<Object, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);

		Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<Object>(Object.class);

		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
		serializer.setObjectMapper(om);

		template.setValueSerializer(serializer);
		template.afterPropertiesSet();

		// value值的序列化采用fastJsonRedisSerializer
		template.setValueSerializer(serializer);
		template.setHashValueSerializer(serializer);

		// key的序列化采用StringRedisSerializer
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());

		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory factory) {
		// 生成一个默认配置，通过config对象即可对缓存进行自定义配置
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();

		// 设置缓存的默认过期时间，也是使用Duration设置
		config = config.entryTtl(Duration.ofMinutes(1)).disableCachingNullValues(); // 不缓存空值

		// 设置一个初始化的缓存空间set集合
		Set<String> cacheNames = new HashSet<>();
		cacheNames.add("my-redis-cache1");
		cacheNames.add("my-redis-cache2");

		// 对每个缓存空间应用不同的配置
		Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
		configMap.put("my-redis-cache1", config);
		configMap.put("my-redis-cache2", config.entryTtl(Duration.ofSeconds(120)));

		// 使用自定义的缓存配置初始化一个cacheManager
		// 注意这两句的调用顺序，一定要先调用该方法设置初始化的缓存名，再初始化相关的配置
		RedisCacheManager cacheManager = RedisCacheManager.builder(factory).initialCacheNames(cacheNames).withInitialCacheConfigurations(configMap).build();
		return cacheManager;
	}
}