package com.wanted.preonboarding.cafe.dto;

import lombok.Getter;

import java.util.Map;

@Getter
public class OrderDto {

    private String paymentMethod;
    private Map<String, Integer> myOrders;
}
