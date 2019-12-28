package com.lry.dao;

import com.lry.po.product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liurenyi
 * @create 2019--10--21--20:56
 */
public interface ProductDao {

    List<product> selectProductName();

    //减少货物
    int update(product product);

    //查询货物
    product selectQuantity(@Param("id") int id);
}
