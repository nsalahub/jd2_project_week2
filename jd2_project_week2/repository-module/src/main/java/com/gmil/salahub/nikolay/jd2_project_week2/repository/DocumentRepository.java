package com.gmil.salahub.nikolay.jd2_project_week2.repository;

import com.gmil.salahub.nikolay.jd2_project_week2.repository.model.Document;

public interface DocumentRepository {

    Document insertDocumentInDB(Document document);

    Document getDocumentByIdFromDB(Long id);

    void deleteDocumentInDB(Long id);
}
