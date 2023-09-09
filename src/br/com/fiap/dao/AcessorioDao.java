package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.bean.Acessorio;

public class AcessorioDao {

private Connection con;
	
	public AcessorioDao(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Acessorio acessorio) {
		String sql = "insert into tb_acessorio(id_acessorio,id_bicicleta,id_cliente,ds_acessorio,valor_acessorio) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, acessorio.getIdAcessorio());
			ps.setInt(2, acessorio.getIdBicicleta());
			ps.setInt(3, acessorio.getIdCliente());
			ps.setString(4, acessorio.getDescricao());
			ps.setFloat(5, acessorio.getValor());
			if(ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			}else {
				return "Erro ao inserir";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String alterar(Acessorio acessorio) {
		String sql = "update tb_acessorio set ds_acessorio= ?, valor_acessorio =?";
		sql += "where id_acessorio= ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, acessorio.getDescricao());
			ps.setFloat(2, acessorio.getValor());
			ps.setInt(3, acessorio.getIdAcessorio());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String excluir(Acessorio acessorio) {
		String sql ="delete from tb_acessorio where id_acessorio = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, acessorio.getIdAcessorio());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {	
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<Acessorio> listaAcessorios(){
		String sql = "select * from tb_acessorio";
		ArrayList<Acessorio> listaAcessorios = new ArrayList<Acessorio>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Acessorio acessorio = new Acessorio();
					acessorio.setIdAcessorio(rs.getInt(1));
					acessorio.setIdBicicleta(rs.getInt(2));
					acessorio.setIdCliente(rs.getInt(3));
					acessorio.setDescricao(rs.getString(4));
					acessorio.setValor(rs.getInt(5));
					listaAcessorios.add(acessorio);
				}
				return listaAcessorios;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
