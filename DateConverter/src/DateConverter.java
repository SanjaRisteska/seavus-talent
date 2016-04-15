
public class DateConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String birthday = "12/04/2007";
		String[] bday = birthday.split("/");
		String day = bday[0];
		String month = bday[1];
		String year = bday[2];

		System.out.println("Day: " + day + ", month: " + month + ", year: " + year);

	}

}
