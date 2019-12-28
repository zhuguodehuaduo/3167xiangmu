package com.lry.service;

import com.lry.po.users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liurenyi
 * @create 2019--10--21--19:04
 */
public interface UsersService {
    users SelectIndex(@Param("username")String username, @Param("password") String password);
}
