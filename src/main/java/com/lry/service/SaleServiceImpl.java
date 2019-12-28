package com.lry.service;

import com.lry.dao.SaleDao;
import com.lry.po.sale;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liurenyi
 * @create 2019--10--21--21:08
 */
@Service
public class SaleServiceImpl implements SaleService {

    @Resource
    SaleDao dao;

    @Override
    public List<sale> selectAllSale(int orderby) {
        return dao.selectAllSale(orderby);
    }

    @Override
    public int insert(sale sale) {
        return dao.insert(sale);
    }


}
