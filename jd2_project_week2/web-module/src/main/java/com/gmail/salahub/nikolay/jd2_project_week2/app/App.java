package com.gmail.salahub.nikolay.jd2_project_week2.app;

import com.gmail.salahub.nikolay.jd2_project_week2.config.AppConfig;
import com.gmail.salahub.nikolay.jd2_project_week2.controller.DocumentController;
import com.gmail.salahub.nikolay.jd2_project_week2.service.model.DocumentDTO;
import com.gmil.salahub.nikolay.jd2_project_week2.repository.model.Document;
import com.gmil.salahub.nikolay.jd2_project_week2.repository.properties.DatabaseProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.UUID;


public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        UUID uuid = UUID.randomUUID();

        DocumentController documentController = ctx.getBean(DocumentController.class);
        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setDescription("description1");
        documentDTO.setUniqueNumber(uuid.toString());
        documentDTO = documentController.add(documentDTO);
        logger.info(documentDTO.getId());

        DocumentDTO deleteDocumentDto = new DocumentDTO();
        deleteDocumentDto.setDescription("description2");
        deleteDocumentDto.setUniqueNumber(uuid.toString());
        deleteDocumentDto = documentController.add(deleteDocumentDto);
        documentController.delete(deleteDocumentDto.getId());
        logger.info(deleteDocumentDto.getId());


        DocumentDTO resultDTO = documentController.getDocumentById(1L);
        logger.info(resultDTO.getDescription());
        logger.info(resultDTO.getUniqueNumber());

    }
}
