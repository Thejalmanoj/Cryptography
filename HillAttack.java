import java.util.*;
public class HillAttack
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the cipher text:");
        String ct=sc.nextLine().toUpperCase().replaceAll("\\s","");
        int n=2;
        if(ct.length()%n!=0)
        {
            System.out.println("Length of the cipher text should be a multiple of 2");
        }
        else
        {
            for(int a=0;a<26;a++)
            {
                for(int b=0;b<26;b++)
                {
                    for(int c=0;c<26;c++)
                    {
                        for(int d=0;d<26;d++)
                        {
                            int det=(a*d-b*c)%26;
                            if(det!=0 && gcd(det,26)==1)
                            {
                                String pt=decryption(ct,a,b,c,d);
                                System.out.println("Key matrix:\n[ " + a + " " + b + " ]\n[ " + c + " " + d + " ]");
                                System.out.println(pt);
                            }
                        }
                    }
                }
            }
            sc.close();
        }
    }
    public static String decryption(String str,int a,int b,int c,int d)
    {
        StringBuilder sb=new StringBuilder();
        int det=(a*d-b*c)%26;
        int inv=inverse(det,26);
        int invA=(d*inv)%26;
        int invB=(-b*inv)%26;
        int invC=(-c*inv)%26;
        int invD=(a*inv)%26;
        if(invB<0)
            invB+=26;
        if(invC<0)
            invC+=26;
        for(int i=0;i<str.length();i+=2)
        {
            int x1=str.charAt(i)-'A';
            int x2=str.charAt(i+1)-'A';
            int y1=(invA*x1+invB*x2)%26;
            int y2=(invC*x1+invD*x2)%26;
            sb.append((char)(y1+'A'));
            sb.append((char)(y2+'A'));
        }
        return sb.toString();
    }
    public static int inverse(int a,int b)
    {
        for(int x=1;x<b;x++)
        {
            if((a*x)%b==1)
            {
                return x;
            }
        }
        return 1;
    }
    public static int gcd(int a,int b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}