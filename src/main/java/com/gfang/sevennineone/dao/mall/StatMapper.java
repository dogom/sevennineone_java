package com.gfang.sevennineone.dao.mall;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface StatMapper {
    List<Map> statUser();

    List<Map> statOrder();

    List<Map> statGoods();
}