package com.example.charlie;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import com.example.charlie.ProductRestController.ProductController;
import com.example.charlie.ProductRestController.ProductRestController;
import com.example.charlie.entities.Coupons;
import com.example.charlie.entities.Products;
import com.example.charlie.repos.ProductRepository;
import com.example.charlie.entities.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CharlieApplicationTests{
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    ObjectMapper om = new ObjectMapper();
    Response response;

    @Before
    public void setUp(){
        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getProductsTest() throws Exception {
            RequestBuilder request = MockMvcRequestBuilders
            .get("/products/")
            .accept(MediaType.APPLICATION_JSON);
            MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"product\":\"Pencil\",\"productCode\":\"PNC\",\"price\":5},{\"id\":2,\"product\":\"Pen\",\"productCode\":\"PEN\",\"price\":50},{\"id\":3,\"product\":\"Ink\",\"productCode\":\"INK\",\"price\":20},{\"id\":4,\"product\":\"Notebook\",\"productCode\":\"NTB\",\"price\":50}]"))
                .andReturn();

        /*
        DocumentContext context= JsonPath.parse(mvcResult);
        System.out.println(context.read("$.[0:4]").toString());
         */
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    public void getCouponsTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/coupons/")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":5,\"couponCode\":\"50OFF\"},{\"id\":6,\"couponCode\":\"25OFF\"},{\"id\":7,\"couponCode\":\"15OFF\"}]"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    public void saveProductTest() throws Exception {
        Products products = new Products();
        products.setId(10);
        products.setProduct("test product");
        products.setProductCode("TP");
        products.setPrice(50);
        String jsonRequest = om.writeValueAsString(products);
        MvcResult result = mockMvc.perform(post("/products/").content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        Response response = om.readValue(resultContent, Response.class);
        Assert.assertTrue(response.isStatus() == Boolean.TRUE);
    }

    @Test
    public void saveCouponTest() throws Exception {
        Coupons coupons = new Coupons();
        coupons.setId(12);
        coupons.setCouponCode("test coupon");
        String jsonRequest = om.writeValueAsString(coupons);
        MvcResult result = mockMvc.perform(post("/coupons/").content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        Response response = om.readValue(resultContent, Response.class);
        Assert.assertTrue(response.isStatus() == Boolean.TRUE);
    }


}


