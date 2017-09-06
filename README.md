# log-event-consumer

Provides a way to read buffered log content from logback appenders. Currently supported appenders: com.github.raipc.logconsumer.MemoryAppender and com.github.raipc.logconsumer.ThreadLocalMemoryAppender. The first one creates single bytearray buffer, the second one creates one bytebuffer per thread.

### Add as Maven Dependency

```xml
<dependency>
    <groupId>com.github.raipc</groupId>
    <artifactId>log-event-consumer-logback</artifactId>
    <version>0.2.0</version>
</dependency>
```

### Usage

Add appender:

```xml
<configuration>
    <appender name="MEMORY_APPENDER" class="com.github.raipc.logconsumer.MemoryAppender">
        <encoder>
            <pattern>%-5level %d{HH:mm:ss.SSS} [%thread] [%class] %n%msg%n</pattern>
        </encoder>
    </appender>

    <root level="debug">
        <appender-ref ref="MEMORY_APPENDER" />
    </root>
</configuration>
```

Access logs programmatically:

```java
private static byte[] getAppenderContent() {
    final Logger rootLogger = (Logger) LoggerFactory.getLogger("ROOT");
    MemoryAppender appender = (MemoryAppender) rootLogger.getAppender("MEMORY_APPENDER");
    return appender.getOutputStream().toByteArray();
}
```
