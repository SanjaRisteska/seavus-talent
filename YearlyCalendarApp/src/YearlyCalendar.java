
public class YearlyCalendar {

	static int countDays(int month, int year) {
		int count = -1;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			count = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			count = 30;
			break;
		case 2:
			if (year % 4 == 0) {
				count = 29;
			} else {
				count = 28;
			}
			if ((year % 100 == 0) & (year % 400 != 0)) {
				count = 28;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int year = 2009;
		int days;
		int feb = countDays(2, year);
		if (feb == 28) {
			days = 365;
		} else {
			days = 366;
		}

		String[] dates = new String[days];
		int counter = 0;
		for (int month = 1; month <= 12; month++) {

			for (int d = 1; d <= countDays(month, year); d++) {

				dates[counter] = d + "-" + month + "-" + year;
				counter++;
			}
		}

		for (int i = 0; i < days; i++) {
			System.out.println(dates[i]);

		}

	}

}
