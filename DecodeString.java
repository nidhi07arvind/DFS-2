//TC: O(N) N - length of the string. We traverse the whole string
//SC: O(N) 
//We are keeping track of current number and cur string. 
//When we encounter '[', push both current number and string to stack and reset.
//when a letter is found, current string is generated.
//On getting ']', number is popped from stack to know the repetitions. a new curString is generated by appending string in top of the stack.
//Repeat the process.


import java.util.*;

public class DecodeString {
    public static String decodeString(String s) {
       
        Stack<String> wordStk = new Stack<>();
        Stack<Integer> numStk = new Stack<>();
        
        int curNum = 0;
        String curStr = "";
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                curNum = curNum * 10 + (c - '0');
            }else if(c == '['){
                numStk.push(curNum);
                wordStk.push(curStr);
                curNum = 0;
                curStr = "";
            }else if(c == ']'){
                curNum = numStk.pop();
                String temp = curStr.repeat(curNum);
                curStr = wordStk.pop();
                curStr = curStr + temp;
                curNum = 0;
            }else{
                curStr = curStr + c;
            }
        }
        return curStr;
    }

    public static void main(String[] args){
        String s = "3[a2[b4[c]]]";
        System.out.println(decodeString(s));
    }
}
