package ua.lviv.lgs.book_shop.service;

import ua.lviv.lgs.book_shop.domain.User;

public interface UserService {

    User save(User user);

    void registerNewUser(User user);

    User findById(Long id);

    void deleteById(Long id);

    Long findCurrentUserId();

    User findByUsername(String name);
}
