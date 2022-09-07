package org.example.thread;

import org.example.model.CustomerBalance;
import org.example.task.CalculateBonusBalanceTask;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class CalculateBonus1000BalanceThread extends ThreadHelper {
    private List<CustomerBalance> customerBalances;

    public CalculateBonus1000BalanceThread(List<CustomerBalance> customerBalances) {
        super(8);
        this.customerBalances = customerBalances;
    }

    @Override
    protected void executeTask(ExecutorService executor) {
        int bonusBalanceQuota = 1000;
        int maxCustomerGetBonus = 100;
        int bonusBalancePerCustomer = bonusBalanceQuota/maxCustomerGetBonus;
        for(CustomerBalance customerBalance : customerBalances){
            if(bonusBalanceQuota > 0){
                bonusBalanceQuota -= bonusBalancePerCustomer;
                CalculateBonusBalanceTask task = new CalculateBonusBalanceTask(customerBalance, bonusBalancePerCustomer, true);
                executor.execute(task);
            }
        }
    }
}
