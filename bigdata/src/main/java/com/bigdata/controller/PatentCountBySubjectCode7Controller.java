package com.bigdata.controller;


import com.bigdata.entity.PatentCountBySubjectCode7;
import com.bigdata.result.R;
import com.bigdata.service.IPatentCountBySubjectCode7Service;
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
@RequestMapping("/7")
public class PatentCountBySubjectCode7Controller {

    @Autowired
    private IPatentCountBySubjectCode7Service iPatentCountBySubjectCode7Service;

    @GetMapping
    public R<List<PatentCountBySubjectCode7>> list (){
        return R.success(iPatentCountBySubjectCode7Service.list());
    }

}

