package com.gmail.salahub.nikolay.jd2_project_week2.controller;

import com.gmail.salahub.nikolay.jd2_project_week2.service.model.DocumentDTO;

public interface DocumentController {

    DocumentDTO add(DocumentDTO documentDTO);

    DocumentDTO getDocumentById(Long id);

    void delete(Long id);

}
