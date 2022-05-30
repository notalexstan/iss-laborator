package repository;

import exceptions.RepoException;
import model.Carte;
import model.Gen;
import model.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBCarteRepo implements IDBCarteRepo{
    private JdbcUtils jdbcUtils;
    private static final Logger logger = LogManager.getLogger();

    public DBCarteRepo(Properties properties) {
        logger.info("Initializing DBCarteRepo with properties: {}", properties);
        jdbcUtils = new JdbcUtils(properties);
    }

    @Override
    public void add(Carte carte) throws RepoException {

    }

    @Override
    public Carte findById(Integer integer) throws RepoException {
        return null;
    }

    @Override
    public void modify(Carte carte) throws RepoException {

    }

    @Override
    public void delete(Integer integer) throws RepoException {

    }

    @Override
    public List<Carte> getAll() {
        logger.traceEntry();
        Connection con = jdbcUtils.getConnection();
        List<Carte> carti = new ArrayList<>();
        try (PreparedStatement preparedStatement = con.prepareStatement("select * from carti")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String titlu = resultSet.getString("titlu");
                    String autor = resultSet.getString("autor");
                    Gen gen = Gen.valueOf(resultSet.getString("gen"));
                    String isbm = resultSet.getString("isbm");
                    Status status = Status.valueOf(resultSet.getString("status"));

                    Carte carte = new Carte(id,titlu,autor,gen,isbm,status);
                    carti.add(carte);

                }
            }
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);

        }
        logger.traceExit(carti);
        return carti;
    }

    @Override
    public int size() {
        return 0;
    }
}
