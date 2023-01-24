package DataBase;

import java.sql.*;

public class DBHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        System.out.println("connect");
        return dbConnection;

    }

    public void inputDataAnimal(String name, String birth, String kind) {
        String insert = "INSERT INTO " +
                kind +
                "(" + Const.USER_NAME + "," + Const.USER_BIRTH + ")"
                + "VALUES(?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setString(2, birth);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String countPerAnimal(String kind) {
        String countCat = null;
        String result = null;

        try {
            Statement statement = getDbConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM " + kind);
            while (rs.next()) {
                result = rs.getString("COUNT(*)");
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
