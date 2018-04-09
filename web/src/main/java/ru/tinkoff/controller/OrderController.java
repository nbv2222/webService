package ru.tinkoff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.tinkoff.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    protected String getLastOrder(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "responseType", required = false) String responseType) {
        return orderService.getLastOrderByAccountId(id, responseType);
    }
}
