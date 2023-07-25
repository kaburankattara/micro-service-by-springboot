package com.sample.stock.domain.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sample.stock.infra.json.Json;
import com.sample.stock.infra.messaging.KafkaConfig;
import com.sample.stock.infra.table.t_stock.TStockEntity;
import com.sample.stock.infra.table.t_stock.TStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Stocks findAllStock() {
        List<TStockEntity> entityList = repository.findAll();
        return  Stocks.createInstanceByEntityList(entityList);
    }

    public Stock findStock(long stockId) {
        Optional<TStockEntity> op = repository.findById(stockId);
        if (op.isPresent()) {
            return Stock.createInstance(op.get());
        }
        return  Stock.createEmptyInstance();
    }

    public Stock add(Stock stock) {
        try {
            Stock addedStock = Stock.createInstance(repository.save(stock.toEntity()));

            KafkaConfig kafka = new KafkaConfig();
            KafkaTemplate<Integer, String> template = kafka.kafkaTemplate();
            template.send("addStock", Json.toJson(stock.toEntity()));

            return addedStock;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
