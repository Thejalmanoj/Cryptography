import java.util.*;
public class CaesarAttack
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the cipher text:\n");
        String ct=sc.nextLine();
        for(int key=1;key<26;key++)
        {
            String decrypted_text=decryption(ct,key);
            System.out.println("key: "+key);
            System.out.println("Decrypted text: "+decrypted_text);
        }
        sc.close();
    }
    public static String decryption(String ct,int key)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ct.length();i++)
        {
            char c=ct.charAt(i);
            if(Character.isLetter(c))
            {
                char ch=Character.isUpperCase(c)?'A':'a';
                int chara=(c-ch-key+26)%26+ch;
                sb.append((char)chara);
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
