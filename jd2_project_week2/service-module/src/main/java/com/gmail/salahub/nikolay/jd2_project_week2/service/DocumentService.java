package com.gmail.salahub.nikolay.jd2_project_week2.service;

import com.gmail.salahub.nikolay.jd2_project_week2.service.model.DocumentDTO;
import com.gmil.salahub.nikolay.jd2_project_week2.repository.model.Document;

public interface DocumentService {

    DocumentDTO convertDocumentForAdd (DocumentDTO documentDTO);

    DocumentDTO getDocumentFromDataBase(Long id);

    void deleteDocumentFromDataBase(Long id);
}
