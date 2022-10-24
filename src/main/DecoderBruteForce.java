package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

 class DecoderBruteForce {

     DecoderBruteForce() throws IOException {
     }

     void decBrForce(Path path) throws IOException {
         String textFromOutput1 = Files.readString(path);
         if (textFromOutput1.isEmpty()) {
             System.out.println("Файл для считывания текста - пустой");
         }
         String textFromOutput = textFromOutput1.toLowerCase();
         char[] array = textFromOutput.toCharArray();
         int b = 0;
         char[] array1 = new char[array.length];
         boolean isAnswer;
             for (int i = 1; i < Alphavit.alphavitAsList.size(); i++) {
                 for (int j = 0; j < array.length; j++) {
                     if (Alphavit.alphavitAsList.contains(array[j])) {
                         b = Alphavit.alphavitAsList.indexOf(array[j]);
                         b = b + i;
                         if (b > (Alphavit.alphavitAsList.size() - 1)) {
                             b = b % (Alphavit.alphavitAsList.size());
                             array1[j] = (Alphavit.alphavitAsList.get(b));
                         } else {
                             if (b < 0) {
                                 b = Alphavit.alphavitAsList.size() - Math.abs(b) - 1;
                             }
                             array1[j] = (Alphavit.alphavitAsList.get(b));
                         }
                     }
                 }
                 int res = 0;
                 for (int k = 0; k < array1.length; k++) {
                     if (array1[k] == ',') {
                         res = k + 1;
                         if (res >= array1.length) {
                             res = res - array1.length;
                         }
                           if (array1[res] == ' ') {
                               for (int a = 0; a < array1.length; a++) {
                                   System.out.print(array1[a]);
                               }
                                       System.out.println();
                                       System.out.println("Вас устраивает данный вариант расшифровки?");
                                       System.out.println("Выберите 1 - устраивает; 2 - нет");
                                       Scanner sc11 = new Scanner(System.in);
                                       int nn = sc11.nextInt();
                                       if (nn == 2) {
                                           break; //   isAnswer = true;    //
                                       } else
                                         { if(nn==1)
                                          return;
                                          }
                           }
                     }
                 }


             }
     }
 }


















