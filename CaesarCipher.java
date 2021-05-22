package JavaPrograms;
import java.util.Scanner;
 
public class CaesarCipher
{
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
 
    public static String encrypt(String plainText, int Key)
    {
        plainText = plainText.toLowerCase();
        String cipherText ="";
        for (int i = 0; i < plainText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
            int keyVal = (Key + charPosition) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    }
 
    public static String decrypt(String cipherText, int Key)
    {
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - Key) % 26;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }
 
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String for Encryption: ");
        String message = new String();
        message = sc.next();
        
		System.out.print("Enter the number: ");
		int Key = sc.nextInt();
        System.out.println("Encryption of a string: "+encrypt(message, Key));
        System.out.println("Decryption of a string: "+decrypt(encrypt(message, Key), Key));
        sc.close();
    }
}