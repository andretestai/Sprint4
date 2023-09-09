package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.bean.Bicicleta;

public class BicicletaDao {
	private Connection con;

	public BicicletaDao(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserir(Bicicleta bicicleta) {
		String sql = "insert into tb_bicicleta(id_bicicleta,id_cliente,nr_serie,modelo_bicicleta,marca_bicicleta,valor_bicicleta) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, bicicleta.getIdBicicleta());
			ps.setInt(2, bicicleta.getIdCliente());
			ps.setString(3, bicicleta.getNumeroSerie());
			ps.setString(4, bicicleta.getModelo());
			ps.setString(5, bicicleta.getMarca());
			ps.setFloat(6, bicicleta.getValor());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(Bicicleta bicicleta) {
		String sql = "update tb_bicicleta set nr_serie= ?, modelo_bicicleta =?, marca_bicicleta =?, valor_bicicleta =?";
		sql += "where id_bicicleta = ? ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, bicicleta.getNumeroSerie());
			ps.setString(2, bicicleta.getModelo());
			ps.setString(3, bicicleta.getMarca());
			ps.setFloat(4, bicicleta.getValor());
			ps.setInt(5, bicicleta.getIdBicicleta());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String excluir(Bicicleta bicicleta) {
		String sql = "delete from tb_bicicleta where id_bicicleta = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, bicicleta.getIdBicicleta());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public ArrayList<Bicicleta> listaBicicletas() {
		String sql = "select * from tb_bicicleta";
		ArrayList<Bicicleta> listaBicicletas = new ArrayList<Bicicleta>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Bicicleta bicicleta = new Bicicleta();
					bicicleta.setIdBicicleta(rs.getInt(1));
					bicicleta.setIdBicicleta(rs.getInt(2));
					bicicleta.setNumeroSerie(rs.getString(3));
					bicicleta.setModelo(rs.getString(4));
					bicicleta.setMarca(rs.getString(5));
					bicicleta.setValor(rs.getFloat(6));
					listaBicicletas.add(bicicleta);
				}
				return listaBicicletas;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
