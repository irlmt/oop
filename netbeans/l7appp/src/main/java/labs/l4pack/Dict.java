package labs.l4pack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dict {
    private static Map<String, String> dictionary = new HashMap<>();;
    public static void addWord(String r, String e) {
        if (dictionary.isEmpty()) {
            dictionary.put(e, r);
        } else {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                if (entry.getKey().equals(e)) {
                    if (entry.getValue().length() < r.length()) {
                        dictionary.put(entry.getKey(), r);
                        return;
                    }
                }
            }
            dictionary.put(e, r);
        }
    }

    public static String translateText(String str) {
        String translated = "";
        StringBuilder bTranslated = new StringBuilder(translated);
        StringBuilder bLine = new StringBuilder(str);
        String word = "";
        StringBuilder wordBuilder = new StringBuilder(word);
        while (!bLine.isEmpty()) {
            int i = bLine.toString().indexOf(" ");
            if (i == -1) {
                if (!bLine.isEmpty() && bLine.toString().indexOf('\n') != -1) {
                    i = bLine.toString().indexOf('\n');
                    wordBuilder.delete(0, wordBuilder.length());
                    wordBuilder.insert(wordBuilder.length(), bLine.toString().substring(0, i));
                    if (getTranslation(wordBuilder.toString()).equals("null")) {
                        bLine.delete(0, bLine.length());
                    } else {
                        bTranslated.insert(bTranslated.length(), getTranslation(wordBuilder.toString()) + " ");
                        bLine.delete(0, bLine.length());
                    }
                } else {
                    wordBuilder.delete(0, wordBuilder.length());
                    wordBuilder.insert(wordBuilder.length(), bLine);
                    if (getTranslation(wordBuilder.toString()).equals("null")) {
                        bLine.delete(0, i + 1);
                    } else {
                        bTranslated.insert(bTranslated.length(), getTranslation(wordBuilder.toString()) + " ");
                        bLine.delete(0, bLine.length());
                    }
                }
            } else {
                wordBuilder.delete(0, wordBuilder.length());
                wordBuilder.insert(wordBuilder.length(), bLine.toString().substring(0, i));
                if (getTranslation(wordBuilder.toString()).equals("null")) {
                    bLine.delete(0, i + 1);
                } else {
                    bTranslated.insert(bTranslated.length(), getTranslation(wordBuilder.toString()) + " ");
                    bLine.delete(0, i + 1);
                }
            }
        }
        return bTranslated.toString();
    }


    public static String getTranslation(String k) {
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(k)) {
                return entry.getValue();
            }
        }
        return "null";
    }

    public static void load(String str) {
        StringBuilder bLine = new StringBuilder(str);
        String word = "";
        String trns = "";
        StringBuilder wordBuilder = new StringBuilder(word);
        StringBuilder trnsBuilder = new StringBuilder(trns);
        int i = -1;
        if (!(str.equals(null))) {
            i = bLine.toString().indexOf("|");
            if (i != -1) {
                wordBuilder.delete(0, wordBuilder.length());
                trnsBuilder.delete(0, trnsBuilder.length());
                wordBuilder.insert(wordBuilder.length(), bLine.toString().substring(0, i - 1));
                trnsBuilder.insert(trnsBuilder.length(), bLine.toString().substring(i + 2, bLine.toString().length()));
                addWord(wordBuilder.toString(), trnsBuilder.toString());
            }
        }
    }
}
