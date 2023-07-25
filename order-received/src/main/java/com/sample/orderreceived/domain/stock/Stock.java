package com.sample.orderreceived.domain.stock;

import com.sample.orderreceived.infra.table.t_stock.TStockEntity;

public class Stock extends TStockEntity {

    public static Stock createInstanceForAdd(long stockId, int stockCountOfInit) {
        return createInstance(stockId, stockCountOfInit, stockCountOfInit);
    }

    public static Stock createInstance(TStockEntity entity) {
        return new Stock(entity.getStockId(), entity.getStockCountOfInit(), entity.getStockCountOfNow());
    }

    public static Stock createEmptyInstance() {
        return new Stock();
    }

    public static Stock createInstance(long stockId, int stockCountOfInit, int stockCountOfNow) {
        return new Stock(stockId, stockCountOfInit, stockCountOfNow);
    }

    public Stock(long stockId, int stockCountOfInit, int stockCountOfNow) {
        this.setStockId(stockId);
        this.setStockCountOfInit(stockCountOfInit);
        this.setStockCountOfNow(stockCountOfNow);
    }

    public Stock() {
    }

    public TStockEntity toEntity() {
        TStockEntity entity = new TStockEntity();
        entity.setStockId(getStockId());
        entity.setStockCountOfInit(getStockCountOfInit());
        entity.setStockCountOfNow(getStockCountOfNow());
        return entity;
    }

    public boolean isEmpty() {
        return getStockId() == null;
    }

    public void addStockCount(int stockCount) {
        setStockCountOfNow(getStockCountOfNow() + stockCount);
    }

}
