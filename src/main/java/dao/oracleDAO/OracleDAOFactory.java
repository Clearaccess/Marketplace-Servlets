package dao.oracleDAO;

import dao.BidDAO;
import dao.DAOFactory;
import dao.ItemDAO;
import dao.UserDAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Aleksandr_Vaniukov on 1/17/2017.
 */
public class OracleDAOFactory extends DAOFactory {

    /*private static final String DB_DRIVER="oracle.jdbc.OracleDriver";
    private static final String DB_URL="jdbc:oracle:thin:@localhost:1521/xe";
    private static final String DB_USER="ALEXANDER";
    private static final String DB_PASSWORD="440276";

    static{
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    private static DataSource dataSource;

    public synchronized static Connection createConnection() throws SQLException, NamingException {
        if(dataSource==null) {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/myoracle");
        }

        Connection conn = dataSource.getConnection();
        return conn;
    }

    public UserDAO getUserDAO(){
        return new OracleUserDAO();
    }

    public ItemDAO getItemDAO(){
        return new OracleItemDAO();
    }

    public BidDAO getBidDAO(){
        return new OracleBidDAO();
    }
}
