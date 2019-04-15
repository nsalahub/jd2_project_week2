package com.gmil.salahub.nikolay.jd2_project_week2.repository.impl;

import com.gmil.salahub.nikolay.jd2_project_week2.repository.DocumentRepository;
import com.gmil.salahub.nikolay.jd2_project_week2.repository.connection.ConnectionHandler;
import com.gmil.salahub.nikolay.jd2_project_week2.repository.exception.DatabaseException;
import com.gmil.salahub.nikolay.jd2_project_week2.repository.model.Document;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class DocumentRepositoryImpl implements DocumentRepository {

    ConnectionHandler connectionHandler;

    private final Logger logger = LogManager.getLogger(DocumentRepositoryImpl.class);

    private DocumentRepositoryImpl(ConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;
    }


    @Override
    public Document insertDocumentInDB(Document document) {
        try (Connection connection = connectionHandler.getConnection()) {
            String query = "INSERT INTO DOCUMENTS VALUES(NULL ,?,?,false)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, document.getUniqueNumber());
                preparedStatement.setString(2, document.getDescription());
                preparedStatement.execute();
                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        document.setId(rs.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            throw new DatabaseException("Database exception during inserting document", e);

        }
        return document;
    }


    @Override
    public Document getDocumentByIdFromDB(Long id) {
        Document document = new Document();
        try (Connection connection = connectionHandler.getConnection()) {
            String query = "SELECT id, unique_number, `description` FROM documents WHERE id = ? AND deleted= false ;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        document = getDocumentFromDataBase(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            throw new DatabaseException("Database exception during getting document from database", e);
        }
        return document;
    }

    @Override
    public void deleteDocumentInDB(Long id) {
        try (Connection connection = connectionHandler.getConnection()) {
            String query = "UPDATE DOCUMENTS SET DELETED = true WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setLong(1, id);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            throw new DatabaseException("Database exception during deleted document from database", e);
        }
    }

    private Document getDocumentFromDataBase(ResultSet resultSet) throws SQLException {
        Document document = new Document();
        document.setId(resultSet.getLong("id"));
        document.setDescription(resultSet.getString("description"));
        document.setUniqueNumber(resultSet.getString("unique_number"));
        return document;
    }

}
