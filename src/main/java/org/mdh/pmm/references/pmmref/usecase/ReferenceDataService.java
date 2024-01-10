package org.mdh.pmm.references.pmmref.usecase;

import org.mdh.pmm.references.pmmref.domain.model.ReferenceData;

import java.util.List;

public interface ReferenceDataService {
    List<ReferenceData> getDataByCategory(String referenceCategory);
    List<ReferenceData> getAllReferenceData();

}
