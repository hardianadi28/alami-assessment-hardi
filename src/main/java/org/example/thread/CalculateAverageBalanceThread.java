package org.example.thread;

import org.example.model.CustomerBalance;
import org.example.task.CalculateAverageBalanceTask;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class CalculateAverageBalanceThread extends ThreadHelper {

    private List<CustomerBalance> customerBalances;

    public CalculateAverageBalanceThread(List<CustomerBalance> customerBalances) {
        super(10);
        this.customerBalances = customerBalances;
    }

    @Override
    protected void executeTask(ExecutorService executor) {
        customerBalances.forEach(customerBalance -> {
            CalculateAverageBalanceTask task = new CalculateAverageBalanceTask(customerBalance);
            executor.execute(task);
        });
    }
}
