package testpkg;

import java.util.*;
import java.util.logging.*;

public class Main extends java.util.logging.Formatter {

    @Override
    public String format(LogRecord record) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(record.getMillis());
        return String.format("[%1$tFT %1$tT,%1$tL+%0$tZ] %2$s - %3$s%n", cal, record.getLevel(), record.getMessage());
    }

    public static FileHandler createMyFileHandler() throws Exception {
        // (file)pattern, limit, count, append
        FileHandler fh = new FileHandler("demo-%u-%g.log", 2048, 5, true);
        fh.setEncoding("UTF-8");
        fh.setLevel(Level.INFO);
        fh.setFormatter(new Main());
        return fh;
    }

    public static ConsoleHandler createMyConsoleHandler() throws Exception {
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        ch.setEncoding("UTF-8");
        ch.setFormatter(new Main());
        return ch;
    }

    public static void demolog(Logger logger, String msg) {
        logger.finest("java.util.logging.Logger.finest() - " + msg);
        logger.finer("java.util.logging.Logger.finer() - " + msg);
        logger.fine("java.util.logging.Logger.fine() - " + msg);
        logger.config("java.util.logging.Logger.config() - " + msg);
        logger.info("java.util.logging.Logger.info() - " + msg);
        logger.warning("java.util.logging.Logger.warning() - " + msg);
        logger.severe("java.util.logging.Logger.severe() - " + msg);
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        Logger rootLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        rootLogger.setLevel(Level.ALL);
        rootLogger.addHandler(createMyFileHandler());
        rootLogger.addHandler(createMyConsoleHandler());
        Logger logP1 = Logger.getLogger("p1");
        logP1.setParent(rootLogger);
        logP1.setLevel(Level.ALL);
        Logger logP1P12 = Logger.getLogger("p1.p12");
        logP1P12.setParent(logP1);
        logP1P12.setLevel(Level.WARNING);
        Logger logP1P12P13 = Logger.getLogger("p1.p12.p13");
        logP1P12P13.setParent(logP1P12);
        logP1P12P13.setLevel(Level.ALL);
        Logger logP2 = Logger.getLogger("p2");
        logP2.setParent(rootLogger);
        logP2.setLevel(Level.WARNING);
        Logger logP2P22 = Logger.getLogger("p2.p22");
        logP2P22.setParent(logP2);
        logP2P22.setLevel(Level.FINE);

        while (true) {
            demolog(rootLogger, "<Logger.GLOBAL_LOGGER_NAME>");
            demolog(logP1, "<Logger.p1>");
            demolog(logP1P12, "<Logger.p1.p12>");
            demolog(logP1P12P13, "<Logger.p1.p12.p13>");
            demolog(logP2, "<Logger.p2>");
            demolog(logP2P22, "<Logger.p2.p22>");
            Thread.sleep(1500);
        }
    }
}
