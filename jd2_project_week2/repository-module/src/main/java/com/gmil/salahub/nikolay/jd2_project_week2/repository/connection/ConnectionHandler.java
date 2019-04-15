package com.gmil.salahub.nikolay.jd2_project_week2.repository.connection;

import com.gmil.salahub.nikolay.jd2_project_week2.repository.exception.DatabaseException;
import com.gmil.salahub.nikolay.jd2_project_week2.repository.properties.DatabaseProperties;
import com.gmil.salahub.nikolay.jd2_project_week2.repository.util.MassageRepositoryUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@Component
public class ConnectionHandler {

    private Logger logger = LogManager.getLogger(ConnectionHandler.class);
    private final DatabaseProperties databaseProperties;

    @Autowired
    public ConnectionHandler(DatabaseProperties databaseProperties) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage(), e);
        }
        this.databaseProperties = databaseProperties;
    }

    public Connection getConnection() {
        logger.info("Creating connection...");
        try {
            Properties properties = new Properties();
            properties.setProperty("user", databaseProperties.getUsername());
            properties.setProperty("password", databaseProperties.getPassword());
            properties.setProperty("userUnicode", "true");
            properties.setProperty("characterEncoding", "cp1251");
            properties.setProperty("useJDBCompliantTimezoneShift", "true");
            properties.setProperty("useLegacyDatetimeCode", "false");
            properties.setProperty("serverTimezone", "UTC");
            Connection connection = DriverManager.getConnection(databaseProperties.getUrl(), properties);
            logger.info(MassageRepositoryUtil.SUCCESS_CREATED_MASSAGE);
            return connection;
        } catch (SQLException e) {
            logger.error(MassageRepositoryUtil.ERROR_MESSAGE, e);
            throw new DatabaseException(MassageRepositoryUtil.ERROR_MESSAGE);
        }
    }

    @PostConstruct
    public void createDatabaseTables() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS DOCUMENTS(ID BIGINT auto_increment PRIMARY KEY," +
                " unique_number VARCHAR(100) , `description` VARCHAR (100), DELETED BOOLEAN DEFAULT FALSE NOT NULL); ";
        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);
            try (Statement statement = connection.createStatement()) {
                statement.execute(createTableQuery);
                connection.commit();
            } catch (Exception e) {
                connection.rollback();
            }
        } catch (SQLException e) {
            logger.error(MassageRepositoryUtil.ERROR_MESSAGE, e);
            throw new DatabaseException(MassageRepositoryUtil.ERROR_MESSAGE);
        }

    }
}