package com.lry.service;

import com.lry.po.product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liurenyi
 * @create 2019--10--21--20:57
 */
public interface ProductService {
    List<product> selectProductName();
    //减少货物
    int update(product product);
    product selectQuantity(@Param("id") int id);
}
