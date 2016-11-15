/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author Hend
 */
public class ProblemSolving {

    //removing repeated characters method
    static String stringWithoutRepetitiveCharacters(String inputString) {
        Set<Character> charactersSet = new LinkedHashSet<>();
        String result = "";
        if (inputString == null || inputString.equals("")) {
            return "";
        } else {
            charactersSet.add(inputString.charAt(0));
            for (int i = 1; i < inputString.length(); i++) {
                charactersSet.add(inputString.charAt(i));
            }
            for (char a : charactersSet) {
                result = result + a;
            }
            return result;
        }
    }

    //reverting a string method
    static String revertString(String inputString) {
        if (inputString == null) {
            return null;
        } else {
            char[] resultArray = new char[inputString.length()];
            String result = "";
            for (int i = 0; i < inputString.length(); i++) {
                resultArray[i] = inputString.charAt(inputString.length() - i - 1);
                result = result + resultArray[i];
            }
            return result;
        }
    }

    //reverting integer method
    static int revertInteger(int myInteger) {
        int result = 0;
        while (myInteger > 0) {
            int mod = myInteger % 10;
            myInteger = myInteger / 10;
            result = result * 10 + mod;
        }
        return result;
    }

    //reversing words method
    static StringBuilder reverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < words.length; i++) {
            result.append(words[words.length - 1 - i]).append(" ");
        }
        return result;
    }

    //zigzg conversion method
    static StringBuilder zigzagConvert(String text, int rows) {
        int hight = rows;
        int width = 2 * (text.length() / rows) - 1;
        int counter = 0;
        char[][] zigzag = new char[hight][width];
        StringBuilder finalResult = new StringBuilder("");
        for (int j = 0; j < width; j++) {

            for (int i = 0; i < hight; i++) {
                if (counter < text.length()) {
                    if (j % 2 == 0) {
                        zigzag[i][j] = text.charAt(counter);
                        counter++;
                    } else {
                        if (i % 2 == 0) {
                            zigzag[i][j] = ' ';
                        } else {
                            zigzag[i][j] = text.charAt(counter);
                            counter++;
                        }
                    }
                } else {
                    zigzag[i][j] = ' ';
                }
            }
        }
        for (char[] a : zigzag) {
            for (char b : a) {
                if (b != ' ') {
                    finalResult.append(b);
                }
            }
        }
        return finalResult;
    }

    public static void main(String[] args) {
        //testing removing repeated characters method
        System.out.println(stringWithoutRepetitiveCharacters("hhhheeeeendeded"));

        //testing reverting a string method
        System.out.println(revertString("abcdef"));

        //testing reverting integer method
        System.out.println(revertInteger(1234788));

        //test reversing words method
        System.out.println(reverseSentence("hi hend layla"));

        //test zigzag
        System.out.println(zigzagConvert("paypalishiring", 3));
    }

}
