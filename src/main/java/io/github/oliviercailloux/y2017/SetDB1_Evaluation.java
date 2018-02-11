package io.github.oliviercailloux.y2017;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SetDB1_Evaluation {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    // Methods allow to read & write from the BD Evaluation
    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/xmcda?"
                            + "user=sqluser&password=sqluserpw");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from xmcda.evaluation");
            writeResultSet(resultSet);
            
         // Statements allow to write from the BD Evaluation
            preparedStatement = connect
                    .prepareStatement("insert into  xmcda.evaluation values (?,?,?,?)");
            preparedStatement.setString(1, "Insert_Id_Eval");
            preparedStatement.setString(2, "Insert_Evaluation_Alternative");
            preparedStatement.setString(3, "Insert_Evaluation_Criterion");
            preparedStatement.setDouble(4, 16.5);
            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT id, alternative, criterion, value_eval from xmcda.evaluation");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);
            
            // Remove again the insert comment
            preparedStatement = connect
            .prepareStatement("delete from xmcda.evaluation where id= ? ; ");
            preparedStatement.setString(1, "Insert_Id_Eval");
            preparedStatement.executeUpdate();

            
          } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
        private void writeResultSet(ResultSet resultSet) throws SQLException {
            // ResultSet is initially before the first data set
            while (resultSet.next()) {
            	String id = resultSet.getString("id");
                String alt = resultSet.getString("alternative");
                String crit = resultSet.getString("criterion");
                double value = resultSet.getDouble("value_eval");
                System.out.println("Evaluation Id: " + id);
                System.out.println("Evaluation Alt: " + alt);
                System.out.println("Evaluation Crit: " + crit);
                System.out.println("Evaluation Value: " + value);
            }
        }
        // To close the resultSet
        private void close() {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {
            }
        }
    }