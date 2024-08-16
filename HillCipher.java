import java.util.*;
public class HillCipher
{
  static int n;
  static int[][] key_matrix;
  static int[] pt_matrix;
  static int[] ct_matrix;
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the size of plain text:");
    n=sc.nextInt();
    key_matrix=new int[n][n];
    pt_matrix=new int[n];
    ct_matrix=new int[n];
    System.out.println("Enter the plain text:");
    String pt=sc.next().toUpperCase();
    if(pt.length()!=n)
    {
      System.out.println("Plain text length should be "+n);
    }
    else
    {
      System.out.println("Enter the key(Size should be"+" "+n*n+"):");
      String key=sc.next().toUpperCase();
      if(key.length()!=n*n)
      {
        System.out.println("Invalid matrix size");
      }
      else
      {
        performHillCipher(pt,key);
      }
    }
    sc.close();
  }
  static void performHillCipher(String pt,String key)
  {
    keyMatrix(key);
    for(int i=0;i<n;i++)
    {
      pt_matrix[i]=(pt.charAt(i))%65;
    }
    encryption(pt_matrix,key_matrix);
    String ct="";
    for(int i=0;i<n;i++)
    {
      ct+=(char)(ct_matrix[i]+65);
    }
    System.out.println("Cipher text:"+ct);
  }
  static void keyMatrix(String key)
  {
    int k=0;
    for(int i=0;i<n;i++)
    {
      for(int j=0;j<n;j++)
      {
        key_matrix[i][j]=(key.charAt(k)) % 65;
        k++;
      }
    }
  }
  static void encryption(int pt_matrix[],int key_matrix[][])
  {
    for(int i=0;i<n;i++)
    {
      ct_matrix[i]=0;
      for(int j=0;j<n;j++)
      {
        ct_matrix[i]+=key_matrix[i][j]*pt_matrix[j];
      }
      ct_matrix[i]=ct_matrix[i]%26;
    }
  }
 }
