
public class ZipCode {

	private int zipCode;

	private boolean isNumber(String zipCode) {
		@SuppressWarnings("unused")
		int zCode;
		try {
			zCode = Integer.parseInt(zipCode);
		}

		catch (NumberFormatException ex) {
			throw new InvalidZipCodeException("Zip code have to be a number.");

		}

		return true;

	}

	private boolean isRightSize(String zipCode) {

		if (zipCode.length() == 5 || zipCode.length() == 9) {
			return true;
		}

		else {
			throw new InvalidZipCodeException("The number isn't the right length.");
		}

	}

	public void setZipCode(String zipCode) throws InvalidZipCodeException {

		if (isNumber(zipCode) && isRightSize(zipCode)) {

			int zCode = Integer.parseInt(zipCode);

			this.zipCode = zCode;

		}

	}

	public int getZipCode() {
		return zipCode;
	}

}
