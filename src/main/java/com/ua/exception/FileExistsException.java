package com.ua.exception;

public class FileExistsException extends Exception{

    private String filename;
    
    public FileExistsException(String message, String filename) {
        super(message);
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
