package ua.lviv.lgs.book_shop.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.lviv.lgs.book_shop.domain.Product;

@Component
public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
            return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;
        ValidationUtils.rejectIfEmpty(errors, "name", "Not empty", "This line cannot be empty");
        ValidationUtils.rejectIfEmpty(errors, "genre", "Not empty", "This line cannot be empty");
        ValidationUtils.rejectIfEmpty(errors, "genre", "Not empty","This line cannot be empty");
    }
}
