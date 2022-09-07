package org.example.task;

import org.example.model.CustomerBalance;

public class CalculateBonusBalanceTask implements Runnable {

    private CustomerBalance customerBalance;

    private int bonusBalance;

    private boolean isExtraBonusBalance;

    public CalculateBonusBalanceTask(CustomerBalance customerBalance, int bonusBalance, boolean isExtraBonusBalance) {
        this.customerBalance = customerBalance;
        this.bonusBalance = bonusBalance;
        this.isExtraBonusBalance = isExtraBonusBalance;
    }

    @Override
    public void run() {
        calculateBonusBalance();
    }

    private void calculateBonusBalance() {
        int balanced = customerBalance.getBalanced();
        if (balanced > 150) {
            customerBalance.setPreviousBalanced(balanced);
            customerBalance.setBalanced(balanced + bonusBalance);
        }
        if (isExtraBonusBalance) {
            customerBalance.setNo3Thread(Thread.currentThread().getName());
        } else {
            customerBalance.setNo2bThread(Thread.currentThread().getName());
        }

    }
}
