package com.sample.stock.app;

import com.sample.stock.domain.stock.Stock;
import com.sample.stock.domain.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class StockManagerService {

    private StockService stockService;

    @Autowired
    public StockManagerService(StockService stockService) {
        this.stockService = stockService;
    }

    public Stock add(int stockCount) {
        try {
            Stock stock = stockService.createStock(stockCount);
            return stockService.add(stock);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
