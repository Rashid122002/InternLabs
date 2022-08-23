package model;

public class Notation {

    private Model model;
    private Stack stack;
    private double leftValue;
    private double rightValue;

    public Notation(Model model) {
        this.model = model;
        stack = new Stack();
        leftValue = 0.;
        rightValue = 0.;
    }

    public boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public int getPriority(String operation) {
        if (operation.equals("+") || operation.equals("-")) {
            return 1;
        } else if (operation.equals("*") || operation.equals("/") || operation.equals("%")) {
            return 2;
        } else if (operation.equals("^")) {
            return 3;
        }
        return 4;
    }

    public String toReverseNotation(String text) {
        String[] str = text.split(" ");
        text = "";
        for (String s : str) {
            if (isNumber(s)) {
                text = text + s + " ";
                continue;
            }
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%") || s.equals("^")) {
                if (stack.isEmpty()) {
                    stack.push(s);
                    continue;
                }
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(s)) {
                    text = text + stack.pop() + " ";
                }
            }

            stack.push(s);
        }

        while (!stack.isEmpty()) {
            text = text + stack.pop() + " ";
        }
        System.out.println(text);
        return toCalculateNotation(text);
    }

    public String toCalculateNotation(String text) {
        String[] values = text.split(" ");
        for (String s : values) {
            if (isNumber(s)) {
                stack.push(s);
            } else {
                rightValue = Double.parseDouble(stack.pop());
                leftValue = Double.parseDouble(stack.pop());

                switch (s) {
                    case "+":
                        stack.push((leftValue + rightValue) + "");
                        leftValue = rightValue = 0.;
                        break;
                    case "-":
                        stack.push((leftValue - rightValue) + "");
                        leftValue = rightValue = 0.;
                        break;
                    case "*":
                        stack.push((leftValue * rightValue) + "");
                        leftValue = rightValue = 0.;
                        break;
                    case "/":
                        stack.push((leftValue / rightValue) + "");
                        leftValue = rightValue = 0.;
                        break;
                    case "%": {
                        stack.push(leftValue / 100 * rightValue + "");
                        leftValue = rightValue = 0.;
                        break;
                    }
                    case "^":
                        stack.push((Math.pow(leftValue, rightValue)) + "");
                        leftValue = rightValue = 0.;
                        break;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(stack.peek());
        } else {
            System.out.println("Error!");
        }
        return stack.pop();
    }
}
