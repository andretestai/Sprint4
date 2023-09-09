package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class Bicicleta {
	private int idBicicleta, idCliente;
	private String numeroSerie, modelo, marca;
	private float valor;

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

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		try {
			if (valor > 2000) {
				this.valor = valor;
			} else {
				throw new Exception("Valor fora do permitido");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void setBicicleta() {
			
			String aux = JOptionPane.showInputDialog("Digite o Id da bicicleta:");
			int auxInt = Integer.parseInt(aux);
			idBicicleta = auxInt;
			aux = JOptionPane.showInputDialog("Digite o id do cliente:");
			auxInt = Integer.parseInt(aux);
			idCliente = auxInt;
			aux = JOptionPane.showInputDialog("Digite o Número de série:");
			numeroSerie = aux;
			aux = JOptionPane.showInputDialog("Digite o modelo da bicicleta:");
			modelo = aux;
			aux = JOptionPane.showInputDialog("Digite a marca da bicicleta");
			marca = (aux);
			aux = JOptionPane.showInputDialog("Digite o valor da bicicleta: ");
			float auxFloat = Float.parseFloat(aux);
			
			while (auxFloat < 2000) {
				
				aux = JOptionPane.showInputDialog("Valor fora da faixa permitida(Valor deve ser maior que 2000)."
						+ " Digite o valor da bicicleta: ");
				auxFloat = Float.parseFloat(aux);
			}
			valor = auxFloat;
			
		}
	

	public String toString() {
		return "Id Bicicleta: " + idBicicleta + "\nId Cliente: " + idCliente + "\nNumero de Série: " + numeroSerie
				+ "\nModelo: " + modelo + "\nMarca: " + marca + "\nValor: " + valor + "R$\n";
	}
}
