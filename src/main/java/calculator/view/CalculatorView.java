package calculator.view;


import calculator.domain.CalculatorNumber;

public class CalculatorView {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void displayOutput() {
        outputView.printMessage();
    }

    public String displayInput() {
        return inputView.input();
    }

    public void displayAnswer(CalculatorNumber calculatorNumber) {
        outputView.printAnswer(calculatorNumber);
    }
}