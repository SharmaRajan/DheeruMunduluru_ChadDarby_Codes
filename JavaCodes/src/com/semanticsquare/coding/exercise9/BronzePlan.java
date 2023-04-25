
/*
@Author: Rajan Kumar Sharma
Date: 24/04/2023
*/

package com.semanticsquare.coding.exercise9;


public class BronzePlan extends HealthInsurancePlan {

    public BronzePlan() {
        super(0.6);// coverage = 60%
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.05 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

}
