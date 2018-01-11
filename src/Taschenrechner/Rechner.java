package Taschenrechner;

public class Rechner {
    private double operandA = 0D;
    private double operandB = 0D;
    private String operation = null;
    private double ergebnis = 0D;

    public void setOperandA(double operandA) {
        this.operandA = operandA;
    }

    public void setOperandB(double operandB) {
        this.operandB = operandB;
    }

    public void setOperation(String operation) {
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
        this.operation = null;
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
