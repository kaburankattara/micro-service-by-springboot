package com.sample.stock.infra.table.t_stock_history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// JpaRepositoryクラスを継承することによって、テーブルへの
// select, insert, delete, updateを行うメソッドを自動で生成してくれる
@Repository
public interface TStockHistoryRepository extends JpaRepository<TStockHistoryEntity, Long> {

    @Query(value = "select stock_history_id_sequence.nextval from dual", nativeQuery = true)
    long getStockHistoryId();

}