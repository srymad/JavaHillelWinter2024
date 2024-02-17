package org.hw20;

public class FileMaxSizeReachedException extends RuntimeException{
    public FileMaxSizeReachedException(String message){
        super(message);
    }
}
