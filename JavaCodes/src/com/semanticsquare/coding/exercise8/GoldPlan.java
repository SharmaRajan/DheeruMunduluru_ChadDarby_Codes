
/*
@Author: Rajan Kumar Sharma
Date: 24/04/2023
*/

package com.semanticsquare.coding.exercise8;

public class GoldPlan extends HealthInsurancePlan {

    public GoldPlan() {
        super(0.8);// coverage = 80%
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary * 0.07;
    }
}
