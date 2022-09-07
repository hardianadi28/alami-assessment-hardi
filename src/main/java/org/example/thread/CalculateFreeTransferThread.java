package org.example.thread;

import org.example.model.CustomerBalance;
import org.example.task.CalculateFreeTransferTask;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class CalculateFreeTransferThread extends ThreadHelper {
    private List<CustomerBalance> customerBalances;

    public CalculateFreeTransferThread(List<CustomerBalance> customerBalances) {
        super(10);
        this.customerBalances = customerBalances;
    }

    @Override
    protected void executeTask(ExecutorService executor) {
        customerBalances.forEach(customerBalance -> {
            CalculateFreeTransferTask task = new CalculateFreeTransferTask(customerBalance);
            executor.execute(task);
        });
    }
}
