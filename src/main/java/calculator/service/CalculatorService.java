package calculator.service;

import calculator.domain.CalculatorNumber;

import java.util.List;

public class CalculatorService {
    public void adder(CalculatorNumber calculatorNumber) {
        List<String> numbers = calculatorNumber.getNumbers();
        calculatorNumber.setAnswer(numbers.stream().mapToDouble(Double::parseDouble).sum());
    }
}