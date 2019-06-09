package com.company;
import java.util.ArrayList;

public class Customer {

	private String name;
	private String id; 	//3 digits string
	private String pin; //4 digits string
	private ArrayList <Account> acct;
	private int my_account_num;
//	private double total_bal; //for all accounts
	public static int total_customers;
	public int total;


	
	public Customer(String new_name, String new_id, String new_pin) { //Constructor
		acct = new ArrayList<>(100);
		this.name = new_name;
		this.id = new_id;
		this.pin = new_pin;
		this.my_account_num = 0;
		
	}
	
	void info(){
		System.out.println("\n**Customer Created**");		
		System.out.println("Customer Name: " + this.name);
		System.out.println("Customer pin: " + this.pin);
		System.out.println("Customer ID: " + this.id);
		System.out.println("Total Customers: " + total_customers);		
		
	}
	
	String validatePin(){
		
		return this.pin;
		
	}
	
	void validateAccount(String account, double deposit)
	{
		for (int i = 0; i < this.total; i++)
		{
			if((this.acct.get(i).getNumber()).equals(account))
			{
				this.acct.get(i).addDeposit(deposit);
				break;
			}
		}

		System.out.println("Account " + account + " Does not Exist!");
	}

	void withdrawFromAccount(String account, double sum)
	{
		for (int i = 0; i < this.total; i++)
		{
			if((this.acct.get(i).getNumber()).equals(account))
			{
				this.acct.get(i).withdrawDeposit(sum);
				break;
			}
		}

		System.out.println("Account " + account + " Does not Exist!");
	}
	
	void checkAccount(String account){
		boolean check = false;
		for (int i = 0; i < this.total; i++){

			if((this.acct.get(i).getNumber()).equals(account)){
				System.out.println("\nAccount Owner's Name: " + this.name);
				System.out.println("Account Owner's ID Number " + this.id);
				this.acct.get(i).check_balance();
				check = true;
				break;
			}
			
		} 
		if (!check){
			System.out.println("Account " + account + " Does not Exist!");
		}
	}
	
	void addAccount(int Account_Number){
		Account new_account = new Account(Account_Number, total_customers);
		System.out.println("\n**Account Created**");
		new_account.info();
		this.acct.add(total, new_account);
		total_customers += 1;
		my_account_num += 1;
	}

	public void listAccounts()
	{
		System.out.println("\n[Account #]");

		for (int i = 0; i < this.my_account_num; i++)
		{
			if (this.acct.get(i).getActive())
			{
				System.out.printf("\n[" + this.acct.get(i).getNumber() + "]\t\t" + "[");
			}
		}
	}

	boolean validateAccountToFrom(String account)
	{
		for (int i = 0; i < this.my_account_num; i++)
		{
			if((this.acct.get(i).getNumber()).equals(account) && (this.acct.get(i).getActive()))
			{
				return true;
			}
		}

		System.out.println("\nAccount " + account + " Does not Exist For This User!");

		return false;
	}

	boolean checkAmount(String account_from, String transfer_amount){

		double dbl_transfer_amount = Double.parseDouble(transfer_amount);;

		int int_account_from = -1;

		for (int i = 0; i < this.my_account_num; i++){
			if((this.acct.get(i).getNumber()).equals(account_from)){

				int_account_from = i;
			}
		}

		if (int_account_from != -1){
			if(this.acct.get(int_account_from).getBalance() >= dbl_transfer_amount){
				return true;
			}else{
				return false;
			}

		} else{
			return false;
		}


	}

	public boolean test(String account)
	{
		for (int i = 0; i < this.my_account_num; i++)
		{
			if ((this.acct.get(i).getNumber()).equals(account) && (this.acct.get(i).getActive()))
			{
				return true;
			}
		}

		return false;
	}

	public int getAccountNum(){
		return my_account_num;
	}

	public String getName(){
		return this.name;
	}

	public String getId(){
		return this.id;
	}

	public String getPin(){
		return this.pin;
	}

	public ArrayList <Account> getAccountArrayList(){
		return this.acct;
	}
	public Account getAccountArray(int i){
		return this.acct.get(i);
	}
	
	public double cal_total_bal()  { //different than the stuff given by instructor

		return 0;
	}
	
}
