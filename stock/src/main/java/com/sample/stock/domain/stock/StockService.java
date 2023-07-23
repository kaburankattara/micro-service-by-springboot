package com.sample.stock.domain.stock;

import com.sample.stock.infra.table.t_stock.TStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private TStockRepository repository;

    @Autowired
    public StockService(TStockRepository repository) {
        this.repository = repository;
    }

    public Stock createStock(int stockCountOfInit) {
        long stockId = repository.getStockId();
        return Stock.createInstanceForAdd(stockId, stockCountOfInit);
    }

    public Stock add(Stock stock) {
        return Stock.createInstance(repository.save(stock.toEntity()));
    }

}
