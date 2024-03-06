import dict.Dict;
import myexceptions.FileReadException;
import myexceptions.InvalidFileFormatException;
public class Main {
    public static void main(String[] args) {
        Dict d = new Dict();
        try{
            d.load("dict.txt");
            d.translateText("text.txt");
        }catch (InvalidFileFormatException | FileReadException e){
            System.err.println(e.getMessage());
        }
    }
}