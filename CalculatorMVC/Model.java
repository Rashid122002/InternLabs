package model;

import view.Viewer;

public class Model {

    private final Viewer viewer;
    private final Notation notation;
    private String temp;
    private String result;
    private double digital;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        notation = new Notation(this);
        temp = "";
        result = "";
        digital = 0.;
    }

    public String checkDot(String s) {
        if (!s.equals("")) {
            if (!s.contains(".")) {
                s = s + ".";
            }
        }
        return s;
    }

    public String delDotAndZero(String s) {
        if (!s.equals("")) {
            if (s.endsWith(".0")) {
                s = s.substring(0, s.length() - 2);
            }
        }
        return s;
    }

    public String oneDivX(String s) {
        if (!s.equals("")) {
            digital = Double.parseDouble(s);
            digital = 1. / digital;
            s = digital + "";
            digital = 0.;
        }
        return s;
    }

    public String sqrtX(String s) {
        if (!s.equals("")) {
            digital = Double.parseDouble(s);
            digital = Math.sqrt(digital);
            s = digital + "";
            digital = 0.;
        }
        return s;
    }

    public void doAction(String command) {

        switch (command) {

            case "zero":
                temp = temp + "0";
                break;

            case "one":
                temp = temp + "1";
                break;

            case "two":
                temp = temp + "2";
                break;

            case "three":
                temp = temp + "3";
                break;

            case "four":
                temp = temp + "4";
                break;

            case "five":
                temp = temp + "5";
                break;

            case "six":
                temp = temp + "6";
                break;

            case "seven":
                temp = temp + "7";
                break;

            case "eight":
                temp = temp + "8";
                break;

            case "nine":
                temp = temp + "9";
                break;

            case "division":
                if (!temp.equals("")) {
                    result = result + temp + " / ";
                    temp = "";
                }
                return;

            case "mult":
                if (!temp.equals("")) {
                    result = result + temp + " * ";
                    temp = "";
                }
                return;

            case "minus":
                if (!temp.equals("")) {
                    result = result + temp + " - ";
                    temp = "";
                }
                return;

            case "plus":
                if (!temp.equals("")) {
                    result = result + temp + " + ";
                    temp = "";
                }
                return;

            case "percent":
                if (!temp.equals("")) {
                    result = result + temp + " % ";
                    temp = "";
                }
                return;

            case "xsquare":
                if (!temp.equals("")) {
                    result = result + temp + " ^ ";
                    temp = "";
                }
                return;

            case "del":
                if (!temp.equals("")) {
                    temp = temp.substring(0, temp.length() - 1);
                }
                break;

            case "ce":
                temp = "";
                break;

            case "c":
                temp = result = "";
                break;

            case "plusMinus":
                if (!temp.equals("")) {
                    digital = Double.parseDouble(temp);
                    digital = digital * -1;
                    temp = delDotAndZero(digital + "");
                    digital = 0.;
                }
                break;

            case "dot":
                temp = checkDot(temp);
                break;

            case "oneDelX":
                temp = delDotAndZero(oneDivX(temp));
                break;

            case "sqrt":
                temp = delDotAndZero(sqrtX(temp));
                break;

            case "equal":
                if (!temp.equals("")) {
                    temp = delDotAndZero(notation.toReverseNotation(result + temp));
                    result = "";
                }
                break;
        }
        viewer.update(temp);
    }
}                     