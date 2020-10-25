package com.company;

public class Expression {
    String userInput;

    Expression(String s){
        userInput = s;
    }

    public String [] splitExpression () throws Exception {
        char[] array = userInput.toCharArray();
        int indexOfoperator = -1;
        String firstMember;
        String secondMember;
        String operator;


        for(int i = 0; i < array.length; i++){
            if(array[i] == '+' ||  array[i] == '-' || array[i] == '/' || array[i] == '*'){
                indexOfoperator = i;
                break;
            }
        }
        if(indexOfoperator == -1){
            throw new Exception("Оператор не найден.");
        }

        firstMember = userInput.substring(0, indexOfoperator);
        secondMember = userInput.substring(indexOfoperator+1, userInput.length());
        operator = userInput.substring(indexOfoperator, indexOfoperator+1);

        String [] result = { firstMember, operator, secondMember};

        return result;
    }
}
