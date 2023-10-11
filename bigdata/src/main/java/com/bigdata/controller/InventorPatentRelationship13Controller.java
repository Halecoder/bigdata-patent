package com.bigdata.controller;


import com.bigdata.entity.InventorPatentRelationship13;
import com.bigdata.result.R;
import com.bigdata.service.IInventorPatentRelationship13Service;
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
@RequestMapping("/13")
public class InventorPatentRelationship13Controller {

    @Autowired
    private IInventorPatentRelationship13Service iInventorPatentRelationship13Service;

    @GetMapping
    public R<List<InventorPatentRelationship13>> list (){
        return com.bigdata.result.R.success(iInventorPatentRelationship13Service.list());
    }

}

