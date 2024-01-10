package org.mdh.pmm.references.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mdh.pmm.references.pmmref.domain.exception.DataNotFoundException;
import org.mdh.pmm.references.pmmref.domain.repo.ReferenceRepo;
import org.mdh.pmm.references.pmmref.usecase.ReferenceDataServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReferenceDataServiceImplTest {

    @Mock
    private ReferenceRepo personRepo;

    @InjectMocks
    private ReferenceDataServiceImpl service;

    @Test
    void getDataByCategory_DataNotFoundException_WhenNoDataFound() {
        when(personRepo.findByCategory("Unknown")).thenReturn(Collections.emptyList());

        assertThrows(DataNotFoundException.class, () -> service.getDataByCategory("Unknown"));
    }
}
