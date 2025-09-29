package com.animator.catalog.vendingMachine.model;

public class DispenseState implements MachineState{

    private VendingMachine vm;
    public DispenseState(VendingMachine vendingMachine){
        this.vm=vendingMachine;
    }

    @Override
    public void insertMoney(int money) {
        System.out.println("Dispensing product, please wait");
    }

    @Override
    public void selectProduct(int id) {
        Product p = vm.getSelectedProduct();
        System.out.println("Dispensing " + p.getName());
        p.reduceQuantity();
        int returnMoney = vm.getMoney() - p.getPrice();
        if(returnMoney>0)System.out.println("Returning money $"+returnMoney);
        vm.setMoney(0);
        vm.setCurrentState(new IdleState(vm));
    }

    @Override
    public void cancel() {
        System.out.println("Cannot cancel, dispensing in progress.");
    }
}
