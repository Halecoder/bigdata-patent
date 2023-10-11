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
public class PatentAppliedVsGranted3 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer year;

    private Integer appliedCount;

    private Integer grantedCount;


}
