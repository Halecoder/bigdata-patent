package com.bigdata.entity;

import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiedada
 * @since 2023-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UpdatedCitingInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String patentId;

    private String patentName;

    private String publicationNumber;

    private LocalDate publicationDate;

    private String applicationNumber;

    private LocalDate applicationDate;

    private String patentHolder;

    private String classification;

    private String citedPatentName;

    private String citedPublicationNumber;

    private LocalDate citedPublicationDate;

    private String citedApplicationNumber;

    private LocalDate citedApplicationDate;

    private String citedGrantNumber;

    private LocalDate citedGrantDate;

    private LocalDate citedPriorityDate;

    private String citedInventors;

    private String citedPatentHolder;

    private String citedClassification;

    private Long citedClaimsCount;

    private Long citedCitedPatentsCount;

    private Long citedCitedByCount;

    private String citedLegalStatus;

    private String citedFamilyToFamilyReference;

    private String addedBy;


}
