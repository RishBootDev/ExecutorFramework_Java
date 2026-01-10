package com.rishbootdev.multithreading.executor_framework;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class LongRunningTask implements Runnable{

    private String cmd;

    @Override
    public void run() {

        log.info("Starting the thread to fulfill the command "+this.cmd+Thread.currentThread().getName());
        try{
            Thread.sleep(4000);
        }catch (InterruptedException ex) {
            log.error("Multithreading error");
        }

        log.info("Ending the task and the command got executed :{}",cmd);
    }

}
