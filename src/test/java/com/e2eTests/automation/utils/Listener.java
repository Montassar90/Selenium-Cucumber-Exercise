package com.e2eTests.automation.utils;

import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestStep;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.TestStepFinished;
import io.cucumber.plugin.event.EventPublisher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Listener implements io.cucumber.plugin.ConcurrentEventListener {

    private static final Logger logger = LogManager.getLogger(Listener.class);

    private final EventHandler<TestStepFinished> handler = this::handleTestStepFinished;

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, handler);
    }

    private void handleTestStepFinished(TestStepFinished event) {
        TestStep testStep = event.getTestStep();

        if (testStep instanceof PickleStepTestStep) {
            PickleStepTestStep pickleStep = (PickleStepTestStep) testStep;
            String text = pickleStep.getStep().getText();
            logger.info("Executed Step: {}", text);
        }
    }
}
