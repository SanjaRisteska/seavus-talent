
public class ZipCodeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ZipCode z = new ZipCode();
		try {
			z.setZipCode("44");
			System.out.println(z.getZipCode());
		} catch (InvalidZipCodeException ex) {
			System.out.println(ex.getMessage());

		}

	}

}
