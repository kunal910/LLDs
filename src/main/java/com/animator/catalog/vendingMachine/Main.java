package com.animator.catalog.vendingMachine;

import com.animator.catalog.vendingMachine.model.Product;
import com.animator.catalog.vendingMachine.model.VendingMachine;

public class Main {

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.addProduct(new Product(1,"COKE", 20, 4));
        vm.addProduct(new Product(2,"5STAR", 10, 2));
        vm.addProduct(new Product(3,"CHIPS",25,1));

        vm.selectProduct(2);
        vm.insertMoney(20);
        vm.selectProduct(3);
        vm.cancelTransaction();
        vm.insertMoney(30);
        vm.selectProduct(3);
        vm.selectProduct(3);


    }
}
