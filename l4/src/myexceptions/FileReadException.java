package myexceptions;

import java.io.FileNotFoundException;

public class FileReadException extends FileNotFoundException {
    public FileReadException(String message) {
        super(message);
    }
}
