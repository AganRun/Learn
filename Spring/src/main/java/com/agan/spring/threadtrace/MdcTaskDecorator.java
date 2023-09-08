package com.agan.spring.threadtrace;

import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;

import java.util.Map;

public class MdcTaskDecorator implements TaskDecorator {
    @Override
    public Runnable decorate(Runnable runnable) {
        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        return () -> {
            try {
                if (contextMap != null) {
                    //带入Trace
                    MDC.setContextMap(contextMap);
                }
                runnable.run();
            } finally {
                //要清除。否则复用线程池时，trace会复用
                MDC.clear();
            }
        };
    }
}
