package com.becksonsee.springbootmall.dto;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CreateOrderRequest {

    @NotEmpty               // 加在 Map 或 List 上面， 4-13
    private List<BuyItem> buyItemList;


    public List<BuyItem> getBuyItemList() {
        return buyItemList;
    }

    public void setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    }
}
