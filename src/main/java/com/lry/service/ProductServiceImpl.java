package com.lry.service;

import com.lry.dao.ProductDao;
import com.lry.po.product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liurenyi
 * @create 2019--10--21--20:58
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductDao dao;


    @Override
    public List<product> selectProductName() {
        return dao.selectProductName();
    }

    @Override
    public int update(product product) {
        return dao.update(product);
    }

    @Override
    public product selectQuantity(int id) {
        return dao.selectQuantity(id);
    }


}
