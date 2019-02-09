package principal;

import java.util.Scanner;

import Banco.BaseAccount;
import Banco.PrimeAccount;

public class Main {

	public static void main(String[] args) {

		String num1 = "1";
		Scanner ler = new Scanner(System.in);

		BaseAccount conta_base = new BaseAccount();
		PrimeAccount conta_prime = new PrimeAccount();

		while (num1.equals("0") == false) {
			num1 = "1";

			String nome = "";
			Integer numero = 0;
			Integer senha = 0;
			Double value = 0.0;

			System.out.println("      Bank Unimed");
			System.out.println("======================");
			System.out.println("[1]. Cadastrar Conta");
			System.out.println("[2]. Realizar Saque");
			System.out.println("[3]. Realizar Depósito");
			System.out.println("[4]. Tirar Estrato");
			System.out.println("[5]. Excluir Conta");
			System.out.println("======================");
			System.out.print("Escolha uma opção [0. para sair]: ");
			num1 = ler.nextLine();

			if (num1.equals("1")) {

				num1 = "";
				System.out.println("\n\n\n\nCadastrar Conta");
				System.out.println("=================");
				System.out.println("[1]. Conta Básica");
				System.out.println("[2]. Conta Prime");
				System.out.println("=================");

				while (num1.equals("1") == false && num1.equals("2") == false) {
					System.out.print("\nEscolha um opção de conta: ");
					num1 = ler.nextLine();
				}

				System.out.print("\nDigite o nome da conta: ");
				nome = ler.nextLine();

				System.out.print("Digite o número da conta: ");
				numero = Integer.parseInt(ler.nextLine());

				System.out.print("Digite uma senha para a conta: ");
				senha = Integer.parseInt(ler.nextLine());

				System.out.print("Digite um valor de depósito inicial R$: ");
				value = Double.parseDouble(ler.nextLine());

				if (num1.equals("1")) {
					conta_base.addAccount(nome, numero, senha, value);
					System.out.println("\nConta Criada Com Sucesso!!!\nTecle Enter Para Continuar....\n\n\n");
					ler.nextLine();
					num1 = "1";
				} else if (num1.equals("2")) {
					conta_prime.addAccount(nome, numero, senha, value);
					System.out.println("\nConta Criada Com Sucesso!!!\nTecle Enter Para Continuar....\n\n\n");
					ler.nextLine();
					num1 = "1";
				}
			}
			// Cadastrar conta
			else if (num1.equals("2")) {

				if (conta_base.getSize() > 0 || conta_prime.getSize() > 0) {

					System.out.println("\n\n\n\nRealizar Saque:");
					System.out.println("==============\n");

					System.out.print("Digite o nome da conta: ");
					nome = ler.nextLine();
					System.out.print("Digite o número da conta: ");
					numero = Integer.parseInt(ler.nextLine());
					System.out.print("Digite a senha da conta: ");
					senha = Integer.parseInt(ler.nextLine());
					System.out.print("Digite quanto deseja sacar R$: ");
					value = Double.parseDouble(ler.nextLine());

					boolean sake_base = conta_base.sake(nome, numero, senha, value);
					boolean sake_prime = conta_prime.sake(nome, numero, senha, value);

					if (sake_base == true || sake_prime == true) {
						System.out.println("\nSaque realizado com sucesso!!!\nTecle Enter Para Continuar....\n\n\n");
						ler.nextLine();
					} else {
						System.out.println("\nConta não encontrada!!!\nTecle Enter Para Continuar....\n\n\n");
						ler.nextLine();
					}

				}

			}
			// Realizar Saque
			else if (num1.equals("3")) {
				
				if (conta_base.getSize() > 0 || conta_prime.getSize() > 0) {

					System.out.println("\n\n\n\nRealizar Depósito:");
					System.out.println("==============\n");

					System.out.print("Digite o nome da conta: ");
					nome = ler.nextLine();
					System.out.print("Digite o número da conta: ");
					numero = Integer.parseInt(ler.nextLine());
					System.out.print("Digite a senha da conta: ");
					senha = Integer.parseInt(ler.nextLine());
					System.out.print("Digite quanto deseja depositar R$: ");
					value = Double.parseDouble(ler.nextLine());

					boolean deps_base = conta_base.deposit(nome, numero, senha, value);
					boolean deps_prime = conta_prime.deposit(nome, numero, senha, value);

					if (deps_base == true || deps_prime == true) {
						System.out.println("\nDepósito realizado com sucesso!!!\nTecle Enter Para Continuar....\n\n\n\n\n");
						ler.nextLine();
					} else {
						System.out.println("\nConta não encontrada!!!\nTecle Enter Para Continuar....\n\n\n\n\n");
						ler.nextLine();
					}

				}
			}
			// Realizar Depósito
			else if (num1.equals("4")) {

				if (conta_base.getSize() > 0 || conta_prime.getSize() > 0) {

					System.out.println("\n\n\n\nStratum Account: ");
					System.out.println("=================\n");
					
					System.out.print("Digite o nome da conta: ");
					nome = ler.nextLine();
					System.out.print("Digite o número da conta: ");
					numero = Integer.parseInt(ler.nextLine());
					System.out.print("Digite a senha da conta: ");
					senha = Integer.parseInt(ler.nextLine());
					
					int type = 0;
					int id = 0;
					
					for(int i = 0 ; i < conta_base.getSize(); i++) {
						if(conta_base.getName(i).equals(nome) && conta_base.getNum(i).equals(numero) && conta_base.getPass(i).equals(senha)) {
							type = 1;
							id = i;
						}
					}
					
					for(int i = 0 ; i < conta_prime.getSize(); i++) {
						if(conta_prime.getName(i).equals(nome) && conta_prime.getNum(i).equals(numero) && conta_prime.getPass(i).equals(senha)) {
							type = 2;
							id = i;
						}
					}
					
					if(type == 1) {
						System.out.println("");
						conta_base.stratum(id);
						
						System.out.println("Estrato efentuado com sucesso!!!\nTecle Enter Para Continuar....\n\n\n\n");
						ler.nextLine();
					}
					else if(type == 2) {
						System.out.println("");
						conta_prime.stratum(id);
						
						System.out.println("Estrato efentuado com sucesso!!!\nTecle Enter Para Continuar....\n\n\n\n");
						ler.nextLine();
					}
					else {
						System.out.println("Conta Inválida!!!\nTecle Enter Para Continuar.....\n\n\n");
						ler.nextLine();
					}
				}
				
				
			}
			// Tirar Estrato Da Conta
			else if (num1.equals("5")) {

			}
			// Excluir conta
			else if (num1.equals("0")) {
				num1 = "0";
			}
			// Sair
			else {
				if(conta_base.getSize() > 0 || conta_prime.getSize() > 0) {
					System.out.println("\n\n\n\nDelete Account: ");
					System.out.println("=================\n");
					
					System.out.print("Digite o nome da conta: ");
					nome = ler.nextLine();
					System.out.print("Digite o número da conta: ");
					numero = Integer.parseInt(ler.nextLine());
					System.out.print("Digite a senha da conta: ");
					senha = Integer.parseInt(ler.nextLine());
					
					int type = 0;
					int id = 0;
					
					for(int i = 0 ; i < conta_base.getSize(); i++) {
						if(conta_base.getName(i).equals(nome) && conta_base.getNum(i).equals(numero) && conta_base.getPass(i).equals(senha)) {
							type = 1;
							id = i;
						}
					}
					
					for(int i = 0 ; i < conta_prime.getSize(); i++) {
						if(conta_prime.getName(i).equals(nome) && conta_prime.getNum(i).equals(numero) && conta_prime.getPass(i).equals(senha)) {
							type = 2;
							id = i;
						}
					}
					
					if(type == 1) {
						conta_base.removeAccount(id);
						System.out.println("Conta Removida Com Sucesso!!!\nTecle Enter Para Continuar....\n\n\n\n");
						ler.nextLine();
					}
					else if(type == 2) {
						conta_prime.removeAccount(id);
						System.out.println("Conta Removida Com Sucesso!!!\nTecle Enter Para Continuar....\n\n\n\n");
						ler.nextLine();
					}
					else {
						System.out.println("Nenhuma Conta Encontrada!!!\nTecle Enter Para Continuar....\n\n\n\n");
						ler.nextLine();
					}
				}
			}
			// Caso a opção seja incorreta
		}

	}

}
