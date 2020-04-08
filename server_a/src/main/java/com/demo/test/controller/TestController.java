package com.demo.test.controller;

import com.demo.test.mapper.TestMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author x_holic@outlook.com
 * @date 2020/4/8
 */
@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("inset_a/{id}")
    @GlobalTransactional(name = "test", rollbackFor = Exception.class)
    public String insert(@PathVariable int id){
        testMapper.insert(id);
        restTemplate.getForObject("http://localhost:8082/inset_b/2", String.class);
        restTemplate.getForObject("http://localhost:8083/inset_c/3", String.class);
        int i = 1/0;
        return "success";
    }

}
