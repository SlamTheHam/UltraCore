package com.slamtheham.ultracore.utils;

import com.slamtheham.ultracore.Main;
import org.bukkit.Bukkit;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ProcessTime {

    private Runnable runnable;
    private String time;

    public ProcessTime(Runnable runnable) {
        this.runnable = runnable;
    }

    public void run() {
        if (runnable == null) return;
        long startTime = System.nanoTime();
        Bukkit.getScheduler().runTask(Main.getInstance(), runnable);
        long endTime = System.nanoTime();
        long estimatedTime = endTime - startTime;
        double milliseconds = (double) estimatedTime / 1000000;
        NumberFormat formatter = new DecimalFormat("#0.00");
        time = formatter.format(milliseconds);
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public String getTime() {
        return time;
    }
}
