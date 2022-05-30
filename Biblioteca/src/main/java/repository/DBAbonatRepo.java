package repository;

import exceptions.RepoException;
import model.Abonat;
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

public class DBAbonatRepo implements IDBAbonatRepo {

    private JdbcUtils jdbcUtils;
    private static final Logger logger = LogManager.getLogger();

    public DBAbonatRepo(Properties properties) {
        logger.info("Initializing DBAbonatRepo with properties: {}", properties);
        jdbcUtils = new JdbcUtils(properties);
    }


    @Override
    public void add(Abonat abonat) throws RepoException {
        logger.traceEntry("saving task {} ", abonat);
        Connection con = jdbcUtils.getConnection();
        try (PreparedStatement preparedStatement = con.prepareStatement("insert into abonati (mail, password, cnp, nume) values (?,?,?,?)"))
        {
            preparedStatement.setString(1, abonat.getMail());
            preparedStatement.setString(2, abonat.getPassword());
            preparedStatement.setString(3, abonat.getCnp());
            preparedStatement.setString(4, abonat.getNume());
            int result = preparedStatement.executeUpdate();
            logger.trace("Saved {} instances", result);
        }
        catch (SQLException ex)
        {
            logger.error(ex);
            System.err.println("Error DB " + ex);

        }
        logger.traceExit();
    }

    @Override
    public Abonat findById(Integer integer) throws RepoException {
        logger.traceEntry("find task {}", integer);
        Connection con = jdbcUtils.getConnection();
        Abonat abonat = new Abonat();
        try (PreparedStatement preparedStatement = con.prepareStatement("select * from abonati where id = ? "))
        {
            preparedStatement.setInt(1,integer);
            try(ResultSet resultSet = preparedStatement.executeQuery())
            {
                while(resultSet.next())
                {
                    String mail = resultSet.getString("mail");
                    String password = resultSet.getString("password");
                    String cnp = resultSet.getString("cnp");
                    String nume = resultSet.getString("nume");
                    int id = resultSet.getInt("id");

                    abonat = new Abonat(id,cnp,nume,mail,password);
                    logger.trace("found {} instance", abonat);
                }
            }
        }
        catch (SQLException ex)
        {
            logger.error(ex);
            System.err.println("Error DB " + ex);

        }
        logger.traceExit(abonat);
        return abonat;
    }

    @Override
    public void modify(Abonat abonat) throws RepoException {

    }

    @Override
    public void delete(Integer integer) throws RepoException {

    }

    @Override
    public List<Abonat> getAll() {
        logger.traceEntry();
        Connection con = jdbcUtils.getConnection();
        List<Abonat> abonati = new ArrayList<>();
        try (PreparedStatement preparedStatement = con.prepareStatement("select * from abonati")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String mail = resultSet.getString("mail");
                    String password = resultSet.getString("password");
                    String cnp = resultSet.getString("cnp");
                    String nume = resultSet.getString("nume");

                    Abonat abonat = new Abonat(id, cnp, nume, mail, password);
                    abonati.add(abonat);

                }
            }
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);

        }
        logger.traceExit(abonati);
        return abonati;
    }

    @Override
    public int size() {
        logger.traceEntry("size");
        Connection con = jdbcUtils.getConnection();
        int size = 0;
        try (PreparedStatement preparedStatement = con.prepareStatement("select count(*) as count from abonati")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                size = resultSet.getInt("count");
            }
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);

        }
        logger.traceExit(size);
        return size;
    }
}
