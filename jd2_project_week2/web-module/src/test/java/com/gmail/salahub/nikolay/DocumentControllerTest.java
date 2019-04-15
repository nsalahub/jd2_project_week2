package com.gmail.salahub.nikolay;

import com.gmail.salahub.nikolay.jd2_project_week2.controller.DocumentController;
import com.gmail.salahub.nikolay.jd2_project_week2.controller.impl.DocumentControllerImpl;
import com.gmail.salahub.nikolay.jd2_project_week2.service.model.DocumentDTO;
import com.gmail.salahub.nikolay.jd2_project_week2.service.DocumentService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DocumentControllerTest {
//
//    private DocumentController documentController;
//    @Mock
//    private DocumentService documentService;
//
//    @Before
//    public void init() {
//        documentController = new DocumentControllerImpl(documentService);
//    }
//
////    @Test
//    public void shouldAddInDB() {
//        DocumentDTO documentDTO = new DocumentDTO();
//
//        DocumentDTO addDocumentDTO = new DocumentDTO();
//        documentDTO.setId(1L);
//        documentDTO.setDescription("123");
//        documentDTO.setUniqueNumber("123");
//
//        when(documentController.add(addDocumentDTO)).thenReturn(addDocumentDTO);
//        addDocumentDTO = documentController.add(documentDTO);
//
//        Assert.assertEquals(1L,addDocumentDTO.getId().longValue());
//    }
}
