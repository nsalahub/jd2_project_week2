package com.gmail.salahub.nikolay.jd2_project_week2.service.converter;

import com.gmail.salahub.nikolay.jd2_project_week2.service.model.DocumentDTO;
import com.gmil.salahub.nikolay.jd2_project_week2.repository.model.Document;

public interface DocumentConverter {

    Document fromDTO(DocumentDTO documentDTO);

    DocumentDTO toDTO(Document document);
}
