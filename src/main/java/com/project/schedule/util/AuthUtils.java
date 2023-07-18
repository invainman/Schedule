package com.project.schedule.util;

import com.project.schedule.security.UserDetailsImpl;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

@UtilityClass
public class AuthUtils {

    public static UserDetailsImpl getAccountDetails() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (Objects.isNull(securityContext)) {
            return null;
        }
        Authentication authentication = securityContext.getAuthentication();
        if (Objects.isNull(authentication)) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (Objects.nonNull(principal) && principal instanceof UserDetailsImpl) {
            return (UserDetailsImpl) principal;
        }
        return null;
    }
}
