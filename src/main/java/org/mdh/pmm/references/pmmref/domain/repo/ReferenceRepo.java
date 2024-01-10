package org.mdh.pmm.references.pmmref.domain.repo;

import org.mdh.pmm.references.pmmref.domain.model.ReferenceData;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The repository interface for ReferenceData. It extends JpaRepository to provide common persistence methods.
 * Custom queries can be added here for more complex database operations.
 */
@Repository
@ConditionalOnProperty(value = "spring.profiles.active", havingValue = "pmmref")
public interface ReferenceRepo extends JpaRepository<ReferenceData, Long> {
    /**
     * Custom query to find reference data by category.
     * Uses JPQL (Java Persistence Query Language) for querying the database.
     *
     * @param category The category to filter the reference data.
     * @return List of ReferenceData objects that match the category.
     */
    List<ReferenceData> findByCategory(String category);
}
