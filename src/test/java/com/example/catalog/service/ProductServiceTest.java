package com.example.catalog.service;

import com.example.catalog.model.Product;
import com.example.catalog.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImp productService;

    @Test
    void testGetAllProducts(){
        List<Product> list= new ArrayList<>();
        Product p1 = new Product(1L,"mac","laptop",
                new BigDecimal(2777.0),"eletronics",true);

        Product p2 = new Product(2L,"phone","phone",
                new BigDecimal(2777.0),"eletronics",true);
        Product p3 = new Product(3L,"mobile","mobile",
                new BigDecimal(2777.0),"eletronics",true);
        list.add(p1);
        list.add(p2);
        list.add(p3);

        Mockito.when(productRepository.findAll())
                .thenReturn(list);

        List actualList = productService.getAllProducts();

        Assertions.assertEquals(3, actualList.size());
    }
//public Product getProductById(Long id) {
//        return productRepository.findById(id).orElse(null);
//    }


    @Test
    void testGetProductById(){
        Long productId=1L;


            Product p1 = new Product(1L,"mac","laptop",
                    new BigDecimal(2777.0),"eletronics",true);



        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(p1));
         Product result = productService.getProductById(productId);
        Assertions.assertEquals(p1,result );

        //public Product addProduct(Product product) {
        //25         return productRepository.save(product);
        //26     }

    }

    @Test
    void testAddProduct(){
        Product p1 = new Product(1L,"mac","laptop",
                new BigDecimal(2777.0),"eletronics",true);
       List<Product> list = new ArrayList<>();
       list.add(p1);
        Mockito.when(productRepository.save(p1)).thenReturn(p1);

        Product result = productService.addProduct(p1);
        Assertions.assertEquals(p1,result );

    }

}
