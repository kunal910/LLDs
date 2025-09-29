package com.animator.catalog.vendingMachine.model;

public class IdleState implements MachineState{

    private VendingMachine vm;
    public IdleState(VendingMachine vendingMachine){
        this.vm = vendingMachine;
    }

    @Override
    public void insertMoney(int money) {
        System.out.println("Money inserted $"+money);
        vm.setMoney(money);
        vm.setCurrentState(new HasMoneyState(vm));
    }

    @Override
    public void selectProduct(int id) {
        System.out.println("Please insert money");
    }

    @Override
    public void cancel() {
        System.out.println("Nothing to cancel");
    }
}
