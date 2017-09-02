package com.github.raipc.logconsumer;

import ch.qos.logback.core.Appender;

public class LogbackLogStrategyProvider {
    public static LogStrategy createStrategy(Appender<?> appender) {
        if (appender instanceof MemoryAppender) {
            return new MemoryLogStrategy((MemoryAppender) appender);
        } else {
            return new NoopLogStrategy();
        }
    }
}
