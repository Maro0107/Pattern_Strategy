package com.patterns.strategy;

import com.strategy.predictor.AggressivePredictor;

public class IndividualYoungCustomer extends Customer{
    public IndividualYoungCustomer(String name) {
        super(name);
        this.buyPredictor = new AggressivePredictor();
    }
}
