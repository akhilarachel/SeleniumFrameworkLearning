package com.sd.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataReader {
    Properties pro;

    public ConfigDataReader (){
        File src = new File("./Config/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Error while accessing file: " +e.getMessage());;
        }
    }

    public String getData(String keyValue){
        return pro.getProperty(keyValue);
    }

    public String getBrowserValue(){
        return pro.getProperty("Browser");
    }

    public String getTestUrl(){
        return pro.getProperty("TestURL");
    }
}
