package package1;

public class Class {

	public static void main(String[] args) {
		try {
		test("Akhil","sarsu10");
		}catch (InvalidCredError e) {
			e.printStackTrace();
		}
		
	}
	static void test(String uname, String pw) throws InvalidCredError {
		String res = "";
		try {
			if (uname == "Akhil" && pw == "sarasu10") {
				System.out.println("valid user");
			}else {
				throw new InvalidCredError("Invalid user");
				
			}
		}catch (InvalidCredError e) {
			throw e;
		}	
	}
}
class InvalidCredError extends Exception {
	public InvalidCredError(String s) {
		super(s);
	}
}
