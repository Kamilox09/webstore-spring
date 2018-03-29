package com.packt.webstore.controller;


import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RequestMapping("/products")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/all")
    public String allProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "products";
    }

    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria")
                                              Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping("/{category}/{price}")
    public String filterProducts(Model model, @PathVariable String category,
                                 @MatrixVariable(pathVar = "price") Map<String, List<String>> filterPrice,
                                 @RequestParam("manufacturer") String manufacturer) {
        model.addAttribute("products", productService.getProductsByAdvancedFilter(category, filterPrice, manufacturer));


        return "products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model) {
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
        productService.addProduct(newProduct);
        return "redirect:/products";
    }
}
