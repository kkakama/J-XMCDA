package io.github.oliviercailloux.y2017;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SetDB1_AlternativeTree {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

 // Methods allow to read & write from the BD alternatives
    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/xmcda?"
                            + "user=sqluser&password=sqluserpw");

            // Statements  allow to read from the BD alternatives
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from xmcda.alternativetree");
            writeResultSet(resultSet);
            
            // Statements allow to write from the BD alternatives
            preparedStatement = connect
                    .prepareStatement("insert into  xmcda.alternativetree values (?,?)");
            preparedStatement.setString(1, "Insert_Id_Alttre");
            preparedStatement.setString(2, "Insert_Name");
            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT id, name_alttree from xmcda.alternativetree");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);
            
            // Remove again the insert comment
            preparedStatement = connect
            .prepareStatement("delete from xmcda.alternativeTree where id= ? ; ");
            preparedStatement.setString(1, "Insert_Id_Alttre");
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
                String name = resultSet.getString("name_altTree");
                System.out.println("AlternativeTree Id: " + id);
                System.out.println("AlternativeTree Name: " + name);
            }
        }

        // to close the resultSet
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