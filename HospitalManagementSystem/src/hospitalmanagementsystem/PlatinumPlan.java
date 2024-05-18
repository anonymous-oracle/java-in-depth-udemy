package hospitalmanagementsystem;

public class PlatinumPlan extends HealthInsurancePlan {

	public PlatinumPlan() {
		this.setCoverage(0.9);
	}

	@Override
	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		// TODO Auto-generated method stub
		return (salary * 0.08) + getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}

	
}
