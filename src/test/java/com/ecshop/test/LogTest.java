package com.ecshop.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


/**
 * Created by amy sheng on 2/28/2018.
 */
public class LogTest {
    private static Logger logger = LogManager.getLogger();

    @Test
    public void LogTest1(){
        logger.error("哈哈，error");
    }
    @Test
    public void LogTest2(){
        logger.warn("哈哈，warn");
    }
    @Test
    public void LogTest3(){
        logger.info("哈哈，info");
    }
    @Test
    public void LogTest4(){
        logger.debug("哈哈，debug");
    }
    @Test
    public void LogTest5(){
        logger.trace("哈哈，trace");
    }
}
