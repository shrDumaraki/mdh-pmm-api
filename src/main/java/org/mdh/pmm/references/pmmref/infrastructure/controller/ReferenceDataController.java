package org.mdh.pmm.references.pmmref.infrastructure.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mdh.pmm.references.pmmref.domain.model.ReferenceData;
import org.mdh.pmm.references.pmmref.usecase.ReferenceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.mdh.pmm.references.constants.Paths.BASE_PATH;
import static org.mdh.pmm.references.constants.Paths.REFERENCE_DATA_PATH;




@RestController
@RequestMapping(BASE_PATH)
// base_path=/mdh/pmm/v1/api/referencedata
@AllArgsConstructor
@Slf4j
@ConditionalOnProperty(value = "spring.profiles.active", havingValue = "pmmref")
public class ReferenceDataController {

    private final ReferenceDataService referenceDataService;



    /**
     * Handles GET requests to retrieve dropdown data by category. Returns data in JSON format.
     * Logs the request details and returns the response entity with the appropriate HTTP status.
     *
     * @param category The category to retrieve the reference data.
     * @return ResponseEntity containing the list of reference data or an error message.
     */
    @GetMapping(REFERENCE_DATA_PATH)
    // REFERENCE_DATA_PATH=/retrieveinfo
    public ResponseEntity<List<ReferenceData>> getDropdownData(@RequestParam String category) {
        log.info("Received request for dropdown data with category: {}", category);
        return ResponseEntity.ok(referenceDataService.getDataByCategory(category));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReferenceData>> getAllReferenceData() {
        log.info("Received request for all reference data");
        List<ReferenceData> allData = referenceDataService.getAllReferenceData();
        return ResponseEntity.ok(allData);
    }

    @Autowired
    private ObjectMapper objectMapper;  // Autowire ObjectMapper

    @GetMapping("/categories")
    public ResponseEntity<JsonNode> getAllCategories() {
        List<ReferenceData> allReferenceData = referenceDataService.getAllReferenceData();

        // Extract unique categories
        List<String> categories = allReferenceData.stream()
                .map(ReferenceData::getCategory)
                .distinct()
                .collect(Collectors.toList());

        // Create a JSON node with categories and their key-value pairs
        JsonNode categoriesNode = objectMapper.createObjectNode();
        for (String category : categories) {
            Map<String, String> categoryValues = allReferenceData.stream()
                    .filter(data -> category.equals(data.getCategory()))
                    .collect(Collectors.toMap(ReferenceData::getDescription, ReferenceData::getValue));

            ((ObjectNode) categoriesNode).putPOJO(category, categoryValues);
        }

        return ResponseEntity.ok(categoriesNode);
    }

}
