package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Banco;
import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		//DADOS DO BANCO 
		Banco banco= new Banco();
		banco.setNome("BANCO_ARAUJO");
		
		
		//DADOS DOS CLIENTES 
	
		System.out.println("====================");
		System.out.println("CRIAR UMA CONTA ");
		System.out.println("====================");
		
		System.out.println("====================");
		System.out.println("DESEJA CRIAR UMA CONTA: DIGITE S/N");
		char confirmacao= sc.next().toUpperCase().charAt(0);
		
		
		if(confirmacao=='S') {
		// DADOS DO CLIENTE 
		sc.nextLine();
		System.out.println("digite o nome do cliente ");
		String nomeCliente= sc.nextLine();;
		System.out.println("digite o CPF do cliente ");
		int cpf=sc.nextInt();
		System.out.println("digite a data de nascimento ");
		Date dataNascimento= sdf.parse(sc.next());
		Cliente cliente = new Cliente(nomeCliente, cpf, dataNascimento);
		System.out.println("====================");
		//DADOS DA CONTA CORRENTE
		System.out.println("DESEJA CRIAR UMA CONTA CORRENTE: DIGITE S/N");
		char confirmacao2= sc.next().toUpperCase().charAt(0);
		
		if(confirmacao2=='S') {
			Conta cc= new ContaCorrente(cliente);
			System.out.println("DEPOSITO DE QUANTO:");
			cc.depositar(sc.nextDouble());
			banco.getContas().add(cc);
			System.out.println("====================");
			cc.imprimirExtrato();
			System.out.println("====================");
		}
		System.out.println("====================");
		//DADOS DA CONTA POUPANÇA
				System.out.println("DESEJA CRIAR UMA CONTA POUPANÇA: DIGITE S/N");
				char confirmacao3= sc.next().toUpperCase().charAt(0);
				
				if(confirmacao3=='S') {
					Conta poupanca= new ContaPoupanca(cliente);
					System.out.println("DEPOSITO DE QUANTO:");
					poupanca.depositar(sc.nextDouble());
					banco.getContas().add(poupanca);
					
					System.out.println("====================");
					poupanca.imprimirExtrato();
					System.out.println("====================");
					
					
				}
				System.out.println("====================");
				
		}
		
		
		
		
		System.out.println("Digite 1 -sacar\n"
				+ "Digite 2 -depositar\n"
				+"Digite 3 -transferir\n");
		int operacao=sc.nextInt();
	switch (operacao) {
	case 1: {
		System.out.println("digite o numero da conta ");
		int numeroConta= sc.nextInt();
		System.out.println("digite o valor:  ");
		double valor=sc.nextDouble();
	banco.getContas().get(numeroConta-1).sacar(valor);
		break;
	}
	
	case 2: {
		System.out.println("digite o numero da conta ");
		int numeroConta= sc.nextInt();
		System.out.println("digite o valor:  ");
		double valor=sc.nextDouble();
	banco.getContas().get(numeroConta-1).depositar(valor);
		break;
	}
	
	case 3: {
		System.out.println("digite o numero da conta ");
		int numeroConta= sc.nextInt();
		System.out.println("digite o valor:  ");
		double valor=sc.nextDouble();
		Conta saindoDinheiro=	banco.getContas().get(numeroConta-1);
	
	System.out.println("digite o numero da conta do destino  ");
		int numeroContaDestino= sc.nextInt();
		Conta entrandoDinheiro=banco.getContas().get(numeroContaDestino-1);
		saindoDinheiro.tranferir(valor, entrandoDinheiro);
		
		

		
	
		break;
	}
	
	
	
	default:
		System.out.println("operaçap invalida ");
	}
		
		
//imprimindo dados das contas
	for (Conta c:banco.getContas()) {
		System.out.println(c);
	}
		
		
		
		
		
		
		
		sc.close();

	}

}
