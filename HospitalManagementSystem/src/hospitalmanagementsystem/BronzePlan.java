package hospitalmanagementsystem;

public class BronzePlan extends HealthInsurancePlan {

	public BronzePlan() {
		this.setCoverage(0.6);

	}

	@Override
	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		// TODO Auto-generated method stub
		return (salary * 0.05) + getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}
}
