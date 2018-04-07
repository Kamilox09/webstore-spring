package com.packt.webstore.validator;


import com.packt.webstore.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductImageValidator implements Validator {
    private long allowedSize;

    public void setAllowedSize(long allowedSize) {
        this.allowedSize = allowedSize;
    }

    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        if (product.getProductImage().getSize() > allowedSize) {
            errors.rejectValue("productImage", "com.packt.webstore.validator.ProductImageValidator.message");
        }
    }
}
