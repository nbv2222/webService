package ru.tinkoff.interfaces;

import ru.tinkoff.entities.Order;

public abstract class AbstractOrderService extends AbstractService {
    public abstract Order getLastOrderByAccountId(Long id);
}
