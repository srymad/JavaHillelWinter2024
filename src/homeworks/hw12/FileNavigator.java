package homeworks.hw12;

import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> fileList;

    public FileNavigator() {
        fileList = new HashMap<>();
    }

    public boolean add(FileData file){
        if(!fileList.containsKey(file.getPath())){
            fileList.put(file.getPath(), new ArrayList<>(List.of(file)));

            return true;
        }

        List<FileData> tempList = fileList.get(file.getPath());
        tempList.add(file);
        fileList.put(file.getPath(), fileList.get(file.getPath()));

        return true;

    }

    public List<FileData> find(String pathFile){
        return fileList.get(pathFile);
    }

    public List<FileData> filterBySize(int capacity){
        List<FileData> tempList = new ArrayList<>();

        for (List<FileData> element: fileList.values()) {
            tempList.addAll(element);
        }

        tempList.removeIf(s -> s.getCapacity() > capacity);

        return tempList;
    }

    public boolean remove(String pathFile){
        fileList.remove(pathFile);

        return true;
    }

    public List<FileData> sortBySize(){
        List<FileData> tempList = new ArrayList<>();

        for (List<FileData> element: fileList.values()) {
            tempList.addAll(element);
        }

        Collections.sort(tempList, Comparator.comparing(FileData::getCapacity).thenComparing(FileData::getName));

        return tempList;
    }

    @Override
    public String toString() {
        return "Files: \n" + fileList;
    }
}
