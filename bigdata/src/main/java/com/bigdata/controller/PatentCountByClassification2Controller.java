package com.bigdata.controller;


import com.bigdata.entity.PatentCountByClassification2;
import com.bigdata.result.R;
import com.bigdata.service.IPatentCountByClassification2Service;
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
@RequestMapping("/2")
public class PatentCountByClassification2Controller {

    @Autowired
    private IPatentCountByClassification2Service iPatentCountByClassification2Service;

    @GetMapping
    public R<List<PatentCountByClassification2>> list (){


        return R.success(iPatentCountByClassification2Service.list());
    }

}

