package com.urmedia.app;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class AppRunner implements Runnable {

    @Override
    public void run() {
        log.info("I made it into the app runner!");
    }
}
