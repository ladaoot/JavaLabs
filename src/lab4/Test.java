package lab4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.*;


public class Test {
    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("/home/ladach/ИТиП/labs/log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Test.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Person p = new Person();
        try {
            p.setAge(180);
        } catch (CustomAgeException e) {
            System.err.println(e.getMessage());
            LOGGER.log(Level.SEVERE, String.valueOf(e.fillInStackTrace()));
        }
    }
}
