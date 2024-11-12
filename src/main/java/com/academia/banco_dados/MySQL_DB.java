package com.academia.banco_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public int numero_funcionarios(){

        return 0;
    }

    @Override
    public String get_treino() {
        return "";
    }

    @Override
    public String get_exercicio() {
        return "";
    }

    @Override
    public String get_funcionario() {
        return "";
    }

    @Override
    public String get_aluno() {
        return "";
    }

    @Override
    public String get_cadastro() {
        return "";
    }

    @Override
    public void cadastrar_funcionario() {

    }

    @Override
    public void cadastrar_aluno(String nome, String cpf, String email) {
        this.insertSQL = "INSERT INTO aluno (primeiro_nome_aluno, cpf_aluno, Email_aluno) VALUES (?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement preparedStatement = conn.prepareStatement(insertSQL)) {

            // Set parameters
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cpf);
            preparedStatement.setString(3, email);

            // Execute the insert command
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s) into the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void cadastrar_exercicio(String id, String nome, String categoria, String maquina, int serie,
                                    int repeticoes, int tempo) {

        this.insertSQL = "INSERT INTO exercicio (\n" +
                "    id_exercicio,\n" +
                "    nome_exercicio,\n" +
                "    tipo_exercicio,\n" +
                "    maquina_exercicio,\n" +
                "    serie_exercicio,\n" +
                "    repeticoes_exercicio,\n" +
                "    tempo_exercicio\n" +
                ") VALUES (\n" +
                "    ?,\n" +
                "    ?,\n" +
                "    ?,\n" +
                "    ?,\n" +
                "    ?,\n" +
                "    ?,\n" +
                "    ? \n" +
                ");\n";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = connection.prepareStatement(this.insertSQL)) {

            // Set parameters
            stmt.setString(1, id);
            stmt.setString(2, nome);
            stmt.setString(3, categoria);
            stmt.setString(4, maquina);
            stmt.setInt(5, serie);
            stmt.setInt(6, repeticoes);
            stmt.setInt(7, tempo);

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
    public void editar_status_funcionario() {

    }

    @Override
    public void editar_status_aluno() {

    }

    @Override
    public void editar_status_atendente() {

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
    public void excluir_funcionario() {

    }

    @Override
    public void excluir_treino() {

    }
}
