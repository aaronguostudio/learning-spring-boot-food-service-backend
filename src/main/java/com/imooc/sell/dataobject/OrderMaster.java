package com.imooc.sell.dataobject;

import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class OrderMaster {

    @Id
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    private Date createTime;
    private Date updateTime;

    // 增加这个字段为了方便查询 OrderMaster 的时候同时返回关联的订单
    // 增加 Transient 让 Hibernate 不会去数据库里面匹配
    // 以上这样的方法不是很好，污染了和数据库的对应关系
    // 我们采用在 dto 里面创建数据模型的方式来处理
    /*@Transient
    private List<OrderDetail> orderDetailList;*/

}
