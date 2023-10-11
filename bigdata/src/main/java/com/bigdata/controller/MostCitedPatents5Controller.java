package com.bigdata.controller;


import com.bigdata.entity.MostCitedPatents5;
import com.bigdata.result.R;
import com.bigdata.service.IMostCitedPatents5Service;
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
@RequestMapping("/5")
public class MostCitedPatents5Controller {

    @Autowired
    private IMostCitedPatents5Service iMostCitedPatents5Service;

    @GetMapping
    public R<List<MostCitedPatents5>> list (){
        return R.success(iMostCitedPatents5Service.list());
    }

}

