package com.gmail.salahub.nikolay.jd2_project_week2.service.impl;

import com.gmail.salahub.nikolay.jd2_project_week2.service.DocumentService;
import com.gmail.salahub.nikolay.jd2_project_week2.service.converter.DocumentConverter;
import com.gmail.salahub.nikolay.jd2_project_week2.service.model.DocumentDTO;
import com.gmil.salahub.nikolay.jd2_project_week2.repository.DocumentRepository;
import com.gmil.salahub.nikolay.jd2_project_week2.repository.exception.DatabaseException;
import com.gmil.salahub.nikolay.jd2_project_week2.repository.model.Document;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {

    DocumentRepository documentRepository;
    DocumentConverter documentConverter;

    private final Logger logger = LogManager.getLogger(DocumentServiceImpl.class);

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository, DocumentConverter documentConverter) {
        this.documentRepository = documentRepository;
        this.documentConverter = documentConverter;
    }


    @Override
    public DocumentDTO convertDocumentForAdd(DocumentDTO documentDTO) {
        Document document = null;
        try {
            document = documentRepository.insertDocumentInDB(documentConverter.fromDTO(documentDTO));
        }
        catch (DatabaseException e){
            logger.error(e.getMessage(),e);
        }
        return documentConverter.toDTO(document);
    }

    @Override
    public DocumentDTO getDocumentFromDataBase(Long id) {
        DocumentDTO documentDTO = new DocumentDTO();
        try {
            documentDTO = documentConverter.toDTO(documentRepository.getDocumentByIdFromDB(id));
        } catch (DatabaseException e) {
            logger.error(e.getMessage(), e);
        }
        return documentDTO;
    }

    @Override
    public void deleteDocumentFromDataBase(Long id) {
        try {
            documentRepository.deleteDocumentInDB(id);
        } catch (DatabaseException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
