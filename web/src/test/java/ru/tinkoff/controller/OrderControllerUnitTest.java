package ru.tinkoff.controller;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tinkoff.service.OrderService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerUnitTest extends TestCase {
    @Mock
    private OrderService orderService;
    @InjectMocks
    private OrderController orderController;

    @Test
    public void testGetLastOrder() throws Exception {
        //prepare
        when(orderService.getLastOrderByAccountId(1L, "")).thenReturn("");
        //testing
        orderController.getLastOrder(1L, "");
        //validate
        verify(orderService).getLastOrderByAccountId(1L, "");
    }
}