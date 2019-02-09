package Banco;

public class PrimeAccount extends BaseAccount {

	public boolean sake(String NameAccount, Integer NumberAccount, Integer PasswordAccount, Double value_sake) {
		
		boolean res = false;
		
		for(int i = 0; i < this.id_account.size(); i++) {
			if(NameAccount.equals(this.name_account.get(i)) && this.number_account.get(i).equals(NumberAccount) && this.password_account.get(i).equals(PasswordAccount)) {
				
				value_sake = deposit_value.get(i) - value_sake;
				deposit_value.remove(i);
				deposit_value.add(i, value_sake);
				res = true;
				
				stratum(i);
			}
		}
		
		return res;
	}	
}
