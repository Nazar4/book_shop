package ua.lviv.lgs.book_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ua.lviv.lgs.book_shop.controller.validator.ProductValidator;
import ua.lviv.lgs.book_shop.domain.Product;
import ua.lviv.lgs.book_shop.repository.RoleRepository;
import ua.lviv.lgs.book_shop.service.ProductService;
import ua.lviv.lgs.book_shop.service.exceptions.EntityNotFoundException;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
@RequestMapping("/products")
public class AdminProductsController {

    private final BasketController basketController;

    private final ProductService productService;

    private final RoleRepository roleRepository;

    private final ProductValidator productValidator;



    @Secured("ROLE_ADMIN")
    @GetMapping("/create-product")
    public String getPageCreateProduct(Model model){
        model.addAttribute("ProductForm", new Product());
        return "create-product";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/create-product")
    public String createProduct(@ModelAttribute("ProductForm") Product product, Errors errors){
        productValidator.validate(product, errors);
        if (errors.hasErrors()) {
            return "products";
        }
        productService.save(product);
        return "redirect:/products";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete")
    public String deleteGoods(@RequestParam Long id, HttpServletRequest request) {
            Product product = productService.findById(id).orElseThrow( () -> new EntityNotFoundException("Product with id: " + id + "was not found"));
            productService.deleteById(id);
        return "redirect:/products";
    }
}
