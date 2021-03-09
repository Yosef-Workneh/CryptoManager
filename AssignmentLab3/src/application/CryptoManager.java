package application;



public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
		for(int x = 0; x < plainText.length(); x++) {
		if(plainText.charAt(x)> LOWER_BOUND && plainText.charAt(x) < UPPER_BOUND ) {
			return true;
		}
		}
		return false;
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//throw new RuntimeException("method not implemented");
		String cipher ="";
		for( int x = 0; x < plainText.length(); x++) {
		char p = plainText.charAt(x);
		char a = (char)(p+key);
		while(a > UPPER_BOUND) {
			a -= RANGE;
			}
		cipher+= a;
		}
		return cipher;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		String cipher ="";
		int Bella = bellasoStr.length();
		for( int x = 0; x < plainText.length(); x++) {
		char plain = plainText.charAt(x);
		int a = ((int)plain +(int) bellasoStr.charAt(x % Bella));
		while(a > UPPER_BOUND) {
			a -= RANGE;
			}
		cipher+= (char)a;
		}
		return cipher;
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		String cipher ="";
		for(int x = 0; x < encryptedText.length(); x++) {
		char p = encryptedText.charAt(x);
		char a = (char)(p - key);
		while(a < LOWER_BOUND) {
			a += RANGE;
			}
		cipher+= a;
		}
		return cipher;
		
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		String cipher ="";
		int Bella = bellasoStr.length();
		for( int x = 0; x < encryptedText.length(); x++) {
		char plain = encryptedText.charAt(x);
		int a = ((int)plain - (int)bellasoStr.charAt(x % Bella));
		while(a < LOWER_BOUND) {
			a += RANGE;
			}
		cipher+= (char)a;
		}
		return cipher;
	}
}