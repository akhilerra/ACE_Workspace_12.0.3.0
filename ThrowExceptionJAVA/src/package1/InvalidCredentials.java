package package1;

@SuppressWarnings("serial")
public class InvalidCredentials extends Exception{
	public InvalidCredentials(String str) {
		super(str);
	}
}
