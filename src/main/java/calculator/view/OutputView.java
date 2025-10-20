package calculator.view;

import calculator.domain.CalculatorNumber;

public class OutputView {
    public void printMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void printAnswer(final CalculatorNumber calculatorNumber) {
        Double answer = calculatorNumber.getAnswer();
        if (calculatorNumber.getIsInteger()) {
            System.out.println("결과 : "+ answer.intValue());
        }
        else {
            System.out.println("결과 : " + answer);
        }
    }
}