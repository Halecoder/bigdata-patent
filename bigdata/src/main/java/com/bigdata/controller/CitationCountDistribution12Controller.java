package com.bigdata.controller;


import com.bigdata.entity.CitationCountDistribution12;
import com.bigdata.result.R;
import com.bigdata.service.ICitationCountDistribution12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiedada
 * @since 2023-10-10
 */
@RestController
@RequestMapping("/12")
public class CitationCountDistribution12Controller {

    @Autowired
    private ICitationCountDistribution12Service iCitationCountDistribution12Service;

    @GetMapping
    public R<List<CitationCountDistribution12>> list (){
        return R.success(iCitationCountDistribution12Service.list());
    }

}

