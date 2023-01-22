package com.marcoDomingues.WebServices.entities.enums;

import com.marcoDomingues.WebServices.entities.User;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    // returning OrderStatus matching argument od valueOff()
    public static OrderStatus valueOf(int code) {
        // going throw all order status values ond for each one test if is the corresponding code.
        for (OrderStatus value : OrderStatus.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus Code");
    }
}

