package org.mdh.pmm.references.infrastructure.controller;

import org.junit.jupiter.api.Test;
import org.mdh.pmm.references.pmmref.infrastructure.controller.ReferenceDataController;
import org.mdh.pmm.references.pmmref.usecase.ReferenceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mdh.pmm.references.constants.Paths.BASE_PATH;
import static org.mdh.pmm.references.constants.Paths.REFERENCE_DATA_PATH;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReferenceDataController.class)
public class ReferenceDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReferenceDataService referenceDataService;

    @Test
    void getDropdownData_ShouldReturnOk_WhenCategoryIsUnknown() throws Exception {
        when(referenceDataService.getDataByCategory("Unknown")).thenReturn(Collections.emptyList());

        mockMvc.perform(get(BASE_PATH + REFERENCE_DATA_PATH)
                        .param("category", "Unknown")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty()); // checks if the response body is an empty array
    }
}
