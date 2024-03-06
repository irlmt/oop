package myexceptions;

import java.io.FileNotFoundException;

public class InvalidFileFormatException extends FileNotFoundException {
    public InvalidFileFormatException(String message) {
        super(message);
    }
}
