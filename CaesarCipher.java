import java.util.*;
public class CaesarCipher
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the plain text:");
        String pt=sc.nextLine();
        System.out.println("Enter the key:");
        int key=sc.nextInt();
        String cipher_text=encryption(pt,key);
        System.out.println("Encrpted text is"+" "+cipher_text);
        decryption(cipher_text,key);
        sc.close();
    }
    public static String encryption(String pt,int key)
    {
        StringBuilder ct=new StringBuilder();
        for(int i=0;i<pt.length();i++)
        {
            char c=pt.charAt(i);
            if(Character.isUpperCase(c))
            {
                char ch=(char)(((int)c+key-65)%26+65);
                ct.append(ch);
            }
            else if (Character.isLowerCase(c))
            {
                char ch = (char)(((int)c+key-97)%26+97);
                ct.append(ch);
            }
            else
            {
                ct.append(c);
            }
        }
        return ct.toString();
    }
    public static String decryption(String cipher_text,int key)
    {
        return encryption(cipher_text, 26-key);
    }
}
