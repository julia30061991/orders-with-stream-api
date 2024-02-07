package com.fjp_project;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Integer> {
    private int n;

    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return 1;
        } else {
            FactorialTask factorialTask = new FactorialTask(n - 1);
            factorialTask.fork();
            return n * factorialTask.join();
        }
    }
}