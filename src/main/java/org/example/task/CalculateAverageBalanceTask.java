package org.example.task;

import org.example.model.CustomerBalance;


public class CalculateAverageBalanceTask implements Runnable {

    private CustomerBalance customerBalance;

    public CalculateAverageBalanceTask(CustomerBalance customerBalance) {
        this.customerBalance = customerBalance;
    }

    @Override
    public void run() {
        calculateAverageBalance();
    }

    private void calculateAverageBalance() {
        int balanced = customerBalance.getBalanced();
        int previousBalanced = customerBalance.getPreviousBalanced();
        customerBalance.setAverageBalanced((balanced+previousBalanced)/2);
        customerBalance.setNo1Thread(Thread.currentThread().getName());
    }
}
