package com.bigdata.controller;


import com.bigdata.entity.ClaimsCountDistribution11;
import com.bigdata.result.R;
import com.bigdata.service.IClaimsCountDistribution11Service;
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
@RequestMapping("/11")
public class ClaimsCountDistribution11Controller {

    @Autowired
    private IClaimsCountDistribution11Service iClaimsCountDistribution11Service;

    @GetMapping
    public R<List<ClaimsCountDistribution11>> list (){
        return R.success(iClaimsCountDistribution11Service.list());
    }

}

