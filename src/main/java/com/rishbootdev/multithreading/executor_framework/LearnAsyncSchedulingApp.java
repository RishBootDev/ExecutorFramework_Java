package com.rishbootdev.multithreading.executor_framework;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class LearnAsyncSchedulingApp {

    public static void main(String[] args) {

        //test1();
        Scanner sc = new Scanner(System.in);
        log.info("Please enter the command ");
        String cmd = sc.next();
        //test2(cmd);
        test3(cmd);
    }

    public static void test2(String cmd) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                6,10,2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10)
        );

        log.info("Starting the main thread -> {}",Thread.currentThread().getName());

        threadPoolExecutor.submit(new LongRunningTask(cmd));
        log.info("Ending the main thread -> {}", Thread.currentThread().getName());

    }

    public static void test3(String cmd) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                6,10,2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10)
        );

        log.info("Starting the main thread -> {}",Thread.currentThread().getName());

        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.submit(new LongRunningTask(cmd));
        }

        threadPoolExecutor.submit(new LongRunningTask(cmd));
        log.info("Ending the main thread -> {}", Thread.currentThread().getName());

    }


    public static void test1() {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                6,10,2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10)
        );

        threadPoolExecutor.submit(()-> {
                log.info("Starting the thread "+Thread.currentThread().getName());
                try{
                    Thread.sleep(4000);
                }catch (InterruptedException ex) {
                    log.error("Multithreading error");
                }

                log.info("Ending the task");
        });

        }
    }

