package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class Documento {

	private int idDocumento, idBicicleta, idCliente;
	private String notaFiscal, boleto, fotos;

	public int getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
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

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getBoleto() {
		return boleto;
	}

	public void setBoleto(String boleto) {
		this.boleto = boleto;
	}

	public String getFotos() {
		return fotos;
	}

	public void setFotos(String fotos) {
		this.fotos = fotos;
	}

	public void setDocumento() {
		String aux = JOptionPane.showInputDialog("Digite o Id do Documento:");
		int auxInt = Integer.parseInt(aux);
		idDocumento = auxInt;
		aux = JOptionPane.showInputDialog("Digite o id da bicleta:");
		auxInt = Integer.parseInt(aux);
		idBicicleta = (auxInt);
		aux = JOptionPane.showInputDialog("Digite o id do cliente:");
		auxInt = Integer.parseInt(aux);
		idCliente = (auxInt);
		aux = JOptionPane.showInputDialog("Envie o arquivo do boleto:");
		boleto = aux;
		aux = JOptionPane.showInputDialog("Envie o arquivo da nota fiscal:");
		notaFiscal = aux;
		aux = JOptionPane.showInputDialog("Envie a foto da bicicleta:");
		fotos = aux;
	}

	public String toString() {
		return "Id Documento: " + idDocumento + "\nId Bicicleta: " + idBicicleta + "\nId Cliente: " + idCliente
				+ "\nBoleto: " + boleto + "\nNota Fiscal: " + notaFiscal + "\nFoto da bike: " + fotos + "\n";
	}
}
