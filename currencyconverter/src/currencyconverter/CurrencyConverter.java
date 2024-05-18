package currencyconverter;

public class CurrencyConverter {
	int rupee = 63;
	int usdollar = 1;
	int dirham = 3; // uae
	int _yen = 107;
	int $australian = 2;
	int real = 3; // brazilian
	int chilean_peso = 595;
	int mexican_peso = 18;
	
	double[] currencyArray = new double[] {rupee, usdollar, dirham, _yen, $australian, real, chilean_peso, mexican_peso };
	
	void printCurrencies() {
//		System.out.println("rupee: "+ currencyArray[0]);
//		System.out.println("usdollar: "+ currencyArray[1]);
		System.out.println("dirham: "+ currencyArray[2]);
		System.out.println("_yen: "+ currencyArray[3]);
		System.out.println("$australian: "+ currencyArray[4]);
		System.out.println("real: "+ currencyArray[5]);
		System.out.println("chilean_peso: "+ currencyArray[6]);
		System.out.println("mexican_peso: "+ currencyArray[7]);
	}
	
	 void setExchangeRates(double[] rates) {
         this.currencyArray = rates;
    }
    void updateExchangeRate(int countryIndex, double newVal) {
         this.currencyArray[countryIndex] = newVal;
    }

    double getExchangeRate(int countryIndex) {
        return this.currencyArray[countryIndex];
    }
    double computeTransferAmount(int countryIndex, double amount) {
        return amount * getExchangeRate(countryIndex);
    }
    
	
}
