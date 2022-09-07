package org.example.thread;

import org.example.model.CustomerBalance;
import org.example.task.CalculateBonusBalanceTask;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class CalculateBonusBalanceThread extends ThreadHelper {
    private List<CustomerBalance> customerBalances;

    public CalculateBonusBalanceThread(List<CustomerBalance> customerBalances) {
        super(10);
        this.customerBalances = customerBalances;
    }

    @Override
    protected void executeTask(ExecutorService executor) {
        customerBalances.forEach(customerBalance -> {
            CalculateBonusBalanceTask task = new CalculateBonusBalanceTask(customerBalance, 25, false);
            executor.execute(task);
        });
    }
}
