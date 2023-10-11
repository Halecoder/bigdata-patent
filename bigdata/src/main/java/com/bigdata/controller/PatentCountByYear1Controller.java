package com.bigdata.controller;


import com.bigdata.entity.PatentCountByYear1;
import com.bigdata.result.R;
import com.bigdata.service.IPatentCountByYear1Service;
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
@RequestMapping("/1")
public class PatentCountByYear1Controller {

    @Autowired
    private IPatentCountByYear1Service iPatentCountByYear1Service;

    @GetMapping
    public R<List<PatentCountByYear1>> list (){
        return R.success(iPatentCountByYear1Service.list());
    }

}

