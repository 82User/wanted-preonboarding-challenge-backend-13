package com.wanted.preonboarding.cafe.service.handler;

public enum Menu {
    AMERICANO(1000),
    CAFELATTE(2000),
    SMOOTHIE(3000);

    private long price;

    Menu(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
