package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Для выхода из калькулятора введите 'exit'\n");
        while(true) {

            try{
                Scanner in = new Scanner(System.in);
                System.out.print("Введите выражение без пробелов: ");
                String userInput = in.nextLine();

                if (userInput.equals("exit") ) {
                    break;
                }

                Expression expr = new Expression(userInput);
                String[] splitedString = expr.splitExpression();

                InputedString input = new InputedString(splitedString);
                String[] checkedInput = input.checkString();

                String stringFirstOperand = checkedInput[0];
                String stringSecondOperand = checkedInput[2];
                String operator = checkedInput[1];


                boolean firstOperandIsRoman = RomanNumerals.isRomanNumeral(stringFirstOperand);
                boolean secondOperandIsRoman = RomanNumerals.isRomanNumeral(stringSecondOperand);

                if ( (firstOperandIsRoman && !secondOperandIsRoman) ||
                        (!firstOperandIsRoman && secondOperandIsRoman) ) {
                    System.out.print("Ошибка: операнды являются цифрами разных видов. \n");
                    continue;
                }

                int intFirstOperand;
                int intSecondOperand;

                if (firstOperandIsRoman) {
                    intFirstOperand = RomanNumerals.romanToArabic(stringFirstOperand);
                } else {
                    intFirstOperand = Integer.parseInt(stringFirstOperand);
                }

                if (secondOperandIsRoman) {
                    intSecondOperand = RomanNumerals.romanToArabic(stringSecondOperand);
                } else {
                    intSecondOperand = Integer.parseInt(stringSecondOperand);
                }

                Calculate calc = new Calculate(intFirstOperand, intSecondOperand, operator);
                int result = calc.countIt();

                if(result == 0){
                    System.out.printf("Ответ = %d \n", 0);
                    continue;
                }

                if(firstOperandIsRoman){
                    String resultRoman = RomanNumerals.arabicToRoman(result);
                    System.out.printf("Ответ = %s \n", resultRoman);
                }else{
                    System.out.printf("Ответ = %d \n", result);
                }

            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }

        }
        System.out.print("До свидания!");
    }
}