package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.bean.Documento;

public class DocumentoDao {
	
	private Connection con;
	
	public DocumentoDao(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Documento documento) {
		String sql = "insert into tb_documentos(id_documentos,id_bicicleta,id_cliente,boleto_bicicleta,nota_fiscal_bicicleta,foto_bicicleta) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, documento.getIdDocumento());
			ps.setInt(2, documento.getIdBicicleta());
			ps.setInt(3, documento.getIdCliente());
			ps.setString(4, documento.getBoleto());
			ps.setString(5, documento.getNotaFiscal());
			ps.setString(6,documento.getFotos());
			if(ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			}else {
				return "Erro ao inserir";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}

	}
	
	public String alterar(Documento documento) {
		String sql = "update TB_DOCUMENTOS set boleto_bicicleta= ?,nota_fiscal_bicicleta =?, foto_bicicleta =?";
		sql += "where id_documentos = ? ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, documento.getBoleto());
			ps.setString(2, documento.getNotaFiscal());
			ps.setString(3, documento.getFotos());
			ps.setInt(4, documento.getIdDocumento());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String excluir(Documento documento) {
		String sql ="delete from tb_documentos where id_documentos = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, documento.getIdDocumento());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {	
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<Documento> listaDocumentos(){
		String sql = "select * from tb_documentos";
		ArrayList<Documento> listaDocumentos = new ArrayList<Documento>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Documento documento = new Documento();
					documento.setIdDocumento(rs.getInt(1));
					documento.setIdBicicleta(rs.getInt(2));
					documento.setIdBicicleta(rs.getInt(3));
					documento.setBoleto(rs.getString(4));
					documento.setNotaFiscal(rs.getString(5));
					documento.setFotos(rs.getString(6));
					listaDocumentos.add(documento);
				}
				return listaDocumentos;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
