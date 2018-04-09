package ru.tinkoff.interfaces;

public abstract class AbstractOrderService extends AbstractService {
    public abstract String getLastOrderByAccountId(Long id, String responseType);
}
