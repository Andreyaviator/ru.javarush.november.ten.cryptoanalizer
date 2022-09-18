package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Decoder {
    public String textFromOutput1;


    public Decoder() throws IOException {
    }

    public void decoder(Path path, int answer ) throws IOException {
        textFromOutput1 = Files.readString(path);
        if(textFromOutput1.isEmpty()){
            System.out.println("Файл для считывания текста - пустой");
        }
        char[] array = textFromOutput1.toCharArray();
        int c = 0;
        int b = 0;
        ArrayList<Character> newArray = new ArrayList<>();
        ArrayList<Character> array10 = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            array10.add(array[i]);
        }


        for (int i = 0; i < array.length; i++) {
            if (Alphavit.alphavitAsList.contains(array[i])) {
            b =Alphavit.alphavitAsList.indexOf(array[i]);
            c = b - answer;

                if (c < 0) {
                    newArray.add(Alphavit.alphavitAsList.get( (Alphavit.alphavitAsList.size() - Math.abs(c))));
                } else
                  newArray.add(Alphavit.alphavitAsList.get(c));
            } else
                continue;
        }
        System.out.println(newArray.size());
        for (int i = 0; i < newArray.size(); i++) {
            System.out.print(newArray.get(i));
        }
            }
        }



