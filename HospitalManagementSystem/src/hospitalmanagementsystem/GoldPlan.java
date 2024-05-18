package hospitalmanagementsystem;

public class GoldPlan extends HealthInsurancePlan{

	public GoldPlan() {
		this.setCoverage(0.8);
	}

	@Override
	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		// TODO Auto-generated method stub
		return (salary * 0.07) + getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}
}
