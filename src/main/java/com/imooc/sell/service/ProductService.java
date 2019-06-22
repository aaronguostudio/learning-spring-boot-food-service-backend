package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    /*
    * Find all products for sale
    * */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /*
    * Add Inventory
    * */

    void increaseStock(List<CartDTO> cartDTOList);
    void decreaseStock(List<CartDTO> cartDTOList);

    /*
    * Reduce Inventory
    * */

}
