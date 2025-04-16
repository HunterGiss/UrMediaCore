package com.urmedia.app;


import com.urmedia.app.dagger.component.AppComponent;
import com.urmedia.app.dagger.component.DaggerAppComponent;

import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    @Inject
    public AppRunner appRunner;

    public static void main(String[] args) {
        App app = new App();

        AppComponent serviceComponent = DaggerAppComponent.create();
        serviceComponent.inject(app);

        app.runApp();
    }

    private void runApp() {
        Thread mainThread = new Thread(appRunner, "MainThread");
        addShutdownHook(() -> safeThreadShutdown(mainThread));
        mainThread.start();
        try {
            mainThread.join();
        } catch (InterruptedException e) {
            log.warn("Main thread interrupted while waiting for main logic to finish.");
            Thread.currentThread().interrupt();
        }
    }

    private void addShutdownHook(Runnable shutdownSequence) {
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownSequence, "ShutdownHookThread"));
    }

    private void safeThreadShutdown(Thread mainThread) {
        log.info("Shutdown hook triggered. Interrupting application thread...");
        mainThread.interrupt();
        try {
            mainThread.join();
        } catch (final InterruptedException e) {
            log.warn("Shutdown interrupted.");
            throw new RuntimeException(e);
        }
        log.info("Application shutdown complete.");
    }
}
