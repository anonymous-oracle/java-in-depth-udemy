package hospitalmanagementsystem;

public class Billing {

	public static double[] computePaymentAmount(Patient patient, double amount) {

		HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

		if (patientInsurancePlan == null) {
			return new double[] { 0, amount - 20};
		}

		else if (patientInsurancePlan instanceof PlatinumPlan) {
			double insuranceCoverage = ((PlatinumPlan) patientInsurancePlan).getCoverage();
			int discount = 50;
			double insuranceAmount = insuranceCoverage * amount;
			double patientAmount = amount - insuranceAmount - discount;
			return new double[] { insuranceAmount, patientAmount };

		} else if (patientInsurancePlan instanceof GoldPlan) {
			double insuranceCoverage = ((GoldPlan) patientInsurancePlan).getCoverage();
			int discount = 40;
			double insuranceAmount = insuranceCoverage * amount;
			double patientAmount = amount - insuranceAmount - discount;
			return new double[] { insuranceAmount, patientAmount };

		} else if (patientInsurancePlan instanceof SilverPlan) {
			double insuranceCoverage = ((SilverPlan) patientInsurancePlan).getCoverage();
			int discount = 30;
			double insuranceAmount = insuranceCoverage * amount;
			double patientAmount = amount - insuranceAmount - discount;
			return new double[] { insuranceAmount, patientAmount };

		} else if (patientInsurancePlan instanceof BronzePlan) {
			double insuranceCoverage = ((BronzePlan) patientInsurancePlan).getCoverage();
			int discount = 25;
			double insuranceAmount = insuranceCoverage * amount;
			double patientAmount = amount - insuranceAmount - discount;
			return new double[] { insuranceAmount, patientAmount };

		}

		return new double[] { 0.0, amount };

	}

	public static void main(String[] args) {

		HealthInsurancePlan insurancePlan = new PlatinumPlan();
		Patient patient = new Patient();
		patient.setInsurancePlan(insurancePlan);

		double[] payments = Billing.computePaymentAmount(patient, 1000.0);
		System.out.println(payments.toString());
	}

}