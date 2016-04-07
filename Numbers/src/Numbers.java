
public class Numbers {
	
	static int convertNumber(String numberToConvert){
		int convertedNumber=-1;
		switch(numberToConvert){
		case "zero":
			convertedNumber=0;
			break;
		case "one":
			convertedNumber=1;
			break;
		case "two":
			convertedNumber=2;
			break;
		case "three":
			convertedNumber=3;
			break;
		case "four":
			convertedNumber=4;
			break;
		case "five":
			convertedNumber=5;
			break;
		case "six":
			convertedNumber=6;
			break;
		case "seven":
			convertedNumber=7;
			break;
		case "eight":
			convertedNumber=8;
			break;
		case "nine":
			convertedNumber=9;
			break;
		
		}
		return convertedNumber;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
for(int i=0;i<args.length;i++){
	int numberToPrint=convertNumber(args[i]);
	System.out.print(numberToPrint!=-1?numberToPrint:"");
}
	}

}
