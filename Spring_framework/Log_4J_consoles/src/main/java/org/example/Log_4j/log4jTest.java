package org.example.Log_4j;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class log4jTest {

    private static final Logger logger=  LogManager.getLogger(log4jTest.class);

    public static void main(String[] args) {
        process();
    }

    public static void process()
    {
        logger.trace("from the trace mehtod");
        logger.debug("from the debug method");
        logger.info("from info method");
        logger.warn("from the warn method");
        logger.error("from error merthod");
        logger.fatal("from fatal methd");

//        the order of writing doesnt matter as it will execute the methods in its own pattern
    }
}
