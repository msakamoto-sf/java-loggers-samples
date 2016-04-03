package testpkg;

import java.util.logging.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("confirm your (JRE)/lib/logging.properties file");

        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.finest("java.util.logging のデフォルト設定サンプル:finest");
        logger.finer("java.util.logging のデフォルト設定サンプル:finer");
        logger.fine("java.util.logging のデフォルト設定サンプル:fine");
        logger.config("java.util.logging のデフォルト設定サンプル:config");
        logger.info("java.util.logging のデフォルト設定サンプル:info");
        logger.warning("java.util.logging のデフォルト設定サンプル:warning");
        logger.severe("java.util.logging のデフォルト設定サンプル:severe");

        logger.log(Level.SEVERE, "java.util.logging.Logger.log({0}) のサンプル", "StringObject");
        logger.log(Level.SEVERE, "java.util.logging.Logger.log({0}, {1}, {2}) のサンプル", new Object[]{ "String1", "String2", "String3", "String4" });
        logger.log(Level.SEVERE, "java.util.logging.Logger.log(Throwable) のサンプル", new Exception("dummy"));

        logger.log(new LogRecord(Level.SEVERE, "java.util.logging.Logger.log(LogRecord) のサンプル"));
    }
}
