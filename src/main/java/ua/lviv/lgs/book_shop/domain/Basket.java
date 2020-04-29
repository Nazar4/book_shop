package ua.lviv.lgs.book_shop.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode


@Entity
public class Basket {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private List<Product> product;

    private String sessionId;

    private Double allPrice;

    private Long allProduct;


}
