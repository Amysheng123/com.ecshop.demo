package com.ecshop.WebDriverUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.ecshop.testutils.RemoteLogWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.annotations.Test;

public class WebDriverUtils {
    private static DriverService service;

    private WebDriverUtils() {
    }

    ;

    public static WebDriver getDriver(String browsername, Class<?> clazz) {
        WebDriver dw = null;
        if (service == null) {
            if ("chrome".equalsIgnoreCase(browsername)) {
                service = new ChromeDriverService.Builder().usingDriverExecutable(new File("drivers/chromedriver.exe"))
                        .usingAnyFreePort().build();
            } else if ("firefox".equalsIgnoreCase(browsername)) {
                service = new GeckoDriverService.Builder().usingDriverExecutable(new File("drivers/geckodriver.exe"))
                        .usingAnyFreePort().build();
            } else if ("IE".equalsIgnoreCase(browsername)) {
                service = new InternetExplorerDriverService.Builder()
                        .usingDriverExecutable(new File("drivers/IEDriverServer.exe")).usingAnyFreePort().build();
            } else {
                System.err.println("浏览器不支持");
                return null;
            }
            try {
                service.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if ("chrome".equalsIgnoreCase(browsername)) {
            dw = new RemoteLogWebDriver(service.getUrl(), DesiredCapabilities.chrome(), clazz);
        } else if ("firefox".equalsIgnoreCase(browsername)) {
            dw = new RemoteLogWebDriver(service.getUrl(), DesiredCapabilities.firefox(), clazz);
        } else if ("IE".equalsIgnoreCase(browsername)) {
            dw = new RemoteLogWebDriver(service.getUrl(), DesiredCapabilities.internetExplorer(), clazz);
        } else {
            System.err.println("浏览器不支持");
            return null;
        }
        return dw;

    }

    public static void stopService() {
        if (service != null) {
            service.stop();
        }

    }
}