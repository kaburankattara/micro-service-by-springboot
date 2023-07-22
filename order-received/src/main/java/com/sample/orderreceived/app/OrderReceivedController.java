package com.sample.orderreceived.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/order-received")
@Controller
public class OrderReceivedController {

    @ResponseBody
    @GetMapping()
    public String orderReceived() {
        return "Order Received";
    }

}
