package com.practic.common;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;

import java.util.Stack;

public class BalanceParenthesis {
    public static void main(String[] args) {
        String str ="({})[]";

        Stack<Character> characterStack = new Stack<>();

        for(int i =0; i<str.length(); i++){

            switch (str.charAt(i)){
                case '{':
                case '[':
                case '(':
                    characterStack.push(str.charAt(i));
                    break;
                case ')':
                    if(characterStack.size() == 0){
                        System.out.println("Parenthesis are not balanced");
                        break;
                    }
                    Character pop = characterStack.pop();
                    if(pop != '('){
                        System.out.println("Parenthesis are not balanced");
                    }
                    break;

                case '}':
                    if(characterStack.size() == 0){
                        System.out.println("Parenthesis are not balanced");
                        break;
                    }
                    Character pop1 = characterStack.pop();
                    if(pop1 != '{'){
                        System.out.println("Parenthesis are not balanced");
                    }
                    break;
                case ']':
                    if(characterStack.size() == 0){
                        System.out.println("Parenthesis are not balanced");
                        break;
                    }
                    Character pop2 = characterStack.pop();
                    if(pop2 != '['){
                        System.out.println("Parenthesis are not balanced");
                    }
                    break;

                default:
                    System.out.println("Parenthesis are not balanced");
                    break;

            }
        }

        if(characterStack.size() == 0){
            System.out.println("Parenthesis are  balanced");
        }else{
            System.out.println("Parenthesis are not balanced");
        }
    }
}
