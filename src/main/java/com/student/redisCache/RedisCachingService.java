package com.student.redisCache;

import com.student.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisCachingService {

    private final UserRepository userRepository;
    private final StringRedisTemplate stringRedisTemplate;
    @Cacheable(value = "userProfile", key = "#userId")
    public UserProfile getUserProfile(String userId) {
        System.out.println("userId = " + userId);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new MemberNotFoundException(userId));
        System.out.println("user = " + user);
        return new UserProfile(user.getUsername(), user.getAge());
    }

    public UserProfile getUserProfileManual(String userId) {

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String cachedName = ops.get("myKey::" + userId);

        if ( cachedName != null ) {
            return new UserProfile(cachedName, 0);
        }

        User user = userRepository.findByUserId(userId).orElseThrow(() -> new MemberNotFoundException(userId));
        System.out.println("user = " + user);
        return new UserProfile(user.getUsername(), user.getAge());
    }
}
