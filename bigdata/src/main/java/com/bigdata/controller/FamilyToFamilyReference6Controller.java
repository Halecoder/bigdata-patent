package com.bigdata.controller;


import com.bigdata.entity.FamilyToFamilyReference6;
import com.bigdata.result.R;
import com.bigdata.service.IFamilyToFamilyReference6Service;
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
@RequestMapping("/6")
public class FamilyToFamilyReference6Controller {

    @Autowired
    private IFamilyToFamilyReference6Service iFamilyToFamilyReference6Service;

    @GetMapping
    public R<List<FamilyToFamilyReference6>> list (){
        return R.success(iFamilyToFamilyReference6Service.list());
    }

}

