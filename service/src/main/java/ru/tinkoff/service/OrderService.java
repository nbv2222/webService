package ru.tinkoff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import ru.tinkoff.dao.OrderDAO;
import ru.tinkoff.dao.interfaces.AbstractOrderDAO;
import ru.tinkoff.entities.Order;
import ru.tinkoff.interfaces.AbstractOrderService;

@Service
public class OrderService extends AbstractOrderService {
    @Autowired
    private AbstractOrderDAO orderDAO;

    public Order getLastOrderByAccountId(Long id) {
        return orderDAO.getLastOrderByAccountId(id);
    }

}
