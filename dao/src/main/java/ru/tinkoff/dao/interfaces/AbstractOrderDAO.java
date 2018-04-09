package ru.tinkoff.dao.interfaces;

import ru.tinkoff.Order;

public abstract class AbstractOrderDAO extends AbstractDAO<Order> {
    protected static final String GET_LAST_ORDER_BY_ACCOUNT_ID_METHOD = "getLastOrderByAccountId";

    public abstract Order getLastOrderByAccountId(Long id);
}