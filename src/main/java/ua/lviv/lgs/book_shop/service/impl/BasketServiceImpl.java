package ua.lviv.lgs.book_shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.book_shop.domain.Basket;
import ua.lviv.lgs.book_shop.repository.BasketRepository;
import ua.lviv.lgs.book_shop.service.BasketService;
import ua.lviv.lgs.book_shop.service.exceptions.EntityNotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;

    @Override
    public Basket save(Basket bucket) {
        return basketRepository.save(bucket);
    }

    @Override
    public Basket findBySessionId(String sessionId) {
        return basketRepository.findBySessionId(sessionId);
    }

    @Override
    public Basket findById(Long id) {
        return basketRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("" + id));
    }

    @Override
    public Basket update(Basket bucket) {
        return basketRepository.saveAndFlush(bucket);
    }

    @Override
    public void deleteById(Long id) {
        basketRepository.deleteById(id);
    }

    @Override
    public List<Basket> findAll() {
        return basketRepository.findAll();
    }
}
