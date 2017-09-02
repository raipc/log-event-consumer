package com.github.raipc.logconsumer;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.encoder.Encoder;
import ch.qos.logback.core.status.ErrorStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MemoryAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {
    @Setter
    private Encoder<ILoggingEvent> encoder;
    @Getter
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Override
    protected void append(ILoggingEvent event) {
        if (isStarted()) {
            try {
                event.prepareForDeferredProcessing();
                outputStream.write(encoder.encode(event));
            } catch (IOException ioe) {
                started = false;
                addStatus(new ErrorStatus("IO failure in appender", this, ioe));
            }
        }
    }
}