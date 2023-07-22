package com.sample.stock.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/stock")
@Controller
public class StockController {

    @ResponseBody
    @GetMapping("/add")
    public String add() {
        return "在庫を追加します";
    }

    @ResponseBody
    @GetMapping("/view")
    public String view() {
        return "在庫を一覧します";
    }

    @ResponseBody
    @GetMapping()
    public String root() {
        return "ルート";
    }
}
