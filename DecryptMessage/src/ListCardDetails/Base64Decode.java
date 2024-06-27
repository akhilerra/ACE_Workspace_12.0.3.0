package ListCardDetails;

import java.util.Base64;

public class Base64Decode {

	public static byte[] decoder(String token) {
		
		return Base64.getDecoder().decode(token);
	}

}
