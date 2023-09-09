package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class Acessorio {
	private int idAcessorio, idBicicleta, idCliente;
	private String descricao;
	private float valor;

	public int getIdAcessorio() {
		return idAcessorio;
	}

	public void setIdAcessorio(int idAcessorio) {
		this.idAcessorio = idAcessorio;
	}

	public int getIdBicicleta() {
		return idBicicleta;
	}

	public void setIdBicicleta(int idBicicleta) {
		this.idBicicleta = idBicicleta;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setAcessorio() {
		
			String aux = JOptionPane.showInputDialog("Digite o Id dos Acessorio:");
			int auxInt = Integer.parseInt(aux);
			idAcessorio = auxInt;
			aux = JOptionPane.showInputDialog("Digite o id da bicleta:");
			auxInt = Integer.parseInt(aux);
			idBicicleta = auxInt;
			aux = JOptionPane.showInputDialog("Digite o id do cliente:");
			auxInt = Integer.parseInt(aux);
			idCliente = auxInt;
			aux = JOptionPane.showInputDialog("Digite sobre o acessório:");
			descricao = aux;
			aux = JOptionPane.showInputDialog("Valor do acessório:");
			float auxFloat = Float.parseFloat(aux);

			while (auxFloat < 200) {
				aux = JOptionPane.showInputDialog("Valor fora da faixa permitida(Valor deve ser maior que 200)"
						+ " Digite o valor do acessório:");
				auxFloat = Float.parseFloat(aux);
			}
			valor = auxFloat;
	}

	public String toString() {
		return "Id Acessorio: " + idAcessorio + "\nId Bicicleta: " + idBicicleta + "\nIdCliente: " + idCliente
				+ "\nDescrição: " + descricao + "\nValor: " + valor + "R$\n";
	}
}
