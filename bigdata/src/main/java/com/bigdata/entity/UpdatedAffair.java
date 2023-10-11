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
public class UpdatedAffair implements Serializable {

    private static final long serialVersionUID = 1L;

    private String patentId;

    private Integer serialNumber;

    private String eventType;

    private LocalDate eventDate;

    private String eventCode;

    private String eventDescription;


}
