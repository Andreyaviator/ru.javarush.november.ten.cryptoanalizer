package main;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws IOException, NoSuchElementException {

        boolean result;
        do {
            System.out.println("введите номер варианта, который Вы хотите использовать: ");
            System.out.println(" зашифровка текста - " + 1);
            System.out.println(" расшифровка текста методом: BRUTE FORCE - " + 2);
            System.out.println(" дешифровка текста - " + 3);
            System.out.println(" дешифровка текста методом: Статический анализ  - " + 4);

            String sep = File.separator;
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            if (answer <= 0) {
                System.out.println("Повторно: ВВедите текст");
            }
            if (answer < 1 || answer > 4) {
                System.out.println("Неправильно введен вариант!");
            } else {
                switch (answer) {
                    case 1: {
                        // текст для зашифровки получаем из файла inputText.txt, результат записываем в файл outputText.txt

                        System.out.println("Вы выбрали режим - зашифровать текст. ");
                        String path = "C:" + sep + "Users" + sep + "aviat" + sep + "Desktop" + sep + "ru.javarush.november.ten.cryptoanalizer" + sep + "inputText.txt";
                        Path nameOfFile = Path.of(path);
                        Coder coder = new Coder();
                        System.out.println("Введите код шифрования в диапазоне от -41 до 41 ");

                        int answer1 = scanner.nextInt();


                        if (answer1 < (-41) || answer1 > 41) {
                            System.out.println("Неправильно введен код.");
                            break;
                        }
                        coder.codering(nameOfFile, answer1);
                    }
                    break;
                    case 2: {
                        System.out.println("Вы выбрали режим - расшифровать текст методом \"Brute Force\"");
                        String path = "C:" + sep + "Users" + sep + "aviat" + sep + "Desktop" + sep + "ru.javarush.november.ten.cryptoanalizer" + sep + "outputText.txt";
                        Path nameFromFile = Path.of(path);
                        DecoderBruteForce force = new DecoderBruteForce();

                        force.decBrForce(nameFromFile);
                    }
                    break;
                    case 3: {
                        System.out.println("Вы выбрали режим - дешифровать текст");
                        System.out.println("Введите код дешифрования");
                        int answer2 = scanner.nextInt();

                        String path = "C:" + sep + "Users" + sep + "aviat" + sep + "Desktop" + sep + "ru.javarush.november.ten.cryptoanalizer" + sep + "outputText.txt";
                        Path nameFromFile = Path.of(path);
                        Decoder dec = new Decoder();
                        dec.decoder(nameFromFile, answer2);
                    }  break;
                    case 4: {
                        System.out.println("Вы выбрали режим - расшифровать текст методом \"Статического анализа\"");
                        String path = "C:" + sep + "Users" + sep + "aviat" + sep + "Desktop" + sep + "ru.javarush.november.ten.cryptoanalizer" + sep + "outputText.txt";
                        Path nameFromFile = Path.of(path);
                        DecStAnaliz analiz = new DecStAnaliz();
                        analiz.decStAn(nameFromFile);
                            }
                }

            }  // else
            System.out.println("==========================================================");
            System.out.println("Если Вы хотите продолжить, выберите предложенные варианты");
            System.out.println("1 - продолжить далее");
            System.out.println("2 - остановить");

            int answer3 = scanner.nextInt();

            if (answer3 < 1 || answer3 > 2)
                System.out.println("Введен неправильный вариант");
            else {
                if (answer3 == 1) {
                    result = true;
                } else break;
            }
        } while (result = true);


    }


}
