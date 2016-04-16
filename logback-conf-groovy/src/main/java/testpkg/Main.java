package testpkg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.event.Level;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        final Logger logger1 = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        final Logger logger2 = LoggerFactory.getLogger("testpkg.Main");
        final Marker mk1 = MarkerFactory.getMarker("MARK1");
        final Marker mk2 = MarkerFactory.getMarker("MARK2");

        logger1.trace(mk1, "slf4j + logback-classic, {}, {}, {}", 100, Level.TRACE, new InetSocketAddress("localhost", 8080));
        logger1.debug(mk1, "slf4j + logback-classic, {}, {}, {}", 200, Level.DEBUG, new InetSocketAddress("localhost", 8081));
        logger1.info(mk1,  "slf4j + logback-classic, {}, {}, {}", 300, Level.INFO,  new InetSocketAddress("localhost", 8082));
        logger1.warn(mk1,  "slf4j + logback-classic, {}, {}, {}", 400, Level.WARN,  new InetSocketAddress("localhost", 8083));
        logger1.error(mk1, "slf4j + logback-classic, {}, {}, {}", 500, Level.ERROR, new InetSocketAddress("localhost", 8084));

        logger2.trace(mk2, "slf4j + logback-classic, {}, {}, {}", 100, Level.TRACE, new InetSocketAddress("localhost", 8080));
        logger2.debug(mk2, "slf4j + logback-classic, {}, {}, {}", 200, Level.DEBUG, new InetSocketAddress("localhost", 8081));
        logger2.info(mk2,  "slf4j + logback-classic, {}, {}, {}", 300, Level.INFO,  new InetSocketAddress("localhost", 8082));
        logger2.warn(mk2,  "slf4j + logback-classic, {}, {}, {}", 400, Level.WARN,  new InetSocketAddress("localhost", 8083));
        logger2.error(mk2, "slf4j + logback-classic, {}, {}, {}", 500, Level.ERROR, new InetSocketAddress("localhost", 8084));
    }
}
