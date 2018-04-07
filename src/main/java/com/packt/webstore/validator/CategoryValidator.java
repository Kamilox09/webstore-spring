package com.packt.webstore.validator;

import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<Category, String> {
    @Autowired
    private ProductService productService;

    public void initialize(Category constraintAnnotation) {
        Category.allowedCategories.add("Laptop");
        Category.allowedCategories.add("Tablet");
        Category.allowedCategories.add("Smartfon");
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (String cat : Category.allowedCategories) {
            if (cat.equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
