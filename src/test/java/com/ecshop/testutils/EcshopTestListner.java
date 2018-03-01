package com.ecshop.testutils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by amy sheng on 2/28/2018.
 */
public class EcshopTestListner extends TestListenerAdapter {
    WebDriver driver = null;

    @Override
    public void onTestFailure(ITestResult tr) {
        //拿到driver对象
        String name = tr.getMethod().getMethodName();
        Object obj = tr.getInstance();
        Class<?> clazz = obj.getClass();
        System.out.println(clazz.getName());
        try {
            Field field = clazz.getField("driver");
            driver = (WebDriver) field.get(obj);
            System.out.println(driver);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        //处理截图
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "screenshot";
        SimpleDateFormat df = new SimpleDateFormat(("yyyy_MM_dd_HH_mm_ss"));
        String filename = clazz.getName() + "." + name + "_"+df.format(new Date())+".png";
        File pathfile = new File(path, filename);
        screenshot.renameTo(pathfile);
        Reporter.log("<label style='color:read'>" + name + "执行失败，详情请查看日志,截图存放在screenshot目录</lable>");
    }
}
