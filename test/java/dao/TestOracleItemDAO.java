package dao;

import dao.oracleDAO.OracleDAOFactory;
import dao.oracleDAO.OracleItemDAO;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.fail;

/**
 * Created by Aleksandr_Vaniukov on 2/15/2017.
 */
public class TestOracleItemDAO {
    @Test
    public void getConnect() {
        DAOFactory oracleDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE);
        ItemDAO itemDAO = oracleDAO.getItemDAO();
        itemDAO.getAll();
    }
}
