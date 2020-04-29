package ua.lviv.lgs.book_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.book_shop.domain.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

    Basket findBySessionId(String sessionId);
}
