package com.annakhuseinova.operators;

import com.annakhuseinova.OrderService;
import com.annakhuseinova.UserService;
import com.annakhuseinova.Util;

public class Lecture12FlatMap {

    public static void main(String[] args) {
        UserService.getUsers().flatMap(user -> OrderService.getOrders(user.getUserId())) // mono / flux
                .subscribe(Util.subscriber());
    }
}
