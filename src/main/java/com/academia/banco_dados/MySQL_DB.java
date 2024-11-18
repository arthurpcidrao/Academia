package com.academia.banco_dados;

import java.sql.*;

import com.academia.pessoas.Aluno;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MySQL_DB implements AdapterDB{

    private String url;
    private String user;
    private String password;
    private Connection connection;
    private String insertSQL;


    public MySQL_DB() throws SQLException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/academia/banco_dados/GerencialBD.json"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            JSONObject jsonObject = new JSONObject(content.toString());
            this.url = jsonObject.getString("url");
            this.user = jsonObject.getString("user");
            this.password = jsonObject.getString("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(this.url, this.user, this.password);
    }

    /*
    private void desconectar() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected from MySQL database.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    */

    @Override
    public String get_treino() {
        return "";
    }

    @Override
    public String get_exercicio() {
        return "";
    }

    @Override
    public Aluno get_aluno(String email) {
        Aluno aluno = null;
        return aluno;
    }

    @Override
    public void cadastrar_aluno(Aluno aluno) {
        this.insertSQL = "INSERT INTO aluno (primeiro_nome_aluno, cpf_aluno, Email_aluno) VALUES (?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement preparedStatement = conn.prepareStatement(insertSQL)) {

            // Set parameters
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setString(2, aluno.getCpf());
            preparedStatement.setString(3, aluno.getEmail());

            // Execute the insert command
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s) into the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void cadastrar_exercicio(String id, String nome, String categoria, String maquina, String descricao) {

        this.insertSQL = "INSERT INTO exercicio (\n" +
                "    id_exercicio,\n" +
                "    nome_exercicio,\n" +
                "    tipo_exercicio,\n" +
                "    maquina_exercicio,\n" +
                "    descricao_exercicio\n" +
                ") VALUES (\n" +
                "    ?,\n" +
                "    ?,\n" +
                "    ?,\n" +
                "    ?,\n" +
                "    ?,\n" +
                ");\n";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = connection.prepareStatement(this.insertSQL)) {

            // Set parameters
            stmt.setString(1, id);
            stmt.setString(2, nome);
            stmt.setString(3, categoria);
            stmt.setString(4, maquina);
            stmt.setString(5, descricao);

            // Execute the insert command
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s) into the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void cadastrar_treino() {

    }

    @Override
    public void editar_aluno() {

    }

    @Override
    public void excluir_aluno() {

    }

    @Override
    public void excluir_exercicio(String id) {
        this.insertSQL = "DELETE FROM exercicio WHERE id_exercicio = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(this.insertSQL)) {

            stmt.setString(1, id);
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Linhas excluídas: " + rowsAffected);

        } catch (SQLException e) {
            System.out.println("Erro ao excluir dados: " + e.getMessage());
        }
    }


    @Override
    public void excluir_treino() {

    }
}
