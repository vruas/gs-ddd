package br.com.fiap.globalsolution.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.globalsolution.model.entity.Hospital;

public class HospitalRepository extends Repository{
	
	public static ArrayList<Hospital> findAll() {
		ArrayList<Hospital> hosps = new ArrayList<Hospital>();
		String sql = "select * from hospital";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Hospital hosp = new Hospital();
					hosp.setIdHospital(rs.getLong("id_hospital"));
					hosp.setNome(rs.getString("nome_hospital"));
					hosp.setEndereco(rs.getString("endereco_hospital"));
					hosps.add(hosp);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return hosps;
	}
	
	
	public static Hospital save(Hospital hosp) {
		String sql = "insert into hospital" + "(id_hospital, nome_hospital, endereco_hospital)"
				+ " values(?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, hosp.getIdHospital());
			ps.setString(2, hosp.getNome());
			ps.setString(3, hosp.getEndereco());
			
			if (ps.executeUpdate() > 0) {
				return hosp;
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
		String sql = "delete from hospital where id_hospital=?";
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
	
	public static Hospital update(Hospital hosp) {
		String sql = "UPDATE hospital " + "SET nome_hospital=?, endereco_hospital=?"
				+ "WHERE id_hospital=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, hosp.getIdHospital());
			ps.setString(2, hosp.getNome());
			ps.setString(3, hosp.getEndereco());
			
			if (ps.executeUpdate() > 0) {
				return hosp;
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
	
	

}
