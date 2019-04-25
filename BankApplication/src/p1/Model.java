package p1;
import java.sql.*;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class Model {
	ArrayList al1=new ArrayList();
	ArrayList al2=new ArrayList();
	private String amount;
	private String raccno;
	private String oldpwd;
	private String newpwd;
	private String accno;
	private String name;
	private String custid;
	private String pwd;
	private String balance;
	private String email;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccno() {
		return accno;
	}
	public String getName() {
		return name;
	}
	public String getCustid() {
		return custid;
	}
	public String getPwd() {
		return pwd;
	}
	public String getBalance() {
		return balance;
	}
	public String getEmail() {
		return email;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRaccno() {
		return raccno;
	}
	public void setRaccno(String raccno) {
		this.raccno = raccno;
	}

	Model() 
	{

		try
		{
			DriverManager.registerDriver(new OracleDriver());
			con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "system");

		} 
		catch (SQLException e)
		{

			e.printStackTrace();
		}
	}
	boolean login()
	{
		try
		{
			String s="SELECT * FROM BANKDB WHERE CUSTID=? AND PWD=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1,custid);
			pstmt.setString(2,pwd);
			res=pstmt.executeQuery();
			if(res.next()==true)
			{
				accno=res.getString("accno");
				return true;

			}
			else
			{
				return false;

			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;

	}
	boolean balance()
	{
		try
		{

			String s="SELECT * FROM BANKDB WHERE ACCNO=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, accno);
			res=pstmt.executeQuery();
			if(res.next()==true)
			{
				balance=res.getString("BALANCE");
				System.out.println("cb"+balance);
				return true;
			}
			else
			{
				return false;
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	int changePwd()
	{
		try
		{
			String s1="SELECT * FROM BANKDB WHERE ACCNO=? AND PWD=?";
			pstmt=con.prepareStatement(s1);
			pstmt.setString(1,accno);
			pstmt.setString(2, oldpwd);
			res=pstmt.executeQuery();
			if(res.next()==true)
			{
				try
				{
					String s2="UPDATE BANKDB SET PWD=? WHERE ACCNO=?";
					pstmt=con.prepareStatement(s2);
					pstmt.setString(1,newpwd);
					pstmt.setString(2,accno);
					int x=pstmt.executeUpdate();
					return x;
				}
				catch(Exception e)
				{
					e.printStackTrace();

				}
			}



		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}



	boolean transfer()
	{
		try
		{

			String s="SELECT * FROM BANKDB WHERE ACCNO=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1,raccno);
			res=pstmt.executeQuery();
			if(res.next()==true)
			{
				
				
					String s1="UPDATE BANKDB SET BALANCE=BALANCE + ? WHERE ACCNO=?";
					pstmt=con.prepareStatement(s1);
					pstmt.setString(1,amount);
					pstmt.setString(2,raccno);
					int x=pstmt.executeUpdate();

					if(x==1)
					{



						String s2="UPDATE BANKDB SET BALANCE=BALANCE - ? WHERE ACCNO=?";
						pstmt=con.prepareStatement(s2);
						pstmt.setString(1,amount);
						pstmt.setString(2,accno);
						x=pstmt.executeUpdate();
						
						if(x==0)
						{
							return false;
						}
						else
						{
							try
							{
								String s3="INSERT INTO APPLICATION VALUES(?,?,?)";
								pstmt=con.prepareStatement(s3);
								pstmt.setString(1, accno);
								pstmt.setString(2, raccno);
								pstmt.setString(3,amount);
								pstmt.executeUpdate();
								return true;

							}

							catch(Exception e)
							{
								e.printStackTrace();
							}

						}
					}
					else
					{
						return false;

					}
				}
		}

				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				return false;
	}
	
	
	
	boolean loan()
	{
		try
		{
			String s="SELECT * FROM BANKDB WHERE ACCNO=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1,accno);
			res=pstmt.executeQuery();
			if(res.next()==true)
			{
				name=res.getString("NAME");
				System.out.println("name"+name);
				email=res.getString("EMAIL");
				System.out.println("email"+email);
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	void getStatement()
	{
		try
		{
			String s="SELECT * FROM APPLICATION WHERE ACCNO=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1,accno);
			res=pstmt.executeQuery();

			while(res.next()==true)
			{
				al1.add(res.getString(2));
				al2.add(res.getString(3));
				System.out.println(al1);
				System.out.println(al2);
			}
			
			
			
		}
		catch(Exception e)
		{
				System.out.println("prblem of 425");
		}
	}
	
	int forgotPwd()
	{
		try
		{
			String s = "UPDATE BANKAPP SET PWD=? WHERE EMAIL=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, pwd);
			pstmt.setString(2, email);
			int x = pstmt.executeUpdate();
			return x;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
}

























