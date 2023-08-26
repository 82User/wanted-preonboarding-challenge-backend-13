package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(Customer customer){
        Cashier cashier = new Cashier(wantedCafe);

        String paymentMethod = customer.getPaymentMethod();
        Map<String, Integer> myOrders = customer.getMyOrders();

        validation(myOrders);

//        Map<String, Integer> myOrders = new HashMap<>();
//        myOrders.put("AMERICANO", 3);
        Customer c1 = new Customer("Card", myOrders);

        long totalPrice = calculateTotalPrice(myOrders);

        return cashier.takeOrder(myOrders, totalPrice);
    }

    private static void validation(Map<String, Integer> myOrders) {
        boolean tf = true;
        for (String s : myOrders.keySet()) {
            Menu[] values = Menu.values();
            for(Menu value : values) {
                if (s.equalsIgnoreCase(String.valueOf(value))) {
                    tf = true;
                    break;
                } else {
                    tf = false;
                }
            }
            if(!tf) throw new IllegalArgumentException("메뉴를 정확히 입력해주세요.");
        }
    }

    public long calculateTotalPrice(Map<String, Integer> orders) {
        long totalPrice = 0L;

        for (String key : orders.keySet()) {
            if (key.equalsIgnoreCase(String.valueOf(Menu.AMERICANO))) {
                totalPrice += Menu.AMERICANO.getPrice() * orders.get(key);
            } else if(key.equalsIgnoreCase(String.valueOf(Menu.CAFELATTE))){
                totalPrice += Menu.CAFELATTE.getPrice() * orders.get(key);
            } else if(key.equalsIgnoreCase(String.valueOf(Menu.SMOOTHIE))){
                totalPrice += Menu.SMOOTHIE.getPrice() * orders.get(key);
            }
        }
        System.out.println("totalPrice = " + totalPrice);
        return totalPrice;
    }
}
