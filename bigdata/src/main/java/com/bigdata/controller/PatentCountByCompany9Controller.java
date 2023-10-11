package com.bigdata.controller;


import com.bigdata.entity.PatentCountByCompany9;
import com.bigdata.result.R;
import com.bigdata.service.IPatentCountByCompany9Service;
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
@RequestMapping("/9")
public class PatentCountByCompany9Controller {

    @Autowired
    private IPatentCountByCompany9Service iPatentCountByCompany9Service;

    @GetMapping
    public R<List<PatentCountByCompany9>> list (){
        return R.success(iPatentCountByCompany9Service.list());
    }

}

