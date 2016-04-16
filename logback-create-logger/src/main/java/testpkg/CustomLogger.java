package testpkg;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.FileAppender;

import org.slf4j.LoggerFactory;

/**
 * @see https://akhikhl.wordpress.com/2013/07/11/programmatic-configuration-of-slf4jlogback/
 */
public class CustomLogger {

    public static void registerNewLogger(String logname, String logfile, String loglevel) {
        final LoggerContext logCtx = (LoggerContext) LoggerFactory.getILoggerFactory();

        PatternLayoutEncoder logEncoder = new PatternLayoutEncoder();
        logEncoder.setContext(logCtx);
        logEncoder.setPattern("%d{ISO8601}-%-5level,%thread,%marker,%logger - %msg%n");
        logEncoder.start();

        ConsoleAppender logConsoleAppender = new ConsoleAppender();
        logConsoleAppender.setContext(logCtx);
        logConsoleAppender.setEncoder(logEncoder);
        logConsoleAppender.start();

        logEncoder = new PatternLayoutEncoder();
        logEncoder.setContext(logCtx);
        logEncoder.setPattern("%d{ISO8601}+%-5level,%thread,%marker,%logger - %msg%n");
        logEncoder.start();

        FileAppender logFileAppender = new FileAppender();
        logFileAppender.setContext(logCtx);
        logFileAppender.setEncoder(logEncoder);
        logFileAppender.setAppend(true);
        logFileAppender.setFile(logfile);
        logFileAppender.start();

        Level levelImpl = Level.toLevel(loglevel);

        Logger log = logCtx.getLogger(logname);
        log.setLevel(levelImpl);
        log.addAppender(logConsoleAppender);
        log.addAppender(logFileAppender);
    }
}
