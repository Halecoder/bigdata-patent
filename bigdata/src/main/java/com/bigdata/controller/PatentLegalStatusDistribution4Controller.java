package com.bigdata.controller;


import com.bigdata.entity.PatentLegalStatusDistribution4;
import com.bigdata.result.R;
import com.bigdata.service.IPatentLegalStatusDistribution4Service;
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
@RequestMapping("/4")
public class PatentLegalStatusDistribution4Controller {

    @Autowired
    private IPatentLegalStatusDistribution4Service iPatentLegalStatusDistribution4Service;

    @GetMapping
    public R<List<PatentLegalStatusDistribution4>> list (){
        return R.success(iPatentLegalStatusDistribution4Service.list());
    }

}

