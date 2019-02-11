package sample;

import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.util.ArrayList;

import java.lang.Object;
import java.io.Writer;

import static java.lang.Integer.parseInt;

public class Controller {
    public Label textOutput;
    private ArrayList<String> calculatorStream = new ArrayList<String>();

    public void updateScreen(){
        String out = "";
        for(int i = 0; i < calculatorStream.size(); i++){
            out += calculatorStream.get(i);
        }
        String [] args = new String[0];
        textOutput.setText(out);
    }
    public void selectZero(){
        calculatorStream.add("0");
        updateScreen();
    }
    public void selectOne(){
        calculatorStream.add("1");
        updateScreen();
    }
    public void selectTwo(){
        calculatorStream.add("2");
        updateScreen();
    }
    public void selectThree(){
        calculatorStream.add("3");
        updateScreen();
    }
    public void selectFour(){
        calculatorStream.add("4");
        updateScreen();
    }
    public void selectFive(){
        calculatorStream.add("5");
        updateScreen();
    }
    public void selectSix(){
        calculatorStream.add("6");
        updateScreen();
    }
    public void selectSeven(){
        calculatorStream.add("7");
        updateScreen();
    }
    public void selectEight(){
        calculatorStream.add("8");
        updateScreen();
    }
    public void selectNine(){
        calculatorStream.add("9");
        updateScreen();
    }
    public void selectPeriod(){
        calculatorStream.add(".");
        updateScreen();
    }
    public void selectAdd(){
        for(int i = 0; i < calculatorStream.size(); i++){
            if(calculatorStream.get(i).equals("+") || calculatorStream.get(i).equals("-")||
                    calculatorStream.get(i).equals("*")|| calculatorStream.get(i).equals("/")){
                submit();
            }
        }
        calculatorStream.add("+");
        updateScreen();
    }
    public void selectSubtract(){
        for(int i = 0; i < calculatorStream.size(); i++){
            if(calculatorStream.get(i).equals("+") || calculatorStream.get(i).equals("-")||
                    calculatorStream.get(i).equals("*")|| calculatorStream.get(i).equals("/")){
                submit();
            }
        }
        calculatorStream.add("-");
        updateScreen();
    }
    public void selectDivide(){
        for(int i = 0; i < calculatorStream.size(); i++){
            if(calculatorStream.get(i).equals("+") || calculatorStream.get(i).equals("-")||
                    calculatorStream.get(i).equals("*")|| calculatorStream.get(i).equals("/")){
                submit();
            }
        }
        calculatorStream.add("/");
        updateScreen();
    }
    public void selectMultiply(){
        for(int i = 0; i < calculatorStream.size(); i++){
            if(calculatorStream.get(i).equals("+") || calculatorStream.get(i).equals("-")||
                    calculatorStream.get(i).equals("*")|| calculatorStream.get(i).equals("/")){
                submit();
            }
        }
        calculatorStream.add("*");
        updateScreen();
    }
    public void displayError(){
        textOutput.setText(new String("Error"));
    }
    public void clear(){
        calculatorStream.clear();
        updateScreen();
    }
    public int submit(){
        System.out.println("Submitting");
        String filepath = "src/sample/csvfile.txt";
        String operator = "";
        String i1 = "";
        String i2 = "";
        String total = "";
        for(int i = 0; i < calculatorStream.size(); i++){
            if(calculatorStream.get(i).equals("+") || calculatorStream.get(i).equals("-") ||
                    calculatorStream.get(i).equals("/")|| calculatorStream.get(i).equals("*")){
                operator = calculatorStream.get(i);
            }else{
                if(operator.equals("")){
                    i1 += calculatorStream.get(i);
                }else{
                    i2 += calculatorStream.get(i);
                }
            }
        }
        System.out.println(i1);
        System.out.println(i2);
        calculatorStream.clear();
        if(operator.equals("") || i1.equals("") || i2.equals("")){
            System.out.println("Error");
            CSVWriter.submitRecord("Error", filepath);
            displayError();
            return 0;
        }
        char oper = operator.charAt(0);
        double val, rounded;
        switch(oper){
            case '+':
                 val = (Double.parseDouble(i1) + Double.parseDouble(i2));
                 rounded = Math. round(val * 1000.0) / 1000.0;
                calculatorStream.add(Double.toString(rounded));
                total = calculatorStream.get(0);
                break;
            case '-':
                 val = (Double.parseDouble(i1) - Double.parseDouble(i2));
                 rounded = Math. round(val * 1000.0) / 1000.0;
                calculatorStream.add(Double.toString(rounded));
                total = calculatorStream.get(0);
                break;
            case '/':
                 val = (Double.parseDouble(i1) / Double.parseDouble(i2));
                 rounded = Math. round(val * 1000.0) / 1000.0;
                calculatorStream.add(Double.toString(rounded));
                total = calculatorStream.get(0);
                break;
            case '*':
                 val = (Double.parseDouble(i1) * Double.parseDouble(i2));
                 rounded = Math. round(val * 1000.0) / 1000.0;
                calculatorStream.add(Double.toString(rounded));
                total = calculatorStream.get(0);
                break;
        }
        /*if(operator.equals("+")){
            calculatorStream.add(Integer.toString((parseInt(i1) + parseInt(i2))));
        }
        if(operator.equals("-")){
            calculatorStream.add(Integer.toString((parseInt(i1) - parseInt(i2))));
        }
        if(operator.equals("/")){
            calculatorStream.add(Integer.toString((parseInt(i1) / parseInt(i2))));
        }
        if(operator.equals("*")){
            calculatorStream.add(Integer.toString((parseInt(i1) * parseInt(i2))));
        }*/
        String out = i1 + operator + i2 + "=" + total;
        CSVWriter.submitRecord(out, filepath);
        updateScreen();
        return 0;

    }
}
