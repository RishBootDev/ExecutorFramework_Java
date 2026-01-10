package com.rishbootdev.multithreading.executor_framework;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongRunningTask implements Runnable{


    @Override
    public void run() {

        log.info("Starting the thread "+Thread.currentThread().getName());
        try{
            Thread.sleep(4000);
        }catch (InterruptedException ex) {
            log.error("Multithreading error");
        }

        log.info("Ending the task");
    }

}
