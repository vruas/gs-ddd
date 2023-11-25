package br.com.fiap.globalsolution.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.globalsolution.model.entity.Consulta;

public class ConsultaRepository extends Repository{
	
	public static ArrayList<Consulta> findAll() {
		ArrayList<Consulta> cons = new ArrayList<Consulta>();
		String sql = "select * from consulta";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Consulta con = new Consulta();
					con.setIdConsulta(rs.getLong("id_consulta"));
					con.setDataCon(rs.getString("data_consulta"));
					con.setHoraCoon(rs.getString("hora_consulta"));
					con.setDetalhesCon(rs.getString("detalhe_consulta"));
					cons.add(con);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return cons;
	}
	
	
	public static Consulta save(Consulta con) {
		String sql = "insert into consulta" + "(id_consulta, data_consulta, hora_consulta, detalhe_consulta)"
				+ " values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, con.getIdConsulta());
			ps.setString(2, con.getDataCon());
			ps.setString(3, con.getHoraCoon());
			ps.setString(4, con.getDetalhesCon());
			
			if (ps.executeUpdate() > 0) {
				return con;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	
	public static boolean delete(Long id) {
		String sql = "delete from consulta where id_consulta=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			if (ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao excluir: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return false;
	}
	
	public static Consulta update(Consulta con) {
		String sql = "UPDATE consulta " + "SET data_consulta=?, hora_consulta=?, detalhe_consulta=?"
				+ "WHERE id_consulta=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, con.getDataCon());
			ps.setString(2, con.getHoraCoon());
			ps.setString(3, con.getDetalhesCon());
			ps.setLong(4, con.getIdConsulta());

			
			if (ps.executeUpdate() > 0) {
				return con;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro fazer update: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	

}
