package com.lry.service;

import com.lry.po.sale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liurenyi
 * @create 2019--10--21--21:08
 */
public interface SaleService {
    List<sale> selectAllSale(@Param("orderby")int orderby);
    int insert(sale sale);
}
