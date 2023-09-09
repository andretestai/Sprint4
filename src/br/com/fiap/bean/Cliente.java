package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class Cliente {

	private int idCliente;
	private String nome, senha;
	private long cpf;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public void setCliente() {
		String aux = JOptionPane.showInputDialog("Digite o Id:");
		int auxInt = Integer.parseInt(aux);
		idCliente = auxInt;
		aux = JOptionPane.showInputDialog("Digite o nome:");
		nome = aux;
		aux = JOptionPane.showInputDialog("Digite o Cpf:");
		long auxLong = Long.parseLong(aux);
		cpf = auxLong;
		aux = JOptionPane.showInputDialog("Digite a senha:");
		senha = aux;
	}

	public String toString() {
		return "Id: " + idCliente + "\nNome: " + nome + "\nCPF: cpf" + "\nSenha: " + senha + "\n";
	}
}
