package ua.lviv.lgs.book_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.lviv.lgs.book_shop.repository.UserRepository;
import ua.lviv.lgs.book_shop.service.BasketService;
import ua.lviv.lgs.book_shop.service.ProductService;
import ua.lviv.lgs.book_shop.service.UserService;

@RequiredArgsConstructor
@Controller
public class BasketController {

    private final UserService userService;

    private final ProductService productService;

    private final BasketService basketService;

    private final UserRepository userRepository;

    @GetMapping("/basket-is-empty")
    public String getBasketPage(){
        return "basket-is-empty";
    }

 /*   @GetMapping("/basket")
    public String addGoodsToBasket(HttpServletRequest request, @RequestParam Long id) {
        if (request.isUserInRole("ROLE_USER")) {
            Principal principal = request.getUserPrincipal();
            User user = userService.findByUsername(principal.getName());
            Basket basket = user.getBasket();
            createBasket(id, basket);
        } else {
            String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
            Basket nowBasket = basketService.findBySessionId(sessionId);
            if (nowBasket != null) {
                createBasket(id, nowBasket);
            } else {
                Basket basket = new Basket();
                basketService.save(basket);
                basket.setSessionId(sessionId);
                createBasket(id, basket);
            }
        }
        return "redirect:/products";
    }


    @GetMapping("/userBasket")
    public String getBasket(Model model, HttpServletRequest request) {
        if (!request.isUserInRole("ROLE_USER")) {
            String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
            if (basketService.findBySessionId(sessionId) != null) {
                Basket basket = basketService.findBySessionId(sessionId);
                if (basket.getAllProduct() == null || basket.getAllProduct() == 0) {
                    return "basket-is-empty";
                }
                model.addAttribute("basket", basket);
            } else {
                Basket basket = new Basket();
                basketService.save(basket);
                basket.setSessionId(sessionId);
                basketService.save(basket);
                if (basket.getAllProduct() == null || basket.getAllProduct() == 0) {
                    return "basket-is-empty";
                }
                model.addAttribute("basket", basket);
            }
        } else {
            Principal principal = request.getUserPrincipal();
            User user = userService.findByUsername(principal.getName());
            Basket basket = user.getBasket();
            if (basket.getAllProduct() == null || basket.getAllProduct() == 0) {
                return "basket-is-empty";
            }
            model.addAttribute("basket", basket);
        }
        return "basket";
    }

    public void createBasket(@RequestParam Long id, Basket basket) {
        Product product = productService.findById(id).orElseThrow(() -> new EntityNotFoundException("Product with id: " + id + "was not found"));
        List<Product> products = new ArrayList<>();
        if (basket.getProduct() != null){
            products.addAll(basket.getProduct());
        }
        products.add(product);
        basket.setProduct(products);
        basketService.save(basket);
        basket.setAllProduct((long) basket.getProduct().size());
        Double price = (double) 0;
        for (int i = 0; i < basket.getProduct().size(); i++) {
            price = price + products.get(i).getPrice();
        }
        basket.setAllPrice(price);
        basketService.save(basket);
 */   }

