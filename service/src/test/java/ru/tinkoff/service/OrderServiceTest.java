package ru.tinkoff.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-service-test.xml")
public class OrderServiceTest extends TestCase {
    @Autowired
    private OrderService orderService;

    @Test
    public void testGetLastOrderByAccountId() throws Exception {
        String actualJson = orderService.getLastOrderByAccountId(1L, "");
        String expectedJson = "{\"applicationId";
        assertTrue(actualJson.startsWith(expectedJson));
    }
}