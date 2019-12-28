package com.lry.dao;

import com.lry.po.users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liurenyi
 * @create 2019--10--21--19:02
 */
public interface UsersDao {
    //用户登陆
    users SelectIndex(@Param("username")String username,@Param("password") String password);
}
