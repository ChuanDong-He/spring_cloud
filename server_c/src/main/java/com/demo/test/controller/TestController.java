package com.demo.test.controller;

import com.demo.test.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author x_holic@outlook.com
 * @date 2020/4/8
 */
@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @Transactional
    @GetMapping("inset_c/{id}")
    public String insert(@PathVariable int id){
        testMapper.insert(id);
        return "success";
    }

}
