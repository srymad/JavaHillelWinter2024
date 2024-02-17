package org.hw20;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {

    private FileLoggerConfiguration config;
    private FileWriter writer;

    public FileLogger(FileLoggerConfiguration config) throws IOException {
        this.config = config;
        File file = new File(config.getPath());
        this.writer = new FileWriter(file, true);
        if(!file.exists()) file.createNewFile();
    }

    public void logging(LoggingLevel level, String message) throws IOException {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));

        File file = new File(config.getPath());

        // in case of creating a new file no need to throw an exception
        if(file.length() >= config.getMaxFileSize()){
            String path = file.getParentFile().getPath() + "\\log_" + dateTime + ".txt";
            file = new File(path);
            writer = new FileWriter(file, true);
            file.createNewFile();
            System.out.println("Max size of file was reached. Rest of the data was wrote in " + file.getName());
//            throw new FileMaxSizeReachedException("Max file`s size reached\n Max size: "
//                     + config.getMaxFileSize() + "bytes | Curfile size: "
//                    + file.length() + "bytes");

        }



        String log = String.format("[%s]   [%s]   [%s]", dateTime, level, message);

        if(config.getLevel() == LoggingLevel.DEBUG){
            if(level == LoggingLevel.INFO) info(log);
            else if(level == LoggingLevel.DEBUG) debug(log);
        }
        else if(config.getLevel() == LoggingLevel.INFO && level == LoggingLevel.INFO) info(log);
    }

    public void info(String message) throws IOException {
        System.out.println(message);
        writer.write(message + "\n");
        writer.flush();
    }

    public void debug(String message) throws IOException {
        System.out.println(message);
        writer.write(message + "\n");
        writer.flush();
    }

}
