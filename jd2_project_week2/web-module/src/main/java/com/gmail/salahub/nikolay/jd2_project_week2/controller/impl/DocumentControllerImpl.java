package com.gmail.salahub.nikolay.jd2_project_week2.controller.impl;

import com.gmail.salahub.nikolay.jd2_project_week2.controller.DocumentController;
import com.gmail.salahub.nikolay.jd2_project_week2.service.model.DocumentDTO;
import com.gmail.salahub.nikolay.jd2_project_week2.service.DocumentService;
import org.springframework.stereotype.Component;

@Component
public class DocumentControllerImpl implements DocumentController {

    DocumentService documentService;

    public DocumentControllerImpl(DocumentService documentService) {
        this.documentService = documentService;
    }

    @Override
    public DocumentDTO add(DocumentDTO documentDTO) {
        return documentService.convertDocumentForAdd(documentDTO);
    }

    @Override
    public DocumentDTO getDocumentById(Long id) {
        return documentService.getDocumentFromDataBase(id);

    }

    @Override
    public void delete(Long id) {
        documentService.deleteDocumentFromDataBase(id);
    }
}
