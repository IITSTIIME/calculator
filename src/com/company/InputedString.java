package com.company;

public class InputedString {
    String[] userInput;
    static String [] validCharacters = { "I" , "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",  "X",
                                         "0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                                         "+", "-", "/", "*"};

    InputedString(String [] s){
        userInput = s;
    }

    public String [] checkString() throws Exception {
        int validCount = 0;

        for(int i = 0; i < userInput.length; i++){
            for(int j = 0; j < validCharacters.length; j++){
                if(userInput[i].equals(validCharacters[j]))
                validCount++;
            }
        }

        if(userInput.length != validCount){
            throw new Exception("В выражении присутствует некорректные символы.");
        }

        return userInput;
    }

}
