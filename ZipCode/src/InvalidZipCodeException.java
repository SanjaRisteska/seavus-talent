public class InvalidZipCodeException extends NumberFormatException {

	private static final long serialVersionUID = 1L;

	public InvalidZipCodeException(String msg) {
		super(msg);
	}

}