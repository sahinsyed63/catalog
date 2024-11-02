package com.example.catalog.controller;


import com.example.catalog.model.Product;
import com.example.catalog.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
   @Autowired
   private MockMvc mockMvc;
    @MockBean
       private ProductService productService;
    @Test
    public void testGetAllProducts() throws Exception {
          List<Product> list = new ArrayList<>();
        Product p1 = new Product(1L,"mac","laptop",
                new BigDecimal(2777.0),"eletronics",true);

        Product p2 = new Product(2L,"phone","phone",
                new BigDecimal(2777.0),"eletronics",true);
        Product p3 = new Product(3L,"mobile","mobile",
                new BigDecimal(2777.0),"eletronics",true);
        list.add(p1);
        list.add(p2);
        list.add(p3);

        when(productService.getAllProducts()).thenReturn(list);

        mockMvc.perform(get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())  // Print the response body for debugging
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].name").value("mac"))
                .andExpect(jsonPath("$[1].name").value("phone"))
                .andExpect(jsonPath("$[2].name").value("mobile"));

    }



}
