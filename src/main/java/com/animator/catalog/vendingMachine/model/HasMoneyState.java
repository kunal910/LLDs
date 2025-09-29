package com.animator.catalog.vendingMachine.model;

public class HasMoneyState implements MachineState{

    private VendingMachine vm;
    public HasMoneyState(VendingMachine vendingMachine){
        this.vm = vendingMachine;
    }

    @Override
    public void insertMoney(int money) {
        System.out.println("Please select product or cancel");
    }

    @Override
    public void selectProduct(int id) {
        Product p = vm.getProduct(id);
        if(p==null){
            System.out.println("Product not found");
            return;
        }
        if(p.getQuantity() <= 0) {
            System.out.println("Product out of stock.");
            return;
        }
        if(vm.getMoney() < p.getPrice()) {
            System.out.println("Insufficient money. Please insert more.");
            return;
        }
        vm.setSelectedProduct(p);
        vm.setCurrentState(new DispenseState(vm));
    }

    @Override
    public void cancel() {
        System.out.println("Transaction cancelled. Returning money $"+vm.getMoney());
        vm.setMoney(0);
        vm.setCurrentState(new IdleState(vm));
    }
}
