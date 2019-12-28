package com.lry.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liurenyi
 * @create 2019--10--21--20:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class sale {
    private int id;
    private double price;
    private int quantity;
    private double totalprice;
    private String saleDate;
    private users userid;
    private product productid;

    public sale(double price, int quantity, double totalprice, users userid, product productid) {
        this.price = price;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.userid = userid;
        this.productid = productid;
    }


}
