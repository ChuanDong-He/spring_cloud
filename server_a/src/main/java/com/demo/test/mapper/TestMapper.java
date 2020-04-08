package com.demo.test.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author x_holic@outlook.com
 * @date 2020/4/8
 */
public interface TestMapper {

    int insert(@Param("id") int id);
}
