import java.util.*;
import java.io.*;

class AssemblerExp
{
	 int l =0;
	 static int c=-1;
	 static int count=0;
	 
	 String symbol []= new String [50];

	 public AssemblerExp()
	 {
	 Scanner src = new Scanner(System.in);
	 String x;
	 System.out.println("Enter the name of file with format");
	 String s=src.next();
	 
	 // Taking input from file using BufferReader
	 
	 try
	 {
	 FileReader f = new FileReader(s);
	 BufferedReader bf = new BufferedReader(f);
	 x=bf.readLine();
	 
	 System.out.println("\nPass 2 Symbol Table :-");
	 System.out.println("---------------------------------");
	 System.out.println("Symbol\tvalue\tlength\tR/A\t|");
	 System.out.println("---------------------------------");

	 do
	 {
		 System.out.println(x);
		 check(x); x=bf.readLine();	 
	 }
	 while(x!=null);
	 
	 FileReader fr=new FileReader("sample.txt");
	 BufferedReader buf = new BufferedReader(fr);
	 String b="";
	 
	 while((x=buf.readLine())!=null)
	 {
		 if(x.contains("BASE EQU"))
		 {
			 int k=x.lastIndexOf(" ");
			 b=x.substring(k+1,x.length());
		 }
	 }
	 System.out.println("Base = "+b);
	 }
	 catch(Exception e){}
	 try
	 {
	 FileReader fr=new FileReader(s);
	 BufferedReader br=new BufferedReader(fr);
	 String y="";
	 int l=0; System.out.println();
	 
	 while((x=br.readLine())!=null)
	 {
		 if(x.equals("END")) 
			 System.out.println(x+"\t\t\t\t"+l);
		 
		 else System.out.println(x+"\t\t\t"+l);
	 
		 if(x.contains("BASE EQU"))
		 {
			 int k = x.lastIndexOf(" ");
			 y = x.substring(k+1,x.length());
		 }
		 if(x.contains("L ")||x.contains("ST ")||x.contains("A "))
		 {
			 for(int i=0;i<c;i++)
			 {
				 if(x.contains(symbol[i])) 
					 l+=4;
			 }
		 }
		 
		 for(int i=0;i<c;i++)
		 {
			 if(x.contains(symbol[i]))
			 {
				 if(x.contains("B "))
					 l+=1;
				 else if(x.contains("H "))
					 l+=2;
				 else if(x.contains("F "))
					 l+=4;
				 else if(x.contains("D "))
					 l+=8;
			 }				
		 }	
	 }
	 
	 System.out.println();
	 System.out.println("Base Table");
	 System.out.println("Availability\tContentOfBaseRrg");
	 System.out.println("Yes\t\t"+y);

	 } catch(Exception e){}
	 }
	  void check(String x)
	 {
	 count++;
	 
	 boolean flag = false;
	 if(x.contains("USING")||x.contains("DROP")||x.contains("L")||x.contains("A "))
	 {}
	 else symbol(x);
	 }
	 void symbol(String x)
	 {
	 int i = x.indexOf(" ");
	 String sym = x.substring(0,i);
	 c++;
	 symbol[c]=sym; if(c!=0 &&!(x.contains("EQU")) )
	 {
	 int length=0;
	 if(x.contains("F")) length=4;
	 else if(x.contains("B")) length=1;
	 else if(x.contains("D")) length=8;
	 String value;
	 value=x.substring(x.lastIndexOf(" ")+1);
	 System.out.println(symbol[c]+"\t "+l+"\t "+length+"B\t"+" R\t| ");

	l=l+length;
	 }
	 else
	 if(c==0)
	 {
	 boolean flag = false;
	 if(x.endsWith("START")) 
		 flag=true;
	 if(flag)
		 System.out.println(symbol[c]+"\t - "+"\t 1B\t "+"R\t| ");
	 else
		 System.out.println(symbol[c]+"\t- "+"\t 1B\t "+"A\t| ");
	 }
	 if(x.contains("EQU"))
	 { System.out.println(symbol[c]+"\t 8"+"\t 1B\t "+"A\t| ");
	 }
	 }
	 }
	 class Assembler2
	 {
	 public static void main(String args[])
	 {
	 AssemblerExp obj = new AssemblerExp();
	 System.out.println("---------------------------------");
	 }//funt

	 }//class

