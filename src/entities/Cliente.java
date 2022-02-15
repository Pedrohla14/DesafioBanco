package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	private String nome;
	private int cpf;
	private Date dataNascimento;
	
	
	
	
	

	public Cliente(String nome, int cpf, Date dataNascimento) {
	
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}



	public Date getDataNascimento() {
		return dataNascimento;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + sdf.format(dataNascimento) + "]";
	}

	
	
	
}


