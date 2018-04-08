package ru.tinkoff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.tinkoff.dao.interfaces.AbstractOrderDAO;
import ru.tinkoff.entities.Order;
import ru.tinkoff.interfaces.AbstractOrderService;

@Service
public class OrderService extends AbstractOrderService {
    @Autowired
    private AbstractOrderDAO orderDAO;

    public Order getLastOrderByAccountId(Long id) {
        Order order;
        try {
            order = orderDAO.getLastOrderByAccountId(id);
        } catch (EmptyResultDataAccessException up) {
            //place for logger
            throw up;
        }
        return order;
    }
}
