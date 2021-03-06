package ua.lviv.lgs.book_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.book_shop.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product);




}
