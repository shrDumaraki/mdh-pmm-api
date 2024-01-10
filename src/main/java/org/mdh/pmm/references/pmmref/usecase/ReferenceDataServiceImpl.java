package org.mdh.pmm.references.pmmref.usecase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mdh.pmm.references.pmmref.domain.exception.DataNotFoundException;
import org.mdh.pmm.references.pmmref.domain.exception.ServerException;
import org.mdh.pmm.references.pmmref.domain.model.ReferenceData;
import org.mdh.pmm.references.pmmref.domain.repo.ReferenceRepo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This service class provides the business logic for handling reference data.
 */
@Service
@Slf4j
@AllArgsConstructor
@ConditionalOnProperty(value = "spring.profiles.active", havingValue = "pmmref")
public class ReferenceDataServiceImpl implements ReferenceDataService {

    private final ReferenceRepo referenceRepo;

    /**
     * Retrieves a list of reference data filtered by the provided category.
     * If no data is found for the given category, a DataNotFoundException is thrown.
     * In case of any other exceptions, a general ServerException is thrown.
     *
     * @param referenceCategory The category to filter the reference data.
     * @return List of reference data for the given category.
     */

    @Override
    public List<ReferenceData> getDataByCategory(String referenceCategory) {
        List<ReferenceData> data;
        try {
            data = referenceRepo.findByCategory(referenceCategory);
        } catch (Exception e) {
            log.error("Error occurred while fetching data by category", e);
            throw new ServerException("Server error occurred "+e.getMessage());
        }

        if (data.isEmpty()) {
            log.warn("No data found for this: {}", referenceCategory);
            throw new DataNotFoundException("No data found");
        }

        return data;
    }

    /**
     * Retrieves all reference data.
     * If no data is found, a DataNotFoundException is thrown.
     * In case of any other exceptions, a general ServerException is thrown.
     *
     * @return List of all reference data.
     */
    public List<ReferenceData> getAllReferenceData() {
        List<ReferenceData> allData;
        try {
            allData = referenceRepo.findAll(); // Assuming there is a findAll() method in your ReferenceRepo
        } catch (Exception e) {
            log.error("Error occurred while fetching all reference data", e);
            throw new ServerException("Server error occurred");
        }

        if (allData.isEmpty()) {
            log.warn("No reference data found");
            throw new DataNotFoundException("No reference data found");
        }

        return allData;
    }
}


