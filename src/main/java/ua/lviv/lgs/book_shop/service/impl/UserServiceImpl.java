package ua.lviv.lgs.book_shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.book_shop.domain.User;
import ua.lviv.lgs.book_shop.repository.RoleRepository;
import ua.lviv.lgs.book_shop.repository.UserRepository;
import ua.lviv.lgs.book_shop.service.UserService;
import ua.lviv.lgs.book_shop.service.exceptions.EntityNotFoundException;
import ua.lviv.lgs.book_shop.service.exceptions.UserAlreadyExistException;
import ua.lviv.lgs.book_shop.utils.SecurityUtils;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void registerNewUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistException();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("" + id));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Long findCurrentUserId() {
        return userRepository.findByUsername(SecurityUtils.getCurrentUserName()).get().getId();
        }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name).orElseThrow(() -> new EntityNotFoundException("User with name: " + name + " was not found"));
    }
}

