package com.xuzw.demo.service.impl;

import com.xuzw.demo.service.CalculatorStrategy;

public class CalculatorStrategyContext {

    private CalculatorStrategy calculatorStrategy;

    public CalculatorStrategy getCalculatorStrategy() {
        return calculatorStrategy;
    }

    public void setCalculatorStrategy(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }

    public void calculator(){
        if(null == calculatorStrategy){
            throw new RuntimeException("计算策略未设置");
        }
        calculatorStrategy.exec();
    }
}
