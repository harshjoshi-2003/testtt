package com.conygre.spring.boot.services;

import com.conygre.spring.boot.entities.CompactDisc;
import com.conygre.spring.boot.repos.CompactDiscRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompactDiscServiceTest {

    @Mock
    private CompactDiscRepository repository;

    @InjectMocks
    private CompactDiscServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCatalog() {
        when(repository.findAll()).thenReturn(Arrays.asList(
                new CompactDisc("Album1", 10.99, "Artist1", 10),
                new CompactDisc("Album2", 12.99, "Artist2", 12)
        ));

        Iterable<CompactDisc> catalog = service.getCatalog();
        assertNotNull(catalog);
        assertEquals(2, ((Collection<?>) catalog).size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetCompactDiscById() {
        CompactDisc cd = new CompactDisc("Album1", 10.99, "Artist1", 10);
        cd.setId(1);
        when(repository.findById(1)).thenReturn(Optional.of(cd));

        CompactDisc result = service.getCompactDiscById(1);
        assertNotNull(result);
        assertEquals("Album1", result.getTitle());
        verify(repository, times(1)).findById(1);
    }

    @Test
    void testAddNewCompactDisc() {
        CompactDisc cd = new CompactDisc("Album1", 10.99, "Artist1", 10);
        when(repository.save(any(CompactDisc.class))).thenReturn(cd);

        CompactDisc result = service.addNewCompactDisc(cd);
        assertNotNull(result);
        assertEquals("Album1", result.getTitle());
        verify(repository, times(1)).save(cd);
    }

    @Test
    void testDeleteCompactDiscById() {
        CompactDisc cd = new CompactDisc("Album1", 10.99, "Artist1", 10);
        cd.setId(1);
        when(repository.findById(1)).thenReturn(Optional.of(cd));
        doNothing().when(repository).delete(cd);

        service.deleteCompactDisc(1);
        verify(repository, times(1)).findById(1);
        verify(repository, times(1)).delete(cd);
    }
}
