package com.company;

public class Calculate {
    int firstMember;
    int secondMember;
    String operator;

    Calculate(int fm, int sm, String op){
        firstMember = fm;
        secondMember = sm;
        operator = op;
    }

    public int countIt() throws Exception {

        if(operator.equals("+")){
            return firstMember + secondMember;
        }else if(operator.equals("-")){
            return firstMember - secondMember;
        }else if(operator.equals("/")){
            return firstMember / secondMember;
        }else if(operator.equals("*")){
            return firstMember * secondMember;
        }else{
            throw new Exception("Некорректный оператор.");
        }
    }
}
