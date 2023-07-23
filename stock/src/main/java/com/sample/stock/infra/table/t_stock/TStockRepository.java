package com.sample.stock.infra.table.t_stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepositoryクラスを継承することによって、テーブルへの
// select, insert, delete, updateを行うメソッドを自動で生成してくれる
@Repository
public interface TStockRepository extends JpaRepository<TStockEntity, Long> {
}