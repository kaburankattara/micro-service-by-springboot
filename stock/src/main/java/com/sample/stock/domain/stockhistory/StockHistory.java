package com.sample.stock.domain.stockhistory;

import com.sample.stock.infra.table.t_stock_history.TStockHistoryEntity;

import java.time.LocalDateTime;

public class StockHistory extends TStockHistoryEntity {

    public static StockHistory createInstance(TStockHistoryEntity entity) {
        return createInstance(entity.getStockHistoryId(), entity.getSubject(), entity.getStockId(), entity.getStockCount(), entity.getAddDateTime());
    }

    public static final String SUBJECT_STOCK_ADD = "在庫追加";

    public static StockHistory createInstance(long stockHistoryId, String subject, long stockId, int stockCount, LocalDateTime addDateTime) {
        return new StockHistory(stockHistoryId, subject, stockId, stockCount, addDateTime);
    }

    public StockHistory(long stockHistoryId, String subject, long stockId, int stockCount, LocalDateTime addDateTime) {
        super(stockHistoryId, subject, stockId, stockCount, addDateTime);
    }

    public TStockHistoryEntity toEntity() {
        return new TStockHistoryEntity(getStockHistoryId(), getSubject(), getStockId(), getStockCount(), getAddDateTime());
    }

}
