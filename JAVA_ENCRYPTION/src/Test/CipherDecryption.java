package Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class CipherDecryption {
	public static void main(String[] args) {
		generatekeys();
	}
	public static void generatekeys() {
		try {
			KeyPairGenerator keypairgen = KeyPairGenerator.getInstance("RSA");
			keypairgen.initialize(2048);
			KeyPair keypair = keypairgen.generateKeyPair();
			PublicKey publickey = keypair.getPublic();
			PrivateKey privatekey = keypair.getPrivate();
			
			savePublicKeyToFile(publickey,"publickey.der");
			savePrivateKeyToFile(privatekey,"privatekey.der");
		}catch  (Exception e){
			e.printStackTrace();
		}
	}

	private static void savePublicKeyToFile(PublicKey publickey, String filename) {
		// TODO Auto-generated method stub
		try {
			byte[] publicKeyEncoded = publickey.getEncoded();
			FileOutputStream fos = new FileOutputStream(filename);
			fos.write(publicKeyEncoded);
			fos.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	private static void savePrivateKeyToFile(PrivateKey privatekey, String filename) {
		// TODO Auto-generated method stub
		try {
			byte[] privateKeyEncoded = privatekey.getEncoded();
			FileOutputStream fos = new FileOutputStream(filename);
			fos.write(privateKeyEncoded);
			fos.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void encryptData(byte[] input) {
		try {
			PublicKey publickey = LoadPublickeyFromFile("C:/Users/Sreenivas BandaruIBM/ACET12/workspace/JAVA_ENCRYPTION/publickey.der");
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE,publickey);
			byte[] encryptData = cipher.doFinal(input);
			
			FileOutputStream fos = new FileOutputStream("C:/Users/Sreenivas Bandaru/IBM/ACET12/workspace/JAVA_ENCRYPTION/encryptdata.dat");
			fos.write(encryptData);
			fos.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static PublicKey LoadPublickeyFromFile(String filePath)throws Exception {
		FileInputStream fis = new FileInputStream(filePath);
		byte[] publickeyencode = new byte[fis.available()];
		fis.read(publickeyencode);
		fis.close();
		KeyFactory keyfactory = KeyFactory.getInstance("RSA");
		return keyfactory.generatePublic(new X509EncodedKeySpec(publickeyencode));
		
		
	}
	
	public static byte[] decryptData() {
		try {
			Privatekey privatekey = LoadPrivateKeyFromFile("C:/Users/Sreenivas Bandaru/IBM/ACET12/workspace/JAVA_ENCRYPTION/privatekey.der");
			FileInputStream fis = new FileInputStream("C:/Users/Sreenivas Bandaru/IBM/ACET12/workspace/JAVA_ENCRYPTION/enncryptdata.dat.txt");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
