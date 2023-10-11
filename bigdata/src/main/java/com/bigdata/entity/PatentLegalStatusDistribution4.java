package com.bigdata.entity;

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
public class PatentLegalStatusDistribution4 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String legalStatus;

    private Integer patentCount;


}
