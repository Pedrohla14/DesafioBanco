package entities;

public abstract class Conta implements IConta {
	
	
	private static final int AGENCIA_PADRAO=1;

	private static int SEQUENCIAL=1;
	
	protected Integer agencia;
	protected Integer numero;
	protected double saldo;
	protected Cliente cliente;

	 public Conta(Cliente cliente) {
		 this.agencia=Conta.AGENCIA_PADRAO;
		 this.numero=SEQUENCIAL++;
		 this.cliente=cliente;
	 }
	
	
	
	@Override
	public void sacar(double valor) {
		this.saldo-=valor;
		
	}
	@Override
	public void depositar(double valor) {
		this.saldo+=valor;
		
	}
	@Override
	public void tranferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		
	}
	
	public Integer getAgencia() {
		return agencia;
	}
	public Integer getNumero() {
		return numero;
	}
	public Double getSaldo() {
		return saldo;
	}
	
	protected void imprimirInfoComuns() {
		System.out.println(String.format("Titular : %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}



	@Override
	public String toString() {
		return "Conta [agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo + ", cliente=" + cliente + "]";
	}


}
