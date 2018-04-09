package ru.tinkoff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tinkoff.Order;
import ru.tinkoff.dao.interfaces.AbstractOrderDAO;
import ru.tinkoff.interfaces.AbstractOrderService;
import ru.tinkoff.utils.JsonHelper;
import ru.tinkoff.utils.XmlHelper;

@Service
public class OrderService extends AbstractOrderService {

    private static final String XML = "XML";
    private static final String JSON = "JSON";

    private AbstractOrderDAO orderDAO;

    @Autowired
    public OrderService(AbstractOrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public String getLastOrderByAccountId(Long id, String responseType) {
        Order lastOrderByAccountId;

        try {
            lastOrderByAccountId = orderDAO.getLastOrderByAccountId(id);
        } catch (Exception e) {
            return JsonHelper.exceptionJson(e);
        }

        return XML.equalsIgnoreCase(responseType)
                ? XmlHelper.convert(lastOrderByAccountId)
                : JsonHelper.convert(lastOrderByAccountId);
    }
}

