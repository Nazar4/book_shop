package ua.lviv.lgs.book_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.lviv.lgs.book_shop.domain.Product;
import ua.lviv.lgs.book_shop.service.ProductService;

import java.util.List;

@RequiredArgsConstructor
@Controller()
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/products")
    public String getProductsPage(Model model) {
        List<Product> products =productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }
}