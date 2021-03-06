package org.example;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.camunda.bpm.spring.boot.starter.event.PreUndeployEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @EventListener
    public void onPostDeploy(PostDeployEvent event) {
        logger.info("postDeploy: {}", event);
    }

    @EventListener
    public void onPreUndeploy(PreUndeployEvent event) {
        logger.info("preUndeploy: {}", event);
    }
}
