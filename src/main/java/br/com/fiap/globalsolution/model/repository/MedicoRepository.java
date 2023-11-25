package br.com.fiap.globalsolution.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.globalsolution.model.entity.Medico;

public class MedicoRepository  extends Repository{
	
	public static ArrayList<Medico> findAll() {
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		String sql = "select * from medico";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Medico med = new Medico();
					med.setIdMed(rs.getLong("id_medico"));
					med.setNomeCompleto(rs.getString("nome_completo_medico"));
					med.setEspecMed(rs.getString("especMed_medico"));
					med.setEndereco(rs.getString("endereco_medico"));
					med.setEmail(rs.getString("email_medico"));
					med.setDisponibilidade(rs.getString("disponibilidade_medico"));
					medicos.add(med);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return medicos;
	}
	
	
	public static Medico save(Medico med) {
		String sql = "insert into medico" + "(id_medico, nome_completo_medico, especMed_medico, endereco_medico, email_medico, disponibilidade_medico)"
				+ " values(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, med.getIdMed());
			ps.setString(2, med.getNomeCompleto());
			ps.setString(3, med.getEspecMed());
			ps.setString(4, med.getEndereco());
			ps.setString(5, med.getEmail());
			ps.setString(6, med.getDisponibilidade());
			
			if (ps.executeUpdate() > 0) {
				return med;
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
		String sql = "delete from medico where id_medico=?";
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
	
	public static Medico update(Medico med) {
		String sql = "UPDATE medico " + "SET nome_completo_medico=?, especMed_medico=?, endereco_medico=?, email_medico=?, disponibilidade_medico=?"
				+ "WHERE id_medico=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, med.getNomeCompleto());
			ps.setString(2, med.getEspecMed());
			ps.setString(3, med.getEndereco());
			ps.setString(4, med.getEmail());
			ps.setString(5, med.getDisponibilidade());
			ps.setLong(6, med.getIdMed());

			if (ps.executeUpdate() > 0) {
				return med;
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
