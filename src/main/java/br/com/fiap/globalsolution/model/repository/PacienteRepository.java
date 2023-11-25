package br.com.fiap.globalsolution.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.globalsolution.model.entity.Paciente;

public class PacienteRepository extends Repository{

	public static ArrayList<Paciente> findAll() {
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		String sql = "select * from paciente";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Paciente pacien = new Paciente();
					pacien.setId(rs.getLong("id_paciente"));
					pacien.setNomeCompleto(rs.getString("nome_completo_paciente"));
					pacien.setDataNasci(rs.getString("data_nasc_paciente"));
					pacien.setGenero(rs.getString("genero_paciente"));
					pacien.setEndereco(rs.getString("endereco_paciente"));
					pacien.setEmail(rs.getString("email_paciente"));
					pacien.setEspecMed(rs.getString("especMed_paciente"));
					pacientes.add(pacien);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return pacientes;
	}
	
	
	public static Paciente save(Paciente pacien) {
		String sql = "insert into paciente" + "(id_paciente, nome_completo_paciente, data_nasc_paciente, genero_paciente, endereco_paciente, email_paciente, especMed_paciente)"
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, pacien.getId());
			ps.setString(2, pacien.getNomeCompleto());
			ps.setString(3, pacien.getDataNasci());
			ps.setString(4, pacien.getGenero());
			ps.setString(5, pacien.getEndereco());
			ps.setString(6, pacien.getEmail());
			ps.setString(7, pacien.getEspecMed());

			if (ps.executeUpdate() > 0) {
				return pacien;
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
		String sql = "delete from paciente where id_paciente=?";
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
	
	public static Paciente update(Paciente pacien) {
		String sql = "UPDATE paciente " + "SET nome_completo_paciente=?, data_nasc_paciente=?, genero_paciente=?, endereco_paciente=?, email_paciente=?, especMed_paciente=?"
				+ "WHERE id_paciente=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, pacien.getNomeCompleto());
			ps.setString(2, pacien.getDataNasci());
			ps.setString(3, pacien.getGenero());
			ps.setString(4, pacien.getEndereco());
			ps.setString(5, pacien.getEmail());
			ps.setString(6, pacien.getEspecMed());
			ps.setLong(7, pacien.getId());


			if (ps.executeUpdate() > 0) {
				return pacien;
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
