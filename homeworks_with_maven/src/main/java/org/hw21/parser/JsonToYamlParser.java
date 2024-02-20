package org.hw21.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.commons.io.FilenameUtils;
import org.hw21.file_reader.ReadFromFile;
import org.hw21.entity.Employee;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.IOException;

public class JsonToYamlParser {

    public static String parseJsonToYaml(File file, String path) throws IOException {
        long timeStart = System.currentTimeMillis();

        String jsonStr = ReadFromFile.readToString(file.getPath());
        JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonStr);
        String yamlStr = new YAMLMapper().writeValueAsString(jsonNodeTree);

        File yamlFile = new File(path + "/"
                + FilenameUtils.removeExtension(file.getName()) + ".yaml");
        Yaml yaml = new Yaml(new Constructor(Employee[].class));

        Employee[] employees = yaml.load(yamlStr);
        yamlFile.createNewFile();

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.writeValue(yamlFile, employees);

        if(yamlFile.exists()){
            return "%s -> %s, %d milliseconds, %d bytes -> %d bytes".formatted(
                    file.getName(), yamlFile.getName(),
                    System.currentTimeMillis() - timeStart,
                    file.length(), yamlFile.length());
        }

        else return null;
    }

}
