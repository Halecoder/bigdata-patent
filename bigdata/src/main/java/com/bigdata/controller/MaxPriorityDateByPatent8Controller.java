package com.bigdata.controller;


import com.bigdata.entity.MaxPriorityDateByPatent8;
import com.bigdata.result.R;
import com.bigdata.service.IMaxPriorityDateByPatent8Service;
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
@RequestMapping("/8")
public class MaxPriorityDateByPatent8Controller {

    @Autowired
    private IMaxPriorityDateByPatent8Service iMaxPriorityDateByPatent8Service;

    @GetMapping
    public R<List<MaxPriorityDateByPatent8>> list (){
        return R.success(iMaxPriorityDateByPatent8Service.list());
    }

}

