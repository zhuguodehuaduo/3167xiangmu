package com.lry.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liurenyi
 * @create 2019--10--21--19:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class users {
    private int id;
    private String username;
    private String password;
    private String realname;

    public users(String username, String password, String realname) {
        this.username = username;
        this.password = password;
        this.realname = realname;
    }

    public users(int id) {
        this.id = id;
    }
}
