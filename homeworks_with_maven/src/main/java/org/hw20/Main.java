package org.hw20;

import java.io.File;
import java.io.IOException;

public class Main {

    public static final String absolutePath = "C:/Users/zasd4/Documents/demo/JavaHillelWinter2024/homeworks_with_maven/src/main/java/org/hw20";
    public static void main(String[] args) throws IOException {

        //csv file
        FileLoggerConfiguration config = new FileLoggerConfiguration(absolutePath + "/log_csv.csv",
                LoggingLevel.DEBUG, 32L, "text/plain");
        FileLogger fileLogger = new FileLogger(config);

        fileLogger.logging(LoggingLevel.DEBUG, "test debug");
        fileLogger.logging(LoggingLevel.INFO, "test info");

        //txt file
        FileLoggerConfiguration config2 = new FileLoggerConfiguration(absolutePath + "/log_txt.txt",
                LoggingLevel.INFO, 8096L, "/csv");
        FileLogger fileLogger2 = new FileLogger(config2);

        fileLogger2.logging(LoggingLevel.DEBUG, "test debug");
        fileLogger2.logging(LoggingLevel.INFO, "test info");

        //FileLoggerConfigurationLoader
        System.out.println(FileLoggerConfigurationLoader.load
                (new File(absolutePath + "/log_csv.csv")).toString());
        System.out.println(FileLoggerConfigurationLoader.load
                (new File(absolutePath + "/log_txt.txt")).toString());



    }

}
