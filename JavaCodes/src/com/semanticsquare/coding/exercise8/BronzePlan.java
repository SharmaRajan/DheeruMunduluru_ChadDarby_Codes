
/*
@Author: Rajan Kumar Sharma
Date: 24/04/2023
*/

package com.semanticsquare.coding.exercise8;


public class BronzePlan extends HealthInsurancePlan {

    public BronzePlan() {
        super(0.6);// coverage = 60%
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary * 0.05;
    }

}
