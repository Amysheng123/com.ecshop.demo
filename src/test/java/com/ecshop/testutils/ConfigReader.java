package com.ecshop.testutils;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by amy sheng on 3/1/2018.
 */
public class ConfigReader {
    private static Properties prop;
    public static final String BROWSER = "browser";
    public static final String WAITTIME = "waitTime";
    static {
        prop = new Properties();
        InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("test.properties");

        try {
            prop.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getConfig(String name){
        return prop.getProperty(name);
    }
}
