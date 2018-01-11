package Taschenrechner;

public class Rechner {
    private double operandA = 0D;
    private double operandB = 0D;
    private String operation = "";
    private double ergebnis = 0D;

    public void setOperandA(double operandA) {
        this.operandA = operandA;
    }

    public void setOperandB(double operandB) {
        this.operandB = operandB;
    }

    public void setOperation(String operation) {
        setOperandA(this.ergebnis);

        if(!(this.operation.length()==0)) {
            this.executeOperation();
        } else {
            this.ergebnis = this.operandB;
        }
        this.operation = operation;
    }

    public double getErgebnis() {
        return ergebnis;
    }

    public void executeOperation() {
        switch (this.operation) {
            case "+":
                this.ergebnis = operationAdd();
                break;
            case "-":
                this.ergebnis = operationSubtract();
                break;
        }
    }

    public void clear() {
        this.operandA = this.operandB = this.ergebnis = 0D;
        this.operation = "";
    }

    private double operationAdd() {
        return operandA + operandB;
    }

    private double operationSubtract() {
        return operandA - operandB;
    }

    @Override
    public String toString() {
        return "" + operandA + operation + operandB + "=" + ergebnis;
    }
}
