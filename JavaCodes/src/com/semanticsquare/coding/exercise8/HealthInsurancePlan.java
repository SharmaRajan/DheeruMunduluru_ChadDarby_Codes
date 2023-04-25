
/*
@Author: Rajan Kumar Sharma
Date: 24/04/2023
*/

package com.semanticsquare.coding.exercise8;

public abstract class HealthInsurancePlan {

    private double coverage;
    private InsuranceBrand offeredBy;

    public HealthInsurancePlan(double coverage) {
        setCoverage(coverage);
    }

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    public InsuranceBrand getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }

    /*
     * It is a method used to calculate monthly premium to be paid by staff for a
     * particular insurance plan
     */
    public abstract double computeMonthlyPremium(double salary);


}
