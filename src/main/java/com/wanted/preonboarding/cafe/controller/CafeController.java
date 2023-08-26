package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.dto.OrderDto;
import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted coding cafe!!";
    }

    @PostMapping("order")
    public String orderFromMenu(@RequestBody OrderDto orderDto){

        Customer customer = Customer.builder()
                .paymentMethod(orderDto.getPaymentMethod())
                .myOrders(orderDto.getMyOrders())
                .build();

//        HashMap<String, Integer> menu = new HashMap<String, Integer>();
//        menu.put("AMERICANO", 3);
        return cafeService.orderFrom(customer);
    }
}
