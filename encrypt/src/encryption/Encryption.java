package encryption;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class Encryption {

	public static void main(String[] args) {
		
		String name = "Akhil";
		
		//Keys key = getKeys();
		
		byte[] encryptedData = encryptData(name.getBytes(), key.getPublicKey());
		
		String encryptedDataString = new String(encryptedData);
		System.out.println("EncryptedData : " + encryptedDataString);
		
		System.out.println();
		
		byte[] decryptedData = decryptedData(encryptedData, key.getPrivateKey());
		String decryptedDataString = new String(decryptedData);
		System.out.println("DecryptedData : " + decryptedDataString);
	}
	
	/*private static void storeKeys() {
		try {
			byte[] publicKeyEncoded = key.getPublicKey().getEncoded();
			byte[] privateKeyEncoded = key.getPrivateKey().getEncoded();
			
			FileOutputStream fosPublic = new FileOutputStream("publicKey.der");
			FileOutputStream fosPrivate = new FileOutputStream("privateKey.der");
			
			fosPublic.write(publicKeyEncoded);
			fosPrivate.write(privateKeyEncoded);
			
			fosPrivate.close();
			fosPublic.close();
			
		} catch(Exception e) {
			
		}
	}*/
	
	/*static Keys getKeys() {
		try {
			FileInputStream fisPublic = new FileInputStream("C:/Users/Sreenivas Bandaru/IBM/ACET12/workspace/JAVA_ENCRYPT_PAYLOAD/publicKey.der");
			FileInputStream fisPrivate = new FileInputStream("C:/Users/Sreenivas Bandaru/IBM/ACET12/workspace/JAVA_ENCRYPT_PAYLOAD/privateKey.der");
			
			byte[] publicKeyEncoded = new byte[fisPublic.available()];
			fisPublic.read(publicKeyEncoded);
			
			byte[] privateKeyEncoded = new byte[fisPrivate.available()];
			fisPrivate.read(privateKeyEncoded);
			
			fisPublic.close();
			fisPrivate.close();
			
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			
			PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyEncoded));
			PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyEncoded));
			
			return new Keys(publicKey,privateKey);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}*/
	static byte[] encryptData(byte[] input, PublicKey publicKey) {
		try {
			Cipher cipher  = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			return cipher.doFinal(input);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	static byte[] decryptedData(byte[] input, PrivateKey privateKey) {
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			return cipher.doFinal(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
