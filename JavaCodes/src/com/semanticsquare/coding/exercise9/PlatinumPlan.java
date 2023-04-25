
/*
@Author: Rajan Kumar Sharma
Date: 24/04/2023
*/

package com.semanticsquare.coding.exercise9;

public class PlatinumPlan extends HealthInsurancePlan {

    public PlatinumPlan() {
        super(0.9);// coverage = 90%
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.08 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

}
