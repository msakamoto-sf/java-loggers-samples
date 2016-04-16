package testpkg;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.MDC;

public class Agent implements Runnable {
    final String name;
    final int number;
    final Logger logger;
    public volatile boolean terminate = false;

    public Agent(final String agentName, final int aNumber, final Logger aLogger) {
        this.name = agentName;
        this.number = aNumber;
        this.logger = aLogger;
    }

    public void run() {
        final Marker mk = MarkerFactory.getMarker(this.name);
        this.logger.info(mk, "before agentNumber {} start.", this.number);
        MDC.put("agentName", this.name);
        this.logger.info(mk, "agentNumber {} start.", this.number);
        for (int i = 0; !this.terminate; i++) {
            this.logger.info(mk, "agentNumber {}, log count {}", this.number, i);
        }
        this.logger.info(mk, "agentNumber {} stop.", this.number);
        MDC.remove("agentName");
        this.logger.info(mk, "after agentNumber {} stop.", this.number);
    }
}
