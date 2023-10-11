package com.bigdata.controller;


import com.bigdata.entity.LegalStatusChangeOverTime10;
import com.bigdata.result.R;
import com.bigdata.service.ILegalStatusChangeOverTime10Service;
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
@RequestMapping("/10")
public class LegalStatusChangeOverTime10Controller {

    @Autowired
    private ILegalStatusChangeOverTime10Service iLegalStatusChangeOverTime10Service;

    @GetMapping
    public R<List<LegalStatusChangeOverTime10>> list (){
        return R.success(iLegalStatusChangeOverTime10Service.list());
    }

}

