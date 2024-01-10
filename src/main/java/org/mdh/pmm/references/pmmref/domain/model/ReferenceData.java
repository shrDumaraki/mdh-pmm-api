package org.mdh.pmm.references.pmmref.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/** test test test
 * The ReferenceData entity class maps to a database table/view for reference data.
 * It uses JPA annotations to define the table structure and Lombok annotations for boilerplate code like getters/setters.
 */
@Data
@Entity
@Table(name = "referencedata", schema = "public")
public class ReferenceData {
    @Id
    @JsonIgnore
    @Column(name = "audthashcd")
    private String audtHashCd;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private String value;

    @Column(name = "code")
    private String code;
}
