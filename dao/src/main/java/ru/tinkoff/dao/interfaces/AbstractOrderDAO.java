package ru.tinkoff.dao.interfaces;

import ru.tinkoff.entities.Order;

public abstract class AbstractOrderDAO extends AbstractDAO<Order> {
    public abstract Order getLastOrderByAccountId(Long id);
}
