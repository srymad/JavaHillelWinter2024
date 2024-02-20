package org.hw21;

import org.apache.commons.io.FilenameUtils;
import org.hw21.parser.JsonToYamlParser;
import org.hw21.parser.YamlToJsonParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class ParserManager {

    private static  final String path =
            "homeworks_with_maven/src/main/java/org/hw21/converted";

    private FileWriter writer;

    public ParserManager(String pathD) throws IOException {
        File[] files = new File(pathD).listFiles();
        this.writer = new FileWriter
                ("homeworks_with_maven/src" +
                        "/main/java/org/hw21/result.log",
                        true);
        parse(files);
    }

    private void parse(File[] files) throws IOException {
        for(File file:files){
            if(file.isFile()){
                String type = FilenameUtils.getExtension(file.getName());

                if(type.equals("json")) {
                    String log = JsonToYamlParser.parseJsonToYaml(file, path);

                    if(log != null){
                        writer.write(log + "\n");
                        writer.flush();
                    }
                    else{
                        writer.write("Something went wrong" + "\n");
                        writer.flush();
                    }
                }
                else if(type.equals("yaml")) {
                    String log =  YamlToJsonParser.parseYamlToJson(file, path);

                    if(log != null){
                        writer.write(log + "\n");
                        writer.flush();
                    }else{
                        writer.write("Something went wrong" + "\n");
                        writer.flush();
                    }

                }
                else{
                    System.out.println("Invalid file`s extension");
                }
            }
        }
    }






}
