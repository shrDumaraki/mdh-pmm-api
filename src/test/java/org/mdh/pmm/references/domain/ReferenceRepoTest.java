package org.mdh.pmm.references.domain;

import org.junit.jupiter.api.Test;
import org.mdh.pmm.references.pmmref.domain.model.ReferenceData;
import org.mdh.pmm.references.pmmref.domain.repo.ReferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReferenceRepoTest {

    @Autowired
    private ReferenceRepo referenceRepo;

    @Test
    void findByCategory_ShouldReturnNonEmptyList() {
        List<ReferenceData> result = referenceRepo.findByCategory("Gender");
        assertFalse(result.isEmpty());
    }
}
