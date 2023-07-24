package com.sample.stock.infra.table.t_stock_history;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

//テーブル名を「@Table」アノテーションで指定
//「@Data」アノテーションを付与すると、このクラス内の全フィールドに対する
//Getterメソッド・Setterメソッドにアクセスができる
@Entity
@Table(name="t_stock_history")
@Data
public class TStockHistoryEntity {

    public TStockHistoryEntity() {
    }

    public TStockHistoryEntity(long stockHistoryId, String subject, long stockId, int stockCount, LocalDateTime addDateTime) {
        this.stockHistoryId = stockHistoryId;
        this.subject = subject;
        this.stockId = stockId;
        this.stockCount = stockCount;
        this.addDateTime = addDateTime;
    }

    //主キー項目に「@Id」を付与し、その値を自動生成するにはアノテーション
    //「@GeneratedValue(strategy = GenerationType.AUTO)」を付与する
    @Id
    @Column(name="stock_history_id")
    private long stockHistoryId;

    @Column(name="subject")
    private String subject;

    //カラム名を「@Column」アノテーションで指定
    @Column(name="stock_id")
    private long stockId;

    @Column(name="stock_count")
    private int stockCount;

    @Column(name="add_time")
    private LocalDateTime addDateTime;

}
