package com.semanticsquare.coding.exercise9;


// IS-A relation
public class BlueCrossBlueShield implements InsuranceBrand{

    private long id;
    private String name;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {
        double premium = 0.0;

        //use instanceof operator
        if(insurancePlan instanceof PlatinumPlan) {
            if(age > 55 ) {
                premium += 200.0;
                if(smoking){
                    premium += 100.0;
                }
            } else if (age > 0 && age < 55) {// age < 55 && User smokes then add premium for smoking only
                if(smoking) {
                    premium += 100.0;
                }
            }
        }else if(insurancePlan instanceof GoldPlan) {
            if(age > 55) {
                premium += 150.0;
                if(smoking){
                    premium += 90.0;
                }
            } else if (age > 0 && age < 55) {
                if(smoking) {
                        premium += 90.0;
                }
            }
        }else if(insurancePlan instanceof SilverPlan) {
            if(age > 55) {
                premium += 100.0;
                if(smoking){
                    premium += 80.0;
                }
            } else if (age > 0 && age < 55) {
                if(smoking) {
                    premium += 80.0;
                }
            }
        }else if(insurancePlan instanceof BronzePlan) {
            if(age > 55) {
                premium += 50.0;
                if(smoking){
                    premium += 70.0;
                }
            }else if (age > 0 && age < 55){
                if(smoking) {
                    premium += 70.0;
                }
            }
        }
        return premium;
    }

}

