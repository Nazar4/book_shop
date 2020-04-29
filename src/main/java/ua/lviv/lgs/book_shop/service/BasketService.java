package ua.lviv.lgs.book_shop.service;

import ua.lviv.lgs.book_shop.domain.Basket;

import java.util.List;

public interface BasketService {

    Basket save(Basket bucket);

    Basket findBySessionId(String sessionId);

    Basket findById(Long id);

    Basket update(Basket bucket);

    void deleteById(Long id);

    List<Basket> findAll();
}
