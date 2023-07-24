package com.sample.stock.app;

import com.sample.stock.domain.stock.Stock;
import com.sample.stock.domain.stock.StockService;
import com.sample.stock.domain.stockhistory.StockHistory;
import com.sample.stock.domain.stockhistory.StockHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static com.sample.stock.domain.stockhistory.StockHistory.SUBJECT_STOCK_ADD;

@Transactional
@Service
public class StockManagerService {

    private StockService stockService;

    private StockHistoryService stockHistoryService;

    @Autowired
    public StockManagerService(StockService stockService, StockHistoryService stockHistoryService) {
        this.stockService = stockService;
        this.stockHistoryService = stockHistoryService;
    }

    public Stock findStock() {
        int stockCount = 0;

        try {
            // 在庫を取得。なければ新規追加する
            Stock stock = stockService.findAllStock().getFirst();
            if (stock.isEmpty()) {
                stock = stockService.createStock(stockCount);
            }

            StockHistory stockHistory = stockHistoryService.createStockHistory(
                    SUBJECT_STOCK_ADD, stock.getStockId(), stockCount, LocalDateTime.now());
            stockHistoryService.add(stockHistory);

            return stockService.add(stock);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Stock add(long stockId, int stockCount) {

        try {
            // 在庫を取得。なければ新規追加する
            Stock stock = stockService.findStock(stockId);
            if (stock.isEmpty()) {
                stock = stockService.createStock(stockCount);
            } else {
                stock.addStockCount(stockCount);
            }

            StockHistory stockHistory = stockHistoryService.createStockHistory(
                    SUBJECT_STOCK_ADD, stock.getStockId(), stockCount, LocalDateTime.now());
            stockHistoryService.add(stockHistory);

            return stockService.add(stock);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
