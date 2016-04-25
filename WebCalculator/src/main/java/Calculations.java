import java.util.List;

public class Calculations {
	List<Calculation> calculations;
	
	public void addCalculation(Calculation calculation){
		calculations.add(calculation);
	}
	
	public List<Calculation> getCalculations(){
		return calculations;
	}
}
