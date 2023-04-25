
/*
@Author: Rajan Kumar Sharma
Date: 24/04/2023
*/

package com.semanticsquare.coding.exercise8;

public class SilverPlan extends HealthInsurancePlan {

    public SilverPlan() {
        super(0.7);// coverage = 70%
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary * 0.06;
    }

}
