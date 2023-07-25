package com.sample.stock.app;

import com.sample.stock.domain.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.sample.stock.app.StockManagerConst.*;

@RequestMapping(URL_BEAN_ROOT)
@Controller
public class StockManagerController {

    StockManagerService service;

    @Autowired
    public StockManagerController(StockManagerService service) {
        this.service = service;
    }

    @GetMapping()
    public String index() {
        return "redirect:" + URL_VIEW;
    }

    @GetMapping(URL_BEAN_VIEW)
    public String view(Model model) {
        try {
            Stock stock = service.findStock();
            model.addAttribute("stock", stock);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO
        }

        return "index";
    }

    @GetMapping(URL_BEAN_ADD)
    public String add(@RequestParam("stockId") long stockId) {
        Stock stock = service.add(stockId,10);
        return index();
    }
}
