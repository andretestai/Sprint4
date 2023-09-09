package br.com.fiap.main;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.fiap.bean.Acessorio;
import br.com.fiap.bean.Bicicleta;
import br.com.fiap.bean.Cliente;
import br.com.fiap.bean.Documento;
import br.com.fiap.dao.AcessorioDao;
import br.com.fiap.dao.BicicletaDao;
import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.Conexao;
import br.com.fiap.dao.DocumentoDao;

public class teste {

	public static void main(String[] args) {
		String aux, escolha = "sim";
		int auxInt, opcao;
		Connection con = Conexao.abrirConexao();

		while (escolha.equalsIgnoreCase("sim")) {
			try {
				aux = JOptionPane.showInputDialog(
						"Escolha qual deseja usar: \n1.Cliente" + "\n2.Bicicleta \n3.Documento \n4.Acessorio");
				opcao = Integer.parseInt(aux);
				switch (opcao) {
				case 1:
					Cliente cliente = new Cliente();
					ClienteDao cd = new ClienteDao(con);
					aux = JOptionPane.showInputDialog("Deseja: \n1.Cadastrar: \n2.Alterar:"
							+ "\n3.Excluir: \n4.Listar Clientes:" + "\nDigite qualquer coisa para sair!");
					opcao = Integer.parseInt(aux);
					switch (opcao) {
					case 1:
						cliente.setCliente();
						System.out.println(cd.inserir(cliente));
						break;
					case 2:
						cliente.setCliente();
						System.out.println(cd.alterar(cliente));
						break;
					case 3:
						aux = JOptionPane.showInputDialog("Digite o Id do cliente que será excluido:");
						auxInt = Integer.parseInt(aux);
						cliente.setIdCliente(auxInt);
						System.out.println(cd.excluir(cliente));
						break;
					case 4:
						ArrayList<Cliente> listaCliente = cd.listaClientes();
						if (listaCliente != null) {
							for (Cliente cl : listaCliente) {
								System.out.println(cl);
							}
						}
						break;
					}
					break;

				case 2:
					Bicicleta bicicleta = new Bicicleta();
					BicicletaDao bd = new BicicletaDao(con);
					aux = JOptionPane.showInputDialog("Deseja: \n1.Cadastrar: \n2.Alterar:"
							+ "\n3.Excluir: \n4.Listar Bicicletas: \nDigite qualquer coisa para sair!");
					opcao = Integer.parseInt(aux);
					switch (opcao) {
					case 1:
						bicicleta.setBicicleta();
						System.out.println(bd.inserir(bicicleta));
						break;
					case 2:
						bicicleta.setBicicleta();
						System.out.println(bd.alterar(bicicleta));
						break;
					case 3:
						aux = JOptionPane.showInputDialog("Digite o Id da bicicleta que será excluido:");
						auxInt = Integer.parseInt(aux);
						bicicleta.setIdBicicleta(auxInt);
						System.out.println(bd.excluir(bicicleta));
						break;
					case 4:
						ArrayList<Bicicleta> listaBicicleta = bd.listaBicicletas();
						if (listaBicicleta != null) {
							for (Bicicleta bc : listaBicicleta) {
								System.out.println(bc);
							}
						}
						break;
					}
					break;
				case 3:
					Documento documento = new Documento();
					DocumentoDao dd = new DocumentoDao(con);
					aux = JOptionPane.showInputDialog("Deseja: \n1.Cadastrar: \n2.Alterar:"
							+ "\n3.Excluir: \n4.Listar Documentos: \nDigite qualquer coisa para sair!");
					opcao = Integer.parseInt(aux);
					switch (opcao) {
					case 1:
						documento.setDocumento();
						System.out.println(dd.inserir(documento));
						break;
					case 2:
						documento.setDocumento();
						System.out.println(dd.alterar(documento));
						break;
					case 3:
						aux = JOptionPane.showInputDialog("Digite o Id do documento que será excluido:");
						auxInt = Integer.parseInt(aux);
						documento.setIdDocumento(auxInt);
						System.out.println(dd.excluir(documento));
						break;
					case 4:
						ArrayList<Documento> listaDocumento = dd.listaDocumentos();
						if (listaDocumento != null) {
							for (Documento dc : listaDocumento) {
								System.out.println(dc);

							}
						}
						break;
					}
					break;
				case 4:
					Acessorio acessorio = new Acessorio();
					AcessorioDao ad = new AcessorioDao(con);
					aux = JOptionPane.showInputDialog("Deseja: \n1.Cadastrar: \n2.Alterar:"
							+ "\n3.Excluir: \n4.Listar Acessorios: \nDigite qualquer coisa para sair!");
					opcao = Integer.parseInt(aux);
					switch (opcao) {
					case 1:
						acessorio.setAcessorio();
						System.out.println(ad.inserir(acessorio));
						break;
					case 2:
						acessorio.setAcessorio();
						System.out.println(ad.alterar(acessorio));
						break;
					case 3:
						aux = JOptionPane.showInputDialog("Digite o Id do acessório que será excluido:");
						auxInt = Integer.parseInt(aux);
						acessorio.setIdAcessorio(auxInt);
						;
						System.out.println(ad.excluir(acessorio));
						break;
					case 4:
						ArrayList<Acessorio> listaAcessorio = ad.listaAcessorios();
						if (listaAcessorio != null) {
							for (Acessorio ac : listaAcessorio) {
								System.out.println(ac);
							}
						}
						break;
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Escolha incorreta!!!");
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			escolha = JOptionPane.showInputDialog("Deseja continuar?(SIM/NAO)");
		}
		Conexao.fecharConexao(con);
	}

}
