package testpkg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.event.Level;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        CustomLogger.registerNewLogger("custom.logger1", "mylog1.log", Level.TRACE.toString());
        CustomLogger.registerNewLogger("custom.logger2", "mylog2.log", Level.INFO.toString());

        final Logger logger1 = LoggerFactory.getLogger("custom.logger1");
        final Logger logger2 = LoggerFactory.getLogger("custom.logger2");
        final Marker mk1 = MarkerFactory.getMarker("MARK1");
        final Marker mk2 = MarkerFactory.getMarker("MARK2");

        logger1.trace(mk1, "slf4j + logback-classic, {}, {}", 100, new InetSocketAddress("localhost", 8080));
        logger1.debug(mk1, "slf4j + logback-classic, {}, {}", 200, new InetSocketAddress("localhost", 8081));
        logger1.info(mk1,  "slf4j + logback-classic, {}, {}", 300, new InetSocketAddress("localhost", 8082));
        logger1.warn(mk1,  "slf4j + logback-classic, {}, {}", 400, new InetSocketAddress("localhost", 8083));
        logger1.error(mk1, "slf4j + logback-classic, {}, {}", 500, new InetSocketAddress("localhost", 8084));

        logger2.trace(mk2, "slf4j + logback-classic, {}, {}", 100, new InetSocketAddress("localhost", 8080));
        logger2.debug(mk2, "slf4j + logback-classic, {}, {}", 200, new InetSocketAddress("localhost", 8081));
        logger2.info(mk2,  "slf4j + logback-classic, {}, {}", 300, new InetSocketAddress("localhost", 8082));
        logger2.warn(mk2,  "slf4j + logback-classic, {}, {}", 400, new InetSocketAddress("localhost", 8083));
        logger2.error(mk2, "slf4j + logback-classic, {}, {}", 500, new InetSocketAddress("localhost", 8084));
    }
}
