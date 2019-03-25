package com.imooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DynamicUpdate
@Data
public class SellerInfo {

    @Id
    private String sellerId;
    private String username;
    private String password;
    private String openid;

    public SellerInfo () {}

    public SellerInfo(String sellerId, String username, String password, String openid) {
        this.sellerId = sellerId;
        this.username = username;
        this.password = password;
        this.openid = openid;
    }
}
