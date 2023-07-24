package com.sample.stock.infra.table.t_stock;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

//テーブル名を「@Table」アノテーションで指定
//「@Data」アノテーションを付与すると、このクラス内の全フィールドに対する
//Getterメソッド・Setterメソッドにアクセスができる
@Entity
@Table(name="t_stock")
@Data
public class TStockEntity {

    //主キー項目に「@Id」を付与し、その値を自動生成するにはアノテーション
    //「@GeneratedValue(strategy = GenerationType.AUTO)」を付与する
    @Id
    private Long stockId;

    @Column(name="stock_count_of_init")
    private Integer stockCountOfInit;

    //カラム名を「@Column」アノテーションで指定
    @Column(name="stock_count_of_now")
    private Integer stockCountOfNow;

}
