package com.bigdata.controller;

import com.bigdata.entity.AffairPatentDate14;
import com.bigdata.result.R;
import com.bigdata.service.AffairPatentDate14Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/14")
public class AffairPatentDate14Controller {
    @Autowired
    private AffairPatentDate14Service affairPatentDate14Service;

    @GetMapping
    public R<List<AffairPatentDate14>> list() {
        return R.success(affairPatentDate14Service.list());
    }

}
