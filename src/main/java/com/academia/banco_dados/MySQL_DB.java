package com.academia.banco_dados;

import java.sql.*;

import com.academia.exercicios.Exercicio;
import com.academia.exercicios.Treino;
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
    private String sqlString;


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
    public String get_treino(String id) {
        return "";
    }

    @Override
    public String get_exercicio(String id) {
        return "";
    }

    @Override
    public Aluno get_aluno(String login) throws SQLException {

        this.sqlString = "SELECT DISTINCT * FROM aluno WHERE id_aluno = ?";
        PreparedStatement statement = connection.prepareStatement(this.sqlString);
        statement.setString(1, login);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            return new Aluno(
                    resultSet.getString("id_aluno"),
                    resultSet.getString("nome_aluno"),
                    resultSet.getString("cpf_aluno"),
                    resultSet.getString("telefone_aluno"),
                    resultSet.getString("Email_aluno"),
                    resultSet.getBoolean("status_aluno"),
                    resultSet.getDate("data_nascimento_aluno"),
                    resultSet.getDate("data_inscricao"),
                    resultSet.getString("senha_aluno"),
                    resultSet.getString("genero_aluno"),
                    resultSet.getString("id_plano")
            );
        }
        return null;
    }

    public boolean teste_aluno() throws SQLException {

        this.sqlString = "SELECT DISTINCT id_aluno FROM aluno";
        PreparedStatement statement = connection.prepareStatement(this.sqlString);
        ResultSet resultSet = statement.executeQuery();

        return resultSet.next();
    }

    public String cria_login() throws SQLException {
        this.sqlString =
                "SELECT id_aluno\n" +
                "FROM aluno\n" +
                "ORDER BY id_aluno DESC\n" +
                "LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(this.sqlString);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            return resultSet.getString("id_aluno");
        }
        return null;
    }

    @Override
    public void cadastrar_aluno(Aluno aluno) {
        this.sqlString = "insert into aluno(id_aluno, nome_aluno, cpf_aluno, telefone_aluno, Email_aluno, status_aluno,\n" +
                "                  data_nascimento_aluno, data_inscricao, senha_aluno, genero_aluno, id_plano)\n" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlString)) {

            // Set parameters
            preparedStatement.setString(1, aluno.getLogin());
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setString(3, aluno.getCpf());
            preparedStatement.setString(4, aluno.getTelefone());
            preparedStatement.setString(5, aluno.getEmail());
            preparedStatement.setBoolean(6, aluno.getStatus());
            preparedStatement.setDate(7, aluno.getData_nascimento());
            preparedStatement.setDate(8, aluno.getData_matricula());
            preparedStatement.setString(9, aluno.getSenha());
            preparedStatement.setString(10, aluno.getGenero());
            preparedStatement.setString(11, aluno.getPlano());


            // Execute the insert command
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s) into the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void cadastrar_exercicio(Exercicio exercicio) {

        this.sqlString =
                "INSERT INTO exercicio (\n" +
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
             PreparedStatement stmt = connection.prepareStatement(this.sqlString)) {

            // Set parameters
            stmt.setString(1, exercicio.getId());
            stmt.setString(2, exercicio.getNome());
            stmt.setString(3, exercicio.getCategoria());
            stmt.setString(4, exercicio.getMaquina());
            stmt.setString(5, exercicio.getDescricao());

            // Execute the insert command
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s) into the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void cadastrar_treino(Treino treino) {

    }


    @Override
    public void editar_aluno(String login) {

    }

    @Override
    public void excluir_aluno(String login) {

    }

    @Override
    public void excluir_exercicio(String id) {
        this.sqlString = "DELETE FROM exercicio WHERE id_exercicio = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(this.sqlString)) {

            stmt.setString(1, id);
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Linhas excluídas: " + rowsAffected);

        } catch (SQLException e) {
            System.out.println("Erro ao excluir dados: " + e.getMessage());
        }
    }


    @Override
    public void excluir_treino(String id) {

    }
}
