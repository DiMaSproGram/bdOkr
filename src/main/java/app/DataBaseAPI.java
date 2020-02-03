package app;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseAPI {
    private static DataBaseAPI init;
//    public static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=OKR;integratedSecurity=true";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/okr";
    private static final String USER = "root";
    private static final String PASS = "1111";

    private Connection connection;
    private Statement stmt;

    private DataBaseAPI() throws ClassNotFoundException, SQLException {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = connection.createStatement();
    }
    public static DataBaseAPI getDataBaseAPI()  {
        if(init == null) {
            try {
                init = new DataBaseAPI();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return init;
    }
    public ArrayList<BelRegion> getRegions() throws SQLException {
        ResultSet resultSet;
        ArrayList<BelRegion> list = new ArrayList<BelRegion>();
        PreparedStatement prepStat = connection.prepareStatement("SELECT * FROM okr.belRegions");
        resultSet = prepStat.executeQuery("SELECT * FROM okr.belRegions");
        while (resultSet.next()) {
            list.add(new BelRegion(resultSet.getInt("id_belRegions"), resultSet.getString("regionName"), resultSet.getString("regionCenterName"),
                    resultSet.getDouble("area"), resultSet.getDouble("popul"))
            );
        }
        prepStat.execute();
        prepStat.close();
        return list;
    }
    public void delete(Integer id) throws SQLException {
        PreparedStatement prepStat;
        prepStat = connection.prepareStatement("DELETE FROM okr.belRegions where id_belRegions =" + id.toString());
        prepStat.execute();
        prepStat.close();
    }
    public void add(String region, String regionCenter, Double area, Double popul) throws SQLException {
        PreparedStatement prepStat = connection.prepareStatement("INSERT INTO okr.belRegions (regionName, regionCenterName, area, popul) VALUES (?, ?, ?, ?)");
        prepStat.setString(1, region);
        prepStat.setString(2, regionCenter);
        prepStat.setDouble(3, area);
        prepStat.setDouble(4, popul);
        prepStat.execute();
        prepStat.close();
    }
    public ArrayList<BelRegion> findByArea(Double area) throws SQLException {
        ResultSet resultSet;
        ArrayList<BelRegion> list = new ArrayList<BelRegion>();
        PreparedStatement prepStat = connection.prepareStatement("SELECT * FROM okr.belRegions WHERE area =" + area.toString());
        resultSet = prepStat.executeQuery("SELECT * FROM okr.belRegions WHERE area =" + area.toString());
        while (resultSet.next()) {
            list.add(new BelRegion(resultSet.getInt("id_belRegions"), resultSet.getString("regionName"), resultSet.getString("regionCenterName"),
                    resultSet.getDouble("area"), resultSet.getDouble("popul"))
            );
        }
        prepStat.execute();
        prepStat.close();
        return list;
    }
}
