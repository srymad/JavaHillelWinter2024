package homeworks.hw11.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneDirectory {
    List<Record> records;

    public PhoneDirectory(){
        records = new ArrayList<>();
    }

    public boolean add(Record newRecord){
        if(records.contains(newRecord)){
            return false;
        }else{
            records.add(newRecord);
            return true;
        }
    }

    public Record find(String name){
        for (Record element:records) {
            if(element.getName().equals(name)){
                return element;
            }
        }

        return null;
    }

    public List<Record> findAll(String name){
        List<Record> newList = new ArrayList<>();

        for (Record element:records) {
            if(element.getName().equals(name)){
                newList.add(element);
            }
        }

        if(!newList.isEmpty()) return newList;

        return null;

    }

    @Override
    public String toString() {
        return records.toString();
    }
}
