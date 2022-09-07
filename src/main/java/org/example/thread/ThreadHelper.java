package org.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public abstract class ThreadHelper {

    protected int numberOfThread;

    public ThreadHelper(int numberOfThread) {
        this.numberOfThread = numberOfThread;
    }

    public final void execute() {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThread);

        executeTask(executor);

        shutdownAndAwaitTermination(executor);
    }

    protected abstract void executeTask(ExecutorService executor);

    private void shutdownAndAwaitTermination(ExecutorService pool) {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow();
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ex) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
