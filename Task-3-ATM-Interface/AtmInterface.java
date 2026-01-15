package tasks;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
public class AtmInterface 
{
	
	public static void bal(int id)
	{
		try(BufferedReader br=new BufferedReader(new FileReader("login3.csv")))
		{
			String line;
			while((line=br.readLine())!=null)
			{
				String[] s= line.split(",");
				int cid=Integer.valueOf(s[0]);
				if(id==cid)
				{
					System.out.println("Current Balance: ₹"+s[2]);
				}
			}
			
		}
		catch( Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
	}

	public static void login(int id,String pin)
	{
		try(BufferedReader br=new BufferedReader(new FileReader("login3.csv")))
		{
			boolean c=false;
			String line;
			while((line=br.readLine())!=null)
			{
				String[] s= line.split(",");
				int cid=Integer.valueOf(s[0]);
				String cpin=s[1];
				if(id==cid && pin.equals(cpin))
				{
					System.out.println("Login Succesful ✔️");
					c=true;
					break;
				}
			}
			if(!c)
			{
				System.out.println("Invalid Credentials 🔐");
				System.exit(0);
			}
		}
		catch( Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	
	
	public static void with(int w,int id)
	{
		
		StringBuilder up=new StringBuilder();
		try(BufferedReader br=new BufferedReader(new FileReader("login3.csv")))
		{
			
			String line;
			while((line=br.readLine())!=null)
			{
				String[] s= line.split(",");
				int cid=Integer.parseInt(s[0]);
				int bal=Integer.parseInt(s[2]);
				if(cid==id)
				{
					if(bal>=w)
					{
						bal-=w;
						s[2]=String.valueOf(bal);
						up.append(String.join(",",s)).append(",").append(-w).append("\n");
						System.out.println("Please collect your cash 💵");
					}
					else
					{
						System.out.println("Insufficient balance for this transaction 🚫");
						up.append(line+"\n");
					}
					
				}
				else {
					up.append(line+"\n");
				}
			}
			
		}
		catch( Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		try(FileWriter fw=new FileWriter("login3.csv",false))
		{
			fw.write(up.toString());
		}
		catch( Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
	}
		
	
	
	
	public static void dep(int d,int id)
	{
		
		StringBuilder up=new StringBuilder();
		try(BufferedReader br=new BufferedReader(new FileReader("login3.csv")))
		{
			String line;
			while((line=br.readLine())!=null)
			{
				String[] s= line.split(",");
				int cid=Integer.parseInt(s[0]);
				int bal=Integer.parseInt(s[2]);
				if(cid==id)
				{
					bal+=d;
					s[2]=String.valueOf(bal);
					up.append(String.join(",",s)).append(",").append(d).append("\n");
					System.out.println("Amount deposited successfully ✅");
				}
				else {
					up.append(line+"\n");
				}
			}
			
		}
		catch( Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		try(FileWriter fw=new FileWriter("login3.csv",false))
		{
			fw.write(up.toString());
		}
		catch( Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	
	
	public static void tra(int amt,int nid,int id)
	{
		
		StringBuilder up=new StringBuilder();
		try(BufferedReader br=new BufferedReader(new FileReader("login3.csv")))
		{
			
			String line;
			while((line=br.readLine())!=null)
			{
				String[] s= line.split(",");
				int cid=Integer.parseInt(s[0]);
				int bal=Integer.parseInt(s[2]);
				if(cid==id)
				{
					if(bal>=amt)
					{
						bal-=amt;
						s[2]=String.valueOf(bal);
						up.append(String.join(",",s)).append(",").append(-amt).append("\n");
						System.out.println("Amount transferred successfully ✅");
					}
					else
					{
						System.out.println("Amount in this account is lesser than withdraw amount 🚫");
						up.append(line+"\n");
					}
				}
				else if(cid==nid)
				{
					bal+=amt;
					s[2]=String.valueOf(bal);
					up.append(String.join(",",s)).append(",").append(amt).append("\n");
				}
		
				
				else {
					up.append(line+"\n");
				}
				
			}
			
		}
		catch( Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		try(FileWriter fw=new FileWriter("login3.csv",false))
		{
			fw.write(up.toString());
		}
		catch( Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	
	
	public static void hist(int id)
	{
		try(BufferedReader br =new BufferedReader(new FileReader("login3.csv")))
		{
			String line;
			while((line=br.readLine())!=null)
			{
				String[] h=line.split(",");
				if(Integer.valueOf(h[0])==id)
				{
					System.out.println("🆔: "+h[0]);
					System.out.println("---------------------------");
					for(int i=3;i<h.length;i++)
					{
						if(h[i].charAt(0)=='-')
						{
							System.out.println("- ₹"+-Integer.valueOf(h[i])+" Withdrawn 📉");
						}
						else
						{
							System.out.println("+ ₹"+h[i]+" Deposited 📈");
						}
					}
					System.out.println("---------------------------\n");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public static boolean che(int id)
	{
		try(BufferedReader br=new BufferedReader(new FileReader("login3.csv")))
		{
			String line;
			while((line=br.readLine())!=null)
			{
				String[] s= line.split(",");
				int cid=Integer.valueOf(s[0]);
				if(id==cid)
				{
					return true;
				}
			}
		}
		catch( Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		return false;
	}
				
	public static void main(String[] args) 
	{
		System.out.println("Welcome to RaHaR Bank 🏧");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User ID 🆔: ");
		int id=sc.nextInt();
		System.out.println("Enter PIN 🔑: ");
		sc.nextLine();
		String pin=sc.nextLine();
		login(id,pin);
		System.out.println("===========================");
		System.out.println("1. Transaction History");
		System.out.println("2. Withdraw");
		System.out.println("3. Deposit");
		System.out.println("4. Transfer");
		System.out.println("5. Quit");
		System.out.println("===========================\n");
		int ch;
		do{
			System.out.println("---------------------------");
			System.out.println("Enter your choice: ");
			ch=sc.nextInt();
			System.out.println("\n");
			switch(ch)
			{
			case 1:
				System.out.println("Transaction History 📊: ");
				hist(id);
				bal(id);
				break;
			case 2:
				System.out.println("Enter amount to withdraw: ₹");
				int w=sc.nextInt();
				if(w<=0)
				{
					System.out.println("Enter a valid amount");
					break;
				}
				with(w,id);
				bal(id);
				break;
			case 3:
				System.out.println("Enter amount to deposit: ₹");
				int d=sc.nextInt();
				if(d<=0)
				{
					System.out.println("Enter a valid amount ⚠️");
					break;
				}
				dep(d,id);
				bal(id);
				break;
			case 4:
				System.out.println("Enter receiver user ID 🆔: ");
				int nid=sc.nextInt();
				if(!che(nid))
				{
					System.out.println("Receiver ID not found ❗");
					break;
				}
				System.out.println("Enter amount to transfer: ₹");
				int amt=sc.nextInt();
				if(amt<=0)
				{
					System.out.println("Enter valid amount ⚠️");
					break;
				}
				tra(amt,nid,id);
				bal(id);
				break;
			}
		}while(ch!=5);
		
		System.out.println("Thank you for using our ATM 🙂");
		sc.close();	
		return;
		
	}

}
