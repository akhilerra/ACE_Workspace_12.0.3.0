package ListCardDetails;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;

public class MessageDecrypt {

    // RSA public key in Base64 encoded format
//    private static final String RSA_PUBLIC_KEY_BASE64 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArZF+bmLFudosXCarBbJelkdiay8ZBHp5jKilOIk93zwgTz9/TOOX78guncqq6s7CzB5TDX0GJbUe+AnJGcyf0YWAMUUgdsr/nH5TrKZmLOuQVzWhxcxp5YFUg+5FiEY9uHrC3ahH2eLA6q7QDPitlRfu9bsyXtgMo6ISJSWKWXVGAlC7oOGmFnOmfiqtHkiF1gugpxqFWnPs6yRQt0Irbn9zOBtJgx/g6bsL+VGP/y93kbZ8zusW1450DWRJC50LHgL9o7+EWyNFjXUWmZeUTayHJrFD99Mqw+Rhgptbr9DxvBMldRQicHUGXSIu+uqWl4jNleTsbXM2LCCEkhXt5QIDAQAB";

    public static void main(String[] args) {
//        String originalMessage = "Hello, this is a secret message!";

        try {
            // Encrypt
//            String encryptedMessage = encrypt(originalMessage, RSA_PUBLIC_KEY_BASE64);
//            System.out.println("Encrypted: " + encryptedMessage);

            // Decrypt
//            String decryptedMessage = decrypt(encryptedMessage);
//            System.out.println("Decrypted: " + decryptedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // RSA encryption function
    public static String encrypt(String plaintext, String rsaPublicKeyBase64) {
    	try {
        byte[] publicKeyBytes = Base64.getDecoder().decode(rsaPublicKeyBase64);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] encryptedData = cipher.doFinal(plaintext.getBytes());

        return Base64.getEncoder().encodeToString(encryptedData);
    }catch(Exception e) {
    	return e.toString();
    	}
    }
    
   
    // RSA decryption function (not implemented for security reasons)
    public static String decrypt(String ciphertext) throws Exception {
        throw new UnsupportedOperationException("RSA decryption not implemented in this example");
    }
}
