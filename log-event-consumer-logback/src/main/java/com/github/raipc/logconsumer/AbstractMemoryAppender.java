package com.github.raipc.logconsumer;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.encoder.Encoder;
import ch.qos.logback.core.status.ErrorStatus;
import lombok.Setter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

abstract class AbstractMemoryAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {
    @Setter
    private Encoder<ILoggingEvent> encoder;

    @Override
    protected void append(ILoggingEvent event) {
        if (isStarted()) {
            try {
                event.prepareForDeferredProcessing();
                getOutputStream().write(encoder.encode(event));
            } catch (IOException ioe) {
                started = false;
                addStatus(new ErrorStatus("IO failure in appender", this, ioe));
            }
        }
    }

    abstract ByteArrayOutputStream getOutputStream();
}
