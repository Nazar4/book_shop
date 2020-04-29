package ua.lviv.lgs.book_shop.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityUtils {

    private SecurityUtils() {

    }

    public static String getCurrentUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();

    }

}
