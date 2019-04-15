package com.gmail.salahub.nikolay.jd2_project_week2.service.converter.impl;

import com.gmail.salahub.nikolay.jd2_project_week2.service.converter.DocumentConverter;
import com.gmail.salahub.nikolay.jd2_project_week2.service.model.DocumentDTO;
import com.gmil.salahub.nikolay.jd2_project_week2.repository.model.Document;
import org.springframework.stereotype.Component;

@Component
public class DocumentConverterImpl implements DocumentConverter {

    @Override
    public Document fromDTO(DocumentDTO documentDTO) {
        Document document = new Document();
        document.setId(documentDTO.getId());
        document.setUniqueNumber(documentDTO.getUniqueNumber());
        document.setDescription(documentDTO.getDescription());
        return document;
    }

    @Override
    public DocumentDTO toDTO(Document document) {
        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setId(document.getId());
        documentDTO.setDescription(document.getDescription());
        documentDTO.setUniqueNumber(document.getUniqueNumber());
        return documentDTO;
    }
}
