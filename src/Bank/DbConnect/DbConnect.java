package Bank.DbConnect;

import java.sql.*;

public class DbConnect {
    private Connection connection = null;

    private static final String DB_USER = "postgres";
    private static final String DB_PASS = "hola1213";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/bank";

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        } catch (Exception e) {
            System.err.print(e.getMessage() + "");
        }
    }

    public int execute(String sentence){
        try{
            PreparedStatement pstm = connection.prepareStatement(sentence);
            pstm.execute();
            return 1;
        } catch(SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    public ResultSet get(String sentence){
        try {
            PreparedStatement pstm = connection.prepareStatement(sentence);
            return pstm.executeQuery();
        } catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }
}
