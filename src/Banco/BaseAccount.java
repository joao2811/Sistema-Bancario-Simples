package Banco;

import java.util.ArrayList;
import java.util.List;

public class BaseAccount {

	protected List<Integer> id_account = new ArrayList<>();
	protected List<String> name_account = new ArrayList<>();
	protected List<Integer> number_account = new ArrayList<>();
	protected List<Integer> password_account = new ArrayList<>();
		
	protected List<Double> deposit_value = new ArrayList<>();
		
 	public void addAccount(String name, Integer number, Integer password, Double value_initial_deposit) {
		
		this.id_account.add(id_account.size() + 1);
		this.name_account.add(name);
		this.number_account.add(number);
		this.password_account.add(password);
		this.deposit_value.add(value_initial_deposit);
		
	}
	
	public void removeAccount(int id) {
		
		this.id_account.remove(id - 1);
		this.name_account.remove(id - 1);
		this.number_account.remove(id - 1);
		this.password_account.remove(id - 1);
		this.deposit_value.remove(id - 1);
		
	}
	
	public boolean sake(String NameAccount, Integer NumberAccount, Integer PasswordAccount, Double value_sake) {
		
		boolean res = false;
		
		for(int i = 0; i < this.id_account.size(); i++) {
			if((NameAccount.equals(this.name_account.get(i))) && (this.number_account.get(i).equals(NumberAccount)) && (this.password_account.get(i).equals(PasswordAccount))) {
				
				value_sake = deposit_value.get(i) - value_sake - 5.0;
				deposit_value.remove(i);
				deposit_value.add(i, value_sake);
				res = true;
				
				stratum(i);
			}
		}
		
		return res;
	}

	public boolean deposit(String NameAccount, Integer NumberAccount, Integer PasswordAccount, Double value_deposit) {
		boolean res = false;
		
		for(int i = 0; i < this.id_account.size(); i++) {
			if((NameAccount.equals(this.name_account.get(i))) && (this.number_account.get(i).equals(NumberAccount)) && (this.password_account.get(i).equals(PasswordAccount))) {
				
				value_deposit = deposit_value.get(i) + value_deposit;
				deposit_value.remove(i);
				deposit_value.add(i, value_deposit);
				res = true;
				
				stratum(i);
			}
		}	
		return res;
	}
	
	public void stratum(Integer IdAccount) {
		StringBuilder montar = new StringBuilder();
		
		montar.append("\n\nStratum Account:\n");
		montar.append("===================================\n");
		montar.append("Name Account: " + this.name_account.get(IdAccount) + "\n");
		montar.append("Number Account: " + this.number_account.get(IdAccount) + "\n");
		montar.append("Balance: R$" + String.format("%.2f",this.deposit_value.get(IdAccount)) + "\n");
		montar.append("===================================\n");
	
		System.out.println(montar.toString());
	}
	
	public Integer getSize() {
		return this.id_account.size();
	}

	public String getName(int i) {
		return this.name_account.get(i);
	}
	
	public Integer getNum(int i) {
		return this.number_account.get(i);
	}
	
	public Integer getPass(int i) {
		return this.password_account.get(i);
	}
}
