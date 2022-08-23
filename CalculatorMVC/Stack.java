package model;

public class Stack {

    private final String[] stack;
    private int tos;

    public Stack() {
        stack = new String[50];
        tos = -1;
    }

    public boolean isEmpty() {
        return (tos == -1);
    }

    public void push(String item) {
        tos = tos + 1;
        stack[tos] = item;
    }

    public String pop() {
        String buff = stack[tos];
        stack[tos] = null;
        tos = tos - 1;
        return buff;
    }

    public String peek() {
        return stack[tos];
    }
}







