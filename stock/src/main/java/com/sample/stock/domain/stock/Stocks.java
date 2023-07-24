package com.sample.stock.domain.stock;

import com.sample.stock.infra.table.t_stock.TStockEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Stocks {

    public static Stocks createInstanceByEntityList(List<TStockEntity> entityList) {
        return new Stocks(toStockList(entityList));
    }

    public static Stocks createInstance(List<Stock> stockList) {
        return new Stocks(stockList);
    }

    public static List<Stock> toStockList(List<TStockEntity> entityList) {
        if (entityList == null) {
            return new ArrayList<>();
        }

        List<Stock> stockList = new ArrayList<>();
        for (TStockEntity entity : entityList) {
            stockList.add(Stock.createInstance(entity));
        }
        return stockList;
    }

    private List<Stock> stockList = new ArrayList<>();

    public Stocks(List<Stock> stockList) {
        this.stockList = stockList;
    }

    public boolean isEmpty() {
        return this.stockList == null || this.stockList.size() == 0;
    }

    public Stock getFirst() {

        if (isEmpty()) {
            return Stock.createEmptyInstance();
        }

        return stockList.get(0);
    }

}
