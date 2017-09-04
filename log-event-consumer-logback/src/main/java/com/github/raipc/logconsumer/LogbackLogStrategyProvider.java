package com.github.raipc.logconsumer;

import ch.qos.logback.core.Appender;

public class LogbackLogStrategyProvider {
    public static LogStrategy createStrategy(Appender<?> appender) {
        if (appender instanceof AbstractMemoryAppender) {
            return new MemoryLogStrategy((AbstractMemoryAppender) appender);
        } else {
            return new NoopLogStrategy();
        }
    }
}
