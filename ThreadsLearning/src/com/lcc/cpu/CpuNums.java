package com.lcc.cpu;

/**
 * @Classname CpuNums
 * @Description TODO
 * @Version 1.0.0
 * @Date 12/9 009 下午 18:10:47
 * @Created by LCC95
 */

public class CpuNums {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        //get the nums of processors(cores) of this computer
        int cpuNums = runtime.availableProcessors();

        System.out.println("There are " + cpuNums + " cpus " + "working !");
    }
}
