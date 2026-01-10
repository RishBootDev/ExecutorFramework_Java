package com.rishbootdev.multithreading.executor_framework;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Slf4j
public class LearnAsyncSchedulingApp {

    public static void main(String[] args) {

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

