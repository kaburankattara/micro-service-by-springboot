package com.sample.stock.app;

import org.springframework.stereotype.Component;

@Component("StockConst")
public class StockConst {

    public static final String URL_BEAN_ROOT = "/stock";
    public static final String URL_BEAN_VIEW = "/view";
    public static final String URL_BEAN_ADD = "/add";
    public static final String URL_ROOT = URL_BEAN_ROOT;
    public static final String URL_VIEW = URL_BEAN_ROOT + URL_BEAN_VIEW;
    public static final String URL_ADD = URL_BEAN_ROOT + URL_BEAN_ADD;

}
