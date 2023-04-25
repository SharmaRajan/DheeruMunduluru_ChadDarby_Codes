
/*
@Author: Rajan Kumar Sharma
Date: 24/04/2023
*/

package com.semanticsquare.coding.exercise7;

public class Billing {

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
        double paymentByCompany = 0.0, paymentByPatient = 0.0;

        // your logic
        // check object instance and write logic accordingly

        // if platinum plan
        if (patientInsurancePlan instanceof PlatinumPlan) {
            paymentByCompany = patientInsurancePlan.getCoverage() * amount;
            paymentByPatient = amount - paymentByCompany;
            paymentByPatient = paymentByPatient - 50;
        }
        // if gold plan
        else if (patientInsurancePlan instanceof GoldPlan) {
            paymentByCompany = patientInsurancePlan.getCoverage() * amount;
            paymentByPatient = amount - paymentByCompany;
            paymentByPatient = paymentByPatient - 40;
        }
        // if silver plan
        else if (patientInsurancePlan instanceof SilverPlan) {
            paymentByCompany = patientInsurancePlan.getCoverage() * amount;
            paymentByPatient = amount - paymentByCompany;
            paymentByPatient = paymentByPatient - 30;
        }
        // if bronze plan
        else if (patientInsurancePlan instanceof BronzePlan) {
            paymentByCompany = patientInsurancePlan.getCoverage() * amount;
            paymentByPatient = amount - paymentByCompany;
            paymentByPatient = paymentByPatient - 25;
        }
        // if null - no insurance plan
        else {
            paymentByCompany = 0.0;
            paymentByPatient = amount - 20;
        }

        payments[0] = paymentByCompany;
        payments[1] = paymentByPatient;

        return payments;
    }

    // main method to check patient bill

    public static void main(String args[]) {
        // HealthInsurancePlan insurancePlan = new PlatinumPlan();
        HealthInsurancePlan insurancePlan = new GoldPlan();
        // HealthInsurancePlan insurancePlan = null;
        Patient patient = new Patient();
        patient.setInsurancePlan(insurancePlan);
        double[] payment = computePaymentAmount(patient, 1000.0);
        System.out.println("pay by company :" + payment[0]);
        System.out.println("pay by patient :" + payment[1]);
    }
}
