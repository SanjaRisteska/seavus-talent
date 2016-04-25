
public class Calculation {
	private String operation;
	private int firstNumber;
	private int secondNumber;
	
	
	public Calculation(String operation, int firstNumber, int secondNumber) {
		super();
		this.operation = operation;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	public String getOperation() {
		return operation;
	}

	public int getFirstNumber() {
		return firstNumber;
	}

	public int getSecondNumber() {
		return secondNumber;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}

	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}

	public int calculate(){
		int result=0;
		if(operation.equals("-")){
        	result=firstNumber-secondNumber;
        }
        else if(operation.equals("+")){
        	result=firstNumber+secondNumber;
        }
        else if(operation.equals("*")){
        	result=firstNumber*secondNumber;
        }
        else if(operation.equals("/")){
        	result=firstNumber/secondNumber;
        }
		
		return result;
	}

}
