package package1;

public class Main {
	public static void main(String[] args) {
		try {
		String uname = "akhilerra";
		String pword = "sarasu10";
		ValidateCredentails(uname,pword);
		} catch(InvalidCredentials e) {
			e.printStackTrace();
		}
	}

	private static void ValidateCredentails(String uname, String pword) throws InvalidCredentials {
		try {
		if(uname.equals("akhilerra")) {
			if(pword.equals("sarasu10")) {
				System.out.println("Validation has been successfull..!!");
			} else {
				throw new InvalidCredentials("Please enter valid Password");
			}
		} else {
			throw new InvalidCredentials("Please enter valid Username");
		}
		} catch(InvalidCredentials e) {
			throw e;
		}
		
	}



}
