package ua.lviv.lgs.book_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.lviv.lgs.book_shop.service.UserService;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final UserService userService;

    @GetMapping
    public  String getHomePage() {
        return "home";
    }
}
