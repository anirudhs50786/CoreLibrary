package com.motocart.library.security.user.service;

import com.motocart.library.cache.RedisCacheService;
import com.motocart.library.common.dto.response.UserProfileResponseDTO;
import com.motocart.library.security.AuthHelper;
import com.motocart.library.security.user.integration.ProfileServiceClient;
import com.motocart.library.security.user.vo.UserVO;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class UserService {

    private final RedisCacheService cacheService;

    private final ProfileServiceClient profileServiceClient;

    public UserService(RedisCacheService cacheService, ProfileServiceClient profileServiceClient) {
        this.cacheService = cacheService;
        this.profileServiceClient = profileServiceClient;
    }

    public UserVO getUserById(int userId) {
        UserVO cachedUser = cacheService.get("user:" + userId, UserVO.class);
        if (cachedUser != null) {
            return cachedUser;
        }

        UserVO userVO = fetchUserFromAuthServer(userId);

        // Cache the result for future requests
        cacheService.put("user:" + userId, userVO, Duration.ofMinutes(30));

        return userVO;
    }

    public UserVO getUser() {
        return getUserById(AuthHelper.getAuthUserId());
    }

    private UserVO fetchUserFromAuthServer(int userId) {
        UserProfileResponseDTO profile = profileServiceClient.getUserProfile(userId);
        return UserVO.builder()
                .userId(profile.getUserId())
                .username(profile.getUsername())
                .email(profile.getEmail())
                .firstName(profile.getFirstName())
                .lastName(profile.getLastName())
                .build();
    }

}
