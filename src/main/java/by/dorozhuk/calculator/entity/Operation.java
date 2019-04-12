package by.dorozhuk.calculator.entity;

public class Operation {
    private Integer num1;
    private Integer num2;
    private OperationEnum type;

    public Operation(Integer num1, Integer num2, OperationEnum type) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public OperationEnum getType() {
        return type;
    }

    public void setType(OperationEnum type) {
        this.type = type;
    }
}
