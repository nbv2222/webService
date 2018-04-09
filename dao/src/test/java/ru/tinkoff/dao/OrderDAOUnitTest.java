package ru.tinkoff.dao;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tinkoff.Order;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-dao-test.xml")
@SpringBootTest
public class OrderDAOUnitTest extends TestCase {

    @Autowired
    private OrderDAO orderDAO;

    @Test
    public void testGetLastOrderByAccountId() throws Exception {
        Long id = 1L;

        Order expected = new Order();
        expected.setProductName("phone");
        expected.setDtCreated(LocalDateTime.parse("2018-04-07T23:52:17"));
        expected.setContactId(id);
        expected.setApplicationId(id);

        Order actual = orderDAO.getLastOrderByAccountId(id);
        assertOrder(actual, expected);
    }

    private static void assertOrder(Order actual, Order expected) {
        assertEquals(expected.getApplicationId(), actual.getApplicationId());
        assertEquals(expected.getContactId(), actual.getContactId());
        assertEquals(expected.getDtCreated(), actual.getDtCreated());
        assertEquals(expected.getProductName(), actual.getProductName());
    }
}