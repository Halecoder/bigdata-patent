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
public class UpdatedBaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String patentId;

    private String patentName;

    private String publicationNumber;

    private LocalDate publicationDate;

    private String applicationNumber;

    private LocalDate applicationDate;

    private String grantNumber;

    private LocalDate grantDate;

    private LocalDate priorityDate;

    private String inventors;

    private String patentHolder;

    private String classification;

    private String briefDescription;

    private Long claimsCount;

    private Long citedPatentsCount;

    private Long citedByCount;

    private String legalStatus;


}
