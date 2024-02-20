package org.hw20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class FileLoggerConfigurationLoader {
    public static FileLoggerConfiguration load(File file) throws IOException {
        String path = null;
        LoggingLevel level = LoggingLevel.INFO;
        Long maxSize = null;
        String format = null;

        //determining file`s logging level
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null){
            if(line.contains("DEBUG")){
                level = LoggingLevel.DEBUG;
                break;
            }
        }

        path = file.getPath();
        maxSize = file.length();

        //determining file`s format
        String type = Files.probeContentType(file.toPath());
        if (type == null) {
            format = "binary";
        }
        else {
            format = type;
        }

        return new FileLoggerConfiguration(path, level, maxSize, format);
    }
}
