package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DecoderBruteForce {
    public String textFromOutput1;

    public DecoderBruteForce() throws IOException {
    }

    public void decBrForce(Path path) throws IOException {
        textFromOutput1 = Files.readString(path);
        if(textFromOutput1.isEmpty()){
            System.out.println("Файл для считывания текста - пустой");
        }
        String textFromOutput = textFromOutput1.toLowerCase();
        char[] array = textFromOutput.toCharArray();
        int c = 0;
        int b = 0;

        ArrayList<Character> array13 = new ArrayList<>();
        char[] array1 = new char[array.length];


        for (int i = 1; i < Alphavit.alphavitAsList.size(); i++) {
            for (int j = 0; j < array.length; j++) {
                if (Alphavit.alphavitAsList.contains(array[j])) {
                    b = Alphavit.alphavitAsList.indexOf(array[j]);

                    b = b + i;

                    if (b > (Alphavit.alphavitAsList.size() - 1)) {
                        b = b % (Alphavit.alphavitAsList.size());
                        array1[j] = (Alphavit.alphavitAsList.get(b));
                    } else
                        if (b < 0) {
                        b = Alphavit.alphavitAsList.size() - Math.abs(b)-1;
                        array1[j] = (Alphavit.alphavitAsList.get(b).charValue());
                    } else
                        array1[j] = (Alphavit.alphavitAsList.get(b).charValue());
                }
            }
             for (int j = 0; j < array1.length; j++) {
                if (array1[j] == ',') {
                    int res = j + 1;
                      if(res >= array1.length) {
                          res = res - array1.length;
                      }
                         if (array1[res] == ' ') {
                           for (int k = 0; k < array1.length; k++) {
                            System.out.print(array1[k]);
                          }

                        }
                }
            }


        }
    }


}

















