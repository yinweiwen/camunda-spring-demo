package org.example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.impl.history.event.HistoryEvent;
import org.camunda.bpm.spring.boot.starter.event.ExecutionEvent;
import org.camunda.bpm.spring.boot.starter.event.TaskEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
class MyListener {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @EventListener
    public void onTaskEvent(DelegateTask taskDelegate) {
        // 处理可变的任务事件
        logger.info("on event delegate {}",taskDelegate);
    }

    @EventListener
    public void onTaskEvent(TaskEvent taskEvent) {
        // 处理不可变的任务事件
        logger.info("on event task {}",taskEvent);
    }

    @EventListener
    public void onExecutionEvent(DelegateExecution executionDelegate) {
        // 处理可变的执行事件
        logger.info("on execution delegate {}",executionDelegate);
    }

    @EventListener
    public void onExecutionEvent(ExecutionEvent executionEvent) {
        // 处理不可改的执行事件
        logger.info("on execution event {}",executionEvent);
    }

    @EventListener
    public void onHistoryEvent(HistoryEvent historyEvent) {
        // 处理历史事件
        logger.info("on event history {}",historyEvent);
    }

}