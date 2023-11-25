package br.com.fiap.globalsolution.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.globalsolution.model.entity.Usuario;

public class UsuarioRepository extends Repository{

	public static ArrayList<Usuario> findAll() {
		ArrayList<Usuario> users = new ArrayList<Usuario>();
		String sql = "select * from usuario";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Usuario user = new Usuario();
					user.setNome(rs.getString("nome_usuario"));
					user.setCpf(rs.getString("cpf_usuario"));
					user.setEmail(rs.getString("email_usuario"));
					user.setSenha(rs.getString("senha_usuario"));
					users.add(user);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return users;
	}
	
	
	public static Usuario save(Usuario user) {
		String sql = "insert into usuario" + "(nome_usuario, cpf_usuario, email_usuario, senha_usuario)"
				+ " values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getCpf());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getSenha());
			if (ps.executeUpdate() > 0) {
				return user;
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
		String sql = "delete from usuario where cpf_usuario=?";
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
	
	public static Usuario update(Usuario user) {
		String sql = "UPDATE usuario " + "SET nome_usuario=?, email_usuario=?, senha_usuario=?"
				+ "WHERE cpf_usuario=?";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getSenha());
			ps.setString(4, user.getCpf());

			if (ps.executeUpdate() > 0) {
				return user;
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
