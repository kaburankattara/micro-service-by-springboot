package com.sample.stock.domain.stock;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Stock {

    public static Stock createInstance(int initCount, int nowCount) {
        return new Stock(initCount, nowCount);
    }

    public static Stock createInstanceForAdd(int initCount) {
        return new Stock(initCount, initCount);
    }

    private int initCount;

    private int nowCount;

    public Stock(int initCount, int nowCount) {
        this.initCount = initCount;
        this.nowCount = nowCount;
    }

}
