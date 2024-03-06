package dict;

import myexceptions.FileReadException;
import myexceptions.InvalidFileFormatException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Dict {
    private Map<String, String> dictionary;
    public Dict() {
        dictionary = new HashMap<>();
    }
    public void addWord(String r, String e) {
        if(dictionary.isEmpty()){
            dictionary.put(e, r);
        }
        else{
            for( Map.Entry<String, String> entry : dictionary.entrySet()){
                if(entry.getKey().equals(e)){
                    if (entry.getValue().length()<r.length()){
                        dictionary.put(entry.getKey(), r);
                        return;
                    }
                }
            }
            dictionary.put(e, r);
        }
    }
    public void translateText(String path) throws FileReadException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            StringBuilder bLine = new StringBuilder(line);
            String word = "";
            StringBuilder wordBuilder = new StringBuilder(word);
            while(!("null".equals(bLine.toString()))) {
                while (!bLine.isEmpty()) {
                    int i = bLine.toString().indexOf(" ");
                    if (i == -1) {
                        if (!bLine.isEmpty()) {
                            wordBuilder.delete(0, wordBuilder.length());
                            wordBuilder.insert(wordBuilder.length(), bLine);
                            if (this.getTranslation(wordBuilder.toString()).equals("null")) {
                                bLine.delete(0, bLine.length());
                            } else {
                                System.out.println(this.getTranslation(wordBuilder.toString()) + " ");
                                bLine.delete(0, bLine.length());
                            }
                        }
                    } else {
                        wordBuilder.delete(0, wordBuilder.length());
                        wordBuilder.insert(wordBuilder.length(), bLine.toString().substring(0, i));
                        if (this.getTranslation(wordBuilder.toString()).equals("null")) {
                            bLine.delete(0, i + 1);
                        } else {
                            System.out.print(this.getTranslation(wordBuilder.toString()) + " ");
                            bLine.delete(0, i + 1);
                        }
                    }
                }
                bLine.delete(0, bLine.length());
                bLine.insert(bLine.length(), reader.readLine());
            }
        }catch (IOException e) {
            throw new FileReadException("ошибка при чтении файла для перевода");
        }
    }
    public String getTranslation(String k){
        for( Map.Entry<String, String> entry : dictionary.entrySet()){
            if(entry.getKey().equalsIgnoreCase(k)){
                return entry.getValue();
            }
        }
        return "null";
    }

    public void load(String path) throws InvalidFileFormatException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            StringBuilder bLine = new StringBuilder(line);
            String word = "";
            String trns = "";
            StringBuilder wordBuilder = new StringBuilder(word);
            StringBuilder trnsBuilder = new StringBuilder(trns);
            int i = -1;
            while(!("null".equals(bLine.toString()))){
                i = bLine.toString().indexOf("|");
                wordBuilder.delete(0, wordBuilder.length());
                trnsBuilder.delete(0, trnsBuilder.length());
                wordBuilder.insert(wordBuilder.length(), bLine.toString().substring(0, i-1));
                trnsBuilder.insert(trnsBuilder.length(), bLine.toString().substring(i+2, bLine.toString().length()));
                this.addWord(wordBuilder.toString(), trnsBuilder.toString());
                bLine.delete(0, bLine.length());
                bLine.insert(bLine.length(), reader.readLine());
            }
        } catch (IOException e) {
            throw new InvalidFileFormatException("ошибка при чтении словаря");
        }
    }
}
