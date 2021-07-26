package com.annakhuseinova;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private static Map<Integer, List<PurchaseOrder>> db = new HashMap<>();

    static {
        List<PurchaseOrder> userId1List = Arrays.asList(
                new PurchaseOrder(1),
                new PurchaseOrder(1),
                new PurchaseOrder(1)
        );
        db.put(1, userId1List);
        List<PurchaseOrder> userId2List = Arrays.asList(
                new PurchaseOrder(2),
                new PurchaseOrder(2)
        );
        db.put(2, userId2List);
    }

    public static Flux<PurchaseOrder> getOrders(int userId){
        return Flux.create(purchaseOrderFluxSink -> {
            db.get(userId).forEach(purchaseOrderFluxSink::next);
            purchaseOrderFluxSink.complete();
        });
    }
}
