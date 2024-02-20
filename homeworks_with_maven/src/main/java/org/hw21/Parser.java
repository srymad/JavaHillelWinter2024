package org.hw21;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.commons.io.FilenameUtils;
import org.hw21.Entity.Employee;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class Parser {

    private static final String path =
            "C:\\Users\\zasd4\\" +
            "Documents\\demo\\JavaHillelWinter2024\\" +
            "homeworks_with_maven\\src\\main\\" +
            "java\\org\\hw21\\converted";

    private FileWriter writer;

    public Parser(String pathD) throws IOException {
        File[] files = new File(pathD).listFiles();
        this.writer = new FileWriter
                ("C:\\Users\\zasd4\\" +
                        "Documents\\demo\\JavaHillelWinter2024\\" +
                        "homeworks_with_maven\\src\\main\\" +
                        "java\\org\\hw21\\result.log", true) ;
        parse(files);
    }

    private void parse(File[] files) throws IOException {
        for(File file:files){
            if(file.isFile()){
                String type = FilenameUtils.getExtension(file.getName());
                if(type.equals("json")){
                    String log = parseJsonToYaml(file);
                    if(log != null){
                        writer.write(log + "\n");
                        writer.flush();
                    }else{
                        writer.write("Something went wrong" + "\n");
                        writer.flush();
                    }

                }
                else if(type.equals("yaml")){
                    String log = parseYamlToJson(file);
                    if(log != null){
                        writer.write(log + "\n");
                        writer.flush();
                    }else{
                        writer.write("Something went wrong" + "\n");
                        writer.flush();
                    }
                }else{
                    System.out.println("Invalid file`s extension");
                }
            }
        }
    }

    private String parseJsonToYaml(File file) throws IOException {
        long timeStart = System.currentTimeMillis();

        String jsonStr = readToString(file.getPath());
        JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonStr);
        String yamlStr = new YAMLMapper().writeValueAsString(jsonNodeTree);

        File yaml = new File(path + "/" + FilenameUtils.removeExtension(file.getName()) + ".yaml");
        Yaml yaml1 = new Yaml(new Constructor(Employee[].class));

        Employee[] employees = yaml1.load(yamlStr);
        yaml.createNewFile();

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.writeValue(yaml, employees);

        if(yaml.exists()){
            return "%s -> %s, %d milliseconds, %d bytes -> %d bytes".formatted(
                    file.getName(), yaml.getName(),
                    System.currentTimeMillis() - timeStart,
                    file.length(), yaml.length());
        }
        else return null;


    }

    private String parseYamlToJson(File file) throws IOException {
        long timeStart = System.currentTimeMillis();

        String yamlStr = readToString(file.getPath());

        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Employee[] employees = yamlReader.readValue(yamlStr, Employee[].class);

        ObjectMapper jsonWriter = new ObjectMapper();

        File json = new File(path + "/" + FilenameUtils.removeExtension(file.getName()) + ".json");
        json.createNewFile();

        jsonWriter.writerWithDefaultPrettyPrinter().writeValue(json, employees);

        if(json.exists()){
            return "%s -> %s, %d milliseconds, %d bytes -> %d bytes".formatted(
                    file.getName(), json.getName(),
                    System.currentTimeMillis() - timeStart,
                    file.length(), json.length());
        }
        else return null;



    }

    private String readToString(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
}
