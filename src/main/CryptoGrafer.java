package main;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CryptoGrafer {
    public String textFromFile1;

    String sep = File.separator;

    public CryptoGrafer() {
    }

    public void codering(Path path, int answer) throws IOException {
        textFromFile1 = Files.readString(path);
        if(textFromFile1.isEmpty()){
            System.out.println("Файл для считывания текста - пустой");
        }
        String textFromFile = textFromFile1.toLowerCase();
        ArrayList<Character> newArray = new ArrayList<>();
        char[] array = textFromFile.toCharArray();
        int b = 0;

        ArrayList<Character> array11 = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            array11.add(array[i]);
        }

        for (int a = 0; a < array11.size(); a++) {
            if (Alphavit.alphavitAsList.contains(array11.get(a))) {
                b = Alphavit.alphavitAsList.indexOf(array11.get(a));
                b = b + answer;

                if (b > (Alphavit.alphavitAsList.size() - 1)) {
                    newArray.add(Alphavit.alphavitAsList.get(b - Alphavit.alphavitAsList.size()));
                } else if (b < 0) {
                    newArray.add(Alphavit.alphavitAsList.get(Alphavit.alphavitAsList.size() - Math.abs(b)));
                } else
                    newArray.add(Alphavit.alphavitAsList.get(b));
                  }
            }

        StringBuilder builder = new StringBuilder(newArray.size());
        for (Character ch : newArray) {
            builder.append(ch);
        }
        String result = new String(builder);
        System.out.println("Зашифрованный текст помещен в файл: output.txt");
        File file = new File("src" + sep + "main" + sep + "outputText.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(result);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

