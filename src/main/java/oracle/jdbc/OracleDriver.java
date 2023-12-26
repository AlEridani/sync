package oracle.jdbc;

import org.springframework.boot.autoconfigure.flyway.FlywayProperties;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class OracleDriver implements Driver {

    static{
        try{
            java.sql.DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        if(!acceptsURL(url)){
            return null;
        }
        String username = info.getProperty("user");
        String password = info.getProperty("password");
        // JDBC URL에서 호스트, 포트, SID를 추출
        String[] urlParts = url.split(":");
        String host = urlParts[2].substring(2); // "taichi"
        String port = urlParts[3]; // "1521"
        String sid = urlParts[4]; // "XE"

        // JDBC URL을 사용하여 Oracle 데이터베이스에 연결
        String jdbcUrl = "jdbc:oracle:thin:@" + host + ":" + port + ":" + sid;
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return false;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
