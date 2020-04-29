package ua.lviv.lgs.book_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.lviv.lgs.book_shop.controller.validator.UserValidator;
import ua.lviv.lgs.book_shop.domain.Basket;
import ua.lviv.lgs.book_shop.domain.User;
import ua.lviv.lgs.book_shop.repository.RoleRepository;
import ua.lviv.lgs.book_shop.service.BasketService;
import ua.lviv.lgs.book_shop.service.UserService;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserValidator userValidator;

    private final UserService userService;

    private final BasketService basketService;

    private final RoleRepository roleRepository;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String LoginPage(){
        return "redirect:home";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User user, BindingResult bindingResult) {
        Basket basket = new Basket();
        basketService.save(basket);
        user.setBasket(basket);
        user.getRoles().add(roleRepository.findByName("ROLE_USER"));
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.registerNewUser(user);
        return "redirect:/login";
        }
}

