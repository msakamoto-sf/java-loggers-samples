import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import static ch.qos.logback.classic.Level.*

appender("STDOUT1", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d{ISO8601}-%-5level,%thread,%marker,%logger - %msg%n"
  }
}

appender("STDOUT2", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d{ISO8601}+%-5level,%thread,%marker,%logger - %msg%n"
  }
}

logger("testpkg.Main", INFO, ["STDOUT2"])
root(TRACE, ["STDOUT1"])
