package com.animator.catalog.vendingMachine.model;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Map<Integer, Product> productMap = new HashMap<>();
    private MachineState currentState;
    private int money=0;
    private Product selectedProduct;

    public VendingMachine(){
        this.currentState = new IdleState(this);
    }

    public void addProduct(Product product){
        productMap.put(product.getId(), product);
    }

    public Product getProduct(int id) {
        return productMap.get(id);
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setCurrentState(MachineState currentState) {
        this.currentState = currentState;
    }


    public void setSelectedProduct(Product product){
        this.selectedProduct = product;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void insertMoney(int money){
        currentState.insertMoney(money);
    }

    public void selectProduct(int id){
        currentState.selectProduct(id);
    }

    public void cancelTransaction(){
        currentState.cancel();
    }
}
