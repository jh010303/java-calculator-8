package calculator.controller;

import calculator.domain.CalculatorNumber;
import calculator.service.CalculatorExtractorService;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {
    private final CalculatorExtractorService calculatorExtractorService = new CalculatorExtractorService();
    private final CalculatorService calculatorService = new CalculatorService();
    private final CalculatorView calculatorView = new CalculatorView();
    private final CalculatorNumber calculatorNumber = new CalculatorNumber();

    public void run() {
        calculatorView.displayOutput();
        String request = calculatorView.displayInput();

        calculatorExtractorService.setDelimiter(request, calculatorNumber);
        calculatorExtractorService.setNumbers(request, calculatorNumber);
        calculatorService.adder(calculatorNumber);
        calculatorView.displayAnswer(calculatorNumber);
    }
}