package hospitalmanagementsystem;

public class BlueCrossBlueShield implements InsuranceBrand {
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
		double insurancePlanPremium = 0;
		if (insurancePlan instanceof PlatinumPlan) {
			if (smoking == true) {
				insurancePlanPremium += 100;
			}
			if (age > 55) {
				insurancePlanPremium += 200;
			}
		} else if (insurancePlan instanceof GoldPlan) {
			if (smoking == true) {
				insurancePlanPremium += 90;
			}
			if (age > 55) {
				insurancePlanPremium += 150;
			}
		} else if (insurancePlan instanceof SilverPlan) {
			if (smoking == true) {
				insurancePlanPremium += 80;
			}
			if (age > 55) {
				insurancePlanPremium += 100;
			}
		} else if (insurancePlan instanceof BronzePlan) {
			if (smoking == true) {
				insurancePlanPremium += 70;
			}
			if (age > 55) {
				insurancePlanPremium += 50;
			}
		}
		return insurancePlanPremium;
	}

}
