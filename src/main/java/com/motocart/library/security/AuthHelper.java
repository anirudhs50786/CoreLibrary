package com.motocart.library.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class AuthHelper {
    private AuthHelper() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static int getAuthUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof Principal user) {
            return user.userId();
        }
        throw new IllegalStateException("Principal is of unsupported type");
    }

    public static Set<String> getRoles() {
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    }
}
