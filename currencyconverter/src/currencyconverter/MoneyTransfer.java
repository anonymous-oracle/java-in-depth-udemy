package currencyconverter;

public class MoneyTransfer {
CurrencyConverter currencyConverter = new CurrencyConverter();

double computeTransferAmount(int countryIndex, double amount) {
    return this.currencyConverter.computeTransferAmount(countryIndex, amount);
}
double computeTransferFee(int countryIndex, double amount) {
	return 0.02 * this.computeTransferAmount(countryIndex, amount);
}


public static void main(String[] args) {
	// TODO Auto-generated method stub
	MoneyTransfer transferService = new MoneyTransfer();
	
	double transferAmount = transferService.computeTransferAmount(0, 1000);
    double transferFee = transferService.computeTransferFee(0, 1000);
    System.out.println("Transfer Amount: " + transferAmount);
    System.out.println("Transfer Fee: " + transferFee);
}

}
