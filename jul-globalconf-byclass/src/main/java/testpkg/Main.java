package testpkg;

import java.util.logging.*;

public class Main {

    public Main() throws Exception {
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/jul.prop"));
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
        System.out.println("set -Djava.util.logging.config.class=testpkg.Main");
        while (true) {
            demolog(Logger.getLogger(Logger.GLOBAL_LOGGER_NAME), "<Logger.GLOBAL_LOGGER_NAME>");
            demolog(Logger.getLogger("p1"), "<Logger.p1>");
            demolog(Logger.getLogger("p1.p12"), "<Logger.p1.p12>");
            demolog(Logger.getLogger("p1.p12.p13"), "<Logger.p1.p12.p13>");
            demolog(Logger.getLogger("p2"), "<Logger.p2>");
            demolog(Logger.getLogger("p2.p22"), "<Logger.p2.p22>");
            Thread.sleep(1500);
        }
    }
}
