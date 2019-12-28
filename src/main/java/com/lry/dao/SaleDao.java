package com.lry.dao;

import com.lry.po.sale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liurenyi
 * @create 2019--10--21--21:07
 */
public interface SaleDao {
    List<sale> selectAllSale(@Param("orderby")int orderby);
    //增加销售
    int insert(sale sale);
}
