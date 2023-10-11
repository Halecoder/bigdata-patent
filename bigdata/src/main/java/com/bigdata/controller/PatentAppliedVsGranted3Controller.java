package com.bigdata.controller;


import com.bigdata.entity.PatentAppliedVsGranted3;
import com.bigdata.result.R;
import com.bigdata.service.IPatentAppliedVsGranted3Service;
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
@RequestMapping("/3")
public class PatentAppliedVsGranted3Controller {

    @Autowired
    private IPatentAppliedVsGranted3Service iPatentAppliedVsGranted3Service;

    @GetMapping
    public R<List<PatentAppliedVsGranted3>> list (){
        return R.success(iPatentAppliedVsGranted3Service.list());
    }

}

