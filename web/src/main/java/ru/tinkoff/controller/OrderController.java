package ru.tinkoff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.tinkoff.entities.Order;
import ru.tinkoff.service.OrderService;
import ru.tinkoff.utils.JsonHelper;
import ru.tinkoff.utils.XmlHelper;

@Controller
public class OrderController {
    private static final String XML = "XML";
    private static final String JSON = "JSON";

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    protected String getLastOrder(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "responseType", required = false) String responseType) {

        Order lastOrderByAccountId;

        try {
            lastOrderByAccountId = orderService.getLastOrderByAccountId(id);
        } catch (Exception e) {
            //place for logger
            return JsonHelper.exceptionJson(e);
        }

        return XML.equalsIgnoreCase(responseType)
                ? XmlHelper.convert(lastOrderByAccountId)
                : JsonHelper.convert(lastOrderByAccountId);

    }
}
