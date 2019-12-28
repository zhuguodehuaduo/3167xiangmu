package com.lry.service;

import com.lry.dao.UsersDao;
import com.lry.po.users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liurenyi
 * @create 2019--10--21--19:04
 */
@Service
public class UsersServiceImpl implements UsersService{

    @Resource
    UsersDao dao;

    @Override
    public users SelectIndex(String username,String password) {
        return dao.SelectIndex(username,password);
    }
}
