package org.example.task;

import org.example.model.CustomerBalance;

public class CalculateFreeTransferTask implements Runnable {
    private CustomerBalance customerBalance;

    public CalculateFreeTransferTask(CustomerBalance customerBalance) {
        this.customerBalance = customerBalance;
    }

    @Override
    public void run() {
        calculateFreeTransfer();
    }

    private void calculateFreeTransfer() {
        int balanced = customerBalance.getBalanced();
        if(balanced >= 100 && balanced <= 150) {
            customerBalance.setFreeTransfer(5);
        }else{
            customerBalance.setFreeTransfer(0);
        }
        customerBalance.setNo2aThread(Thread.currentThread().getName());
    }
}
