import java.io.*;
import java.util.*;

class stack {
    int size;
    int item[];
    int top;

    public stack() {
        size = 100;
        item = new int[size];
        top = -1;
    }

    public void push(int ele) {
        if (top == (size - 1)) {
            System.out.println("Stack Overflow");
        } else {
            top++;
            item[top] = ele;
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("No Elements");
            return -1;
        } else {
            int x = item[top];
            top--;
            return x;
        }
    }

    public int peek() {
        if (top == -1) {
            System.out.println("No Elements");
            return -1;
        } else {
            return item[top];
        }
    }

    public void display() {
        System.out.println();
        if (top == -1) {
            System.out.println("No Elements");
        } else {
            System.out.println("Stack is");
            for (int i = 0; i <= top; i++)
                System.out.println(item[i]);
        }
    }
}

class evalpostfix {
    stack st = new stack();
    String postfix;

    public evalpostfix(String str) {
        postfix = str;
    }

    public boolean isOperand(char ch) {
        return Character.isDigit(ch); // Checks if the character is a digit
    }

    public int eval() {
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            if (isOperand(ch)) {
                st.push(ch - '0'); // Convert char digit to integer
            } else {
                int val2 = st.pop();
                int val1 = st.pop();

                switch (ch) {
                    case '+':
                        st.push(val1 + val2);
                        break;
                    case '-':
                        st.push(val1 - val2);
                        break;
                    case '*':
                        st.push(val1 * val2);
                        break;
                    case '/':
                        st.push(val1 / val2);
                        break;
                    default:
                        System.out.println("Invalid operator");
                        return -1;
                }
            }
        }
        return st.pop(); // Final result
    }
}

public class Postfixeval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter postfix string");
        String str = sc.nextLine();
        evalpostfix epf = new evalpostfix(str);
        System.out.println("Result:" + epf.eval());
        sc.close();
    }
}