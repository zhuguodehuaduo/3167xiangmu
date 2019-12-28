package com.lry.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liurenyi
 * @create 2019--10--21--20:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class product {
    private int id;
    private String productname;
    private int quantity;

    public product(String productname, int quantity) {
        this.productname = productname;
        this.quantity = quantity;
    }

    public product(int id) {
        this.id = id;
    }

    public product(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}
