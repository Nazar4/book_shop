package ua.lviv.lgs.book_shop.service;

import ua.lviv.lgs.book_shop.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product save(Product product);

    Product update(Product product);

    void deleteById(Long id);

    List<Product> findAll();

     Optional<Product> findById(Long id);
}
