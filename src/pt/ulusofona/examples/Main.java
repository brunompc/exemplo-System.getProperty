package pt.ulusofona.examples;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void escreverFicheiro(File f, int[] numeros) {

        String newLine = System.getProperty("line.separator");

        try {

            FileWriter fw = new FileWriter(f);

            for(int i=0; i<numeros.length; i++) {
                // cuidado com
                // fw.write(numeros[i]);
                fw.write(numeros[i] + newLine);
            }
            
            fw.close();
        }
        catch(java.io.IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static List<String> lerFicheiro(File f) {

        List<String> res = new ArrayList<>();

        try {
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                res.add(linha);
            }
        }
        catch(java.io.FileNotFoundException e) {
            System.out.println(e.getStackTrace());
        }

        return res;
    }

    public static void main(String[] args) {

        int[] numeros = new int[]{1, 34, 2};

        File f = new File("resultado.txt");

        escreverFicheiro(f, numeros);

        List<String> linhas = lerFicheiro(f);

        for(String linha : linhas) {
            System.out.println(linha);
        }
    }
}
