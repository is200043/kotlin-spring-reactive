package com.reactive.web.config

import com.reactive.db.entity.Product
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer


import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.data.redis.serializer.RedisSerializationContext.RedisSerializationContextBuilder


@Configuration
class RedisConfig() {

    @Bean
    fun reactiveRedisOperations(reactiveRedisConnectionFactory: ReactiveRedisConnectionFactory): ReactiveRedisOperations<String, Product> {
        val serializer: Jackson2JsonRedisSerializer<Product> = Jackson2JsonRedisSerializer(Product::class.java)
        val builder: RedisSerializationContextBuilder<String, Product> = RedisSerializationContext.newSerializationContext(StringRedisSerializer())
        val context: RedisSerializationContext<String, Product> = builder.value(serializer).build()
        return ReactiveRedisTemplate(reactiveRedisConnectionFactory, context)
    }
}