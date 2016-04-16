package testpkg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.util.concurrent.*;

public class Main {

    final List<Agent> agents = new ArrayList<>();

    public ExecutorService invokeAgent(final String agentName) {
        final Logger agentLogger = LoggerFactory.getLogger("testpkg.AgentLogger");
        final ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            Agent a = new Agent(agentName, i, agentLogger);
            agents.add(a);
            es.submit(a);
        }
        return es;
    }

    public void longrun() throws Exception {
        final Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.info("invoking agent1...");
        final ExecutorService es1 = this.invokeAgent("agent1");
        logger.info("invoking agent2...");
        final ExecutorService es2 = this.invokeAgent("agent2");
        logger.info("invoking agent3...");
        final ExecutorService es3 = this.invokeAgent("agent3");

        logger.info("waiting 1 seconds.");
        Thread.sleep(1000);

        for (Agent a : this.agents) {
            a.terminate = true;
        }
        logger.info("terminating agent1...");
        if (!es1.awaitTermination(1, TimeUnit.SECONDS)) {
            es1.shutdownNow();
        }
        logger.info("terminating agent2...");
        if (!es2.awaitTermination(1, TimeUnit.SECONDS)) {
            es2.shutdownNow();
        }
        logger.info("terminating agent3...");
        if (!es2.awaitTermination(1, TimeUnit.SECONDS)) {
            es2.shutdownNow();
        }
        logger.info("all terminated.");
        this.agents.clear();
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.longrun();
        Thread.sleep(500);
        m.longrun();
    }
}
