package com.sample.orderreceived.domain.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sample.orderreceived.infra.json.Json;
import com.sample.orderreceived.infra.table.t_stock.TStockEntity;
import com.sample.orderreceived.infra.table.t_stock.TStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
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

    @KafkaListener(id = "kafka-0", topics = "addStock")
    public void consumer(String stockByJson) {
        try {
            Stock stock = Stock.createInstance(Json.toObject(stockByJson, TStockEntity.class));
            System.out.println("kafkaからのメッセージ：" + stockByJson);
            repository.save(stock.toEntity());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
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
        return Stock.createInstance(repository.save(stock.toEntity()));
    }

}
