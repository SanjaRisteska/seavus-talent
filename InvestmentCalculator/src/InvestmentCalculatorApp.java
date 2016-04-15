
public class InvestmentCalculatorApp {

	public static float calculate(float investment) {
		float firstYear = investment + ((investment * 40) / 100);
		float secondYear = firstYear - 1500;
		float thirdYear = secondYear + ((secondYear * 12) / 100);
		return thirdYear;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		float investment = 14000;
		investment = calculate(investment);
		System.out.println(investment);

	}

}
