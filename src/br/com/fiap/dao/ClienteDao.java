package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.bean.Cliente;

public class ClienteDao {

	private Connection con;
	
	public ClienteDao(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserir(Cliente cliente) {
		String sql = "insert into TB_CLIENTE(id_cliente,nm_cliente,cpf_cliente,senha_cliente) values(?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNome());
			ps.setLong(3, cliente.getCpf());
			ps.setString(4, cliente.getSenha());
			if(ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			}else {
				return "Erro ao inserir";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}

	}
	
	public String alterar(Cliente cliente) {
		String sql = "update TB_CLIENTE set nm_cliente= ?, cpf_cliente =?, senha_cliente =?";
		sql += "where id_cliente = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setLong(2, cliente.getCpf());
			ps.setString(3, cliente.getSenha());
			ps.setInt(4, cliente.getIdCliente());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String excluir(Cliente cliente) {
		String sql ="delete from tb_cliente where id_cliente = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {	
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<Cliente> listaClientes(){
		String sql = "select * from tb_cliente";
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setIdCliente(rs.getInt(1));
					cliente.setNome(rs.getString(2));
					cliente.setCpf(rs.getLong(3));
					cliente.setSenha(rs.getString(4));
					listaClientes.add(cliente);
				}
				return listaClientes;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
