package hospitalmanagementsystem;

public class main {

	public static void main(String[] args) {

		User staff = new User();
		InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
		HealthInsurancePlan healthInsurancePlan = new BronzePlan();

		healthInsurancePlan.setOfferedBy(insuranceBrand);
		staff.setInsurancePlan(healthInsurancePlan);
		double monthlyPremium = healthInsurancePlan.computeMonthlyPremium(8000, 50, true);
		System.out.println("Monthly premium = "+ monthlyPremium);
	}

}
