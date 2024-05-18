package hospitalmanagementsystem;

public class SilverPlan extends HealthInsurancePlan {

	public SilverPlan() {
		this.setCoverage(0.7);
	}

	@Override
	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		// TODO Auto-generated method stub
		return (salary * 0.06) + getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}
}
