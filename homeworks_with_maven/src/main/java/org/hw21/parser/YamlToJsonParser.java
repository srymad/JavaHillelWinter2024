package org.hw21.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.io.FilenameUtils;
import org.hw21.file_reader.ReadFromFile;
import org.hw21.entity.Employee;

import java.io.File;
import java.io.IOException;

public class YamlToJsonParser {

    public static String parseYamlToJson(File file, String path) throws IOException {
        long timeStart = System.currentTimeMillis();

        String yamlStr = ReadFromFile.readToString(file.getPath());

        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Employee[] employees = yamlReader.readValue(yamlStr, Employee[].class);

        ObjectMapper jsonWriter = new ObjectMapper();

        File jsonFile = new File(path + "/"
                + FilenameUtils.removeExtension(file.getName()) + ".json");
        jsonFile.createNewFile();

        jsonWriter.writerWithDefaultPrettyPrinter().writeValue(jsonFile, employees);

        if(jsonFile.exists()){
            return "%s -> %s, %d milliseconds, %d bytes -> %d bytes".formatted(
                    file.getName(), jsonFile.getName(),
                    System.currentTimeMillis() - timeStart,
                    file.length(), jsonFile.length());
        }

        else return null;
    }

}
