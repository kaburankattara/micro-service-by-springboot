package com.sample.stock.domain.stockhistory;

import com.sample.stock.infra.table.t_stock_history.TStockHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StockHistoryService {

    private TStockHistoryRepository repository;

    @Autowired
    public StockHistoryService(TStockHistoryRepository repository) {
        this.repository = repository;
    }
    public StockHistory createStockHistory(String subject, long stockId, int stockCount, LocalDateTime addDateTime) {
        long stockHistoryId = repository.getStockHistoryId();
        return StockHistory.createInstance(stockHistoryId, subject, stockId, stockCount, addDateTime);
    }

    public StockHistory add(StockHistory stockHistory) {
        return StockHistory.createInstance(repository.save(stockHistory.toEntity()));
    }

}
