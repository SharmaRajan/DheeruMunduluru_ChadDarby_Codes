package com.semanticsquare.coding.exercise9;

public class UserTest {

    public static void main(String[] args) {
        User staff = new User();
        InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlan = new PlatinumPlan();

        insurancePlan.setOfferedBy(insuranceBrand);
        staff.setInsurancePlan(insurancePlan);
        insurancePlan.computeMonthlyPremium(5000, 56, true);
    }
}
