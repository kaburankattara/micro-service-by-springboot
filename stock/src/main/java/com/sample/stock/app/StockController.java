package com.sample.stock.app;

import com.sample.stock.domain.stock.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.sample.stock.app.StockConst.*;

@RequestMapping(URL_BEAN_ROOT)
@Controller
public class StockController {

    @GetMapping()
    public String index() {
        return "redirect:" + URL_VIEW;
    }

    @GetMapping(URL_BEAN_VIEW)
    public String view(Model model) {
        Stock stock = Stock.createInstanceForAdd(10);
        model.addAttribute("stock", stock);
        return "index";
    }

    @ResponseBody
    @GetMapping(URL_BEAN_ADD)
    public String add() {
        return "在庫を追加します";
    }
}
