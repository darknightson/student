package com.student.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisConfigTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @BeforeEach
    public void setup() {
        ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        valueOps.set("name", "anthony");
    }


    @Test
    public void testGetNameKeyValue() {
        ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        String value = (String) valueOps.get("name");
        System.out.println("Value for 'name' key: " + value);
    }
}