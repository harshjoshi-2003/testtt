package com.conygre.spring.boot.rest;

import com.conygre.spring.boot.entities.CompactDisc;
import com.conygre.spring.boot.services.CompactDiscService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompactDiscControllerTest {

    @Mock
    private CompactDiscService service;

    @InjectMocks
    private CompactDiscController controller;

    @Test
    void testFindAll() {
        when(service.getCatalog()).thenReturn(Arrays.asList(
                new CompactDisc("Album1", 10.99, "Artist1", 10),
                new CompactDisc("Album2", 12.99, "Artist2", 12)
        ));

        Iterable<CompactDisc> result = controller.findAll();
        assertNotNull(result);
        verify(service, times(1)).getCatalog();
    }

    @Test
    void testGetCdById() {
        CompactDisc cd = new CompactDisc("Album1", 10.99, "Artist1", 10);
        when(service.getCompactDiscById(1)).thenReturn(cd);

        CompactDisc result = controller.getCdById(1);
        assertNotNull(result);
        assertEquals("Album1", result.getTitle());
        verify(service, times(1)).getCompactDiscById(1);
    }

    @Test
    void testAddCd() {
        CompactDisc cd = new CompactDisc("Album1", 10.99, "Artist1", 10);
        doNothing().when(service).addNewCompactDisc(cd);

        controller.addCd(cd);
        verify(service, times(1)).addNewCompactDisc(cd);
    }

    @Test
    void testDeleteCdById() {
        doNothing().when(service).deleteCompactDisc(1);

        controller.deleteCd(1);
        verify(service, times(1)).deleteCompactDisc(1);
    }
}
