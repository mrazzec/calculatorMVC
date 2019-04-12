package by.dorozhuk.calculator.entity;

public class Calculator {

    public static String sum(Operation operation){
        return (operation.getNum1() + " + " + operation.getNum2() + " = " + (operation.getNum1() + operation.getNum2()));
    }

    public static String sub(Operation operation){
        return (operation.getNum1() + " - " + operation.getNum2() + " = " + (operation.getNum1() - operation.getNum2()));
    }

    public static String mult(Operation operation){
        return (operation.getNum1() + " * " + operation.getNum2() + " = " + (operation.getNum1() * operation.getNum2()));
    }

    public static String div(Operation operation){
        return (operation.getNum1() + " / " + operation.getNum2() + " = " + (operation.getNum1() / operation.getNum2()));
    }

}
