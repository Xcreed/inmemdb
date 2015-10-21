package inmemdb.controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Encryption {
	
	public Encryption() {
		
	}
	
	/**
	 * Encrypts given string
	 * @param dataToEncrypt
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String encrypt(String dataToEncrypt) throws UnsupportedEncodingException {
		String encryptedString = Base64.getEncoder().encodeToString(dataToEncrypt.getBytes("utf-8"));
		System.out.println(encryptedString);
		return encryptedString;
		
	}
	
	/**
	 * Decrypts given string
	 * @param dataToDecrypt
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String decrypt(String dataToDecrypt) throws UnsupportedEncodingException {
		
		byte[] decryptedString = Base64.getDecoder().decode(dataToDecrypt);
		String finalString = new String(decryptedString, "utf-8");
		System.out.println(finalString);
		return finalString;
	}
}
