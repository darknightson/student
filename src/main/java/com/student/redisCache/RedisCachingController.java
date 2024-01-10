package com.student.redisCache;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedisCachingController {

    private final RedisCachingService redisCachingService;

    @GetMapping("/user/{userId}/profile")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable("userId") String userId) {
        UserProfile userProfile = redisCachingService.getUserProfile(userId);
        return ResponseEntity.ok(userProfile);
    }

    @GetMapping("/user/{userId}/profile/manual")
    public ResponseEntity<UserProfile> getUserProfileManual(@PathVariable("userId") String userId) {
        UserProfile userProfile = redisCachingService.getUserProfileManual(userId);
        return ResponseEntity.ok(userProfile);
    }
}
